package cn.fujialong.designmodel;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: fujialongStudy
 * @description: 实现异步执行器，为每个任务创建新的线程
 * @author: fujialong
 * @create: 2018-06-25 21:38
 **/
public class ThreadAsyncExecutor implements AsyncExecutor {

    /**
     * 线程命名索引
     */
    private final AtomicLong idx = new AtomicLong(0);

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task) {
        return startProcess(task, null);
    }

    @Override
    public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback callback) {
        CompletableResult<T> result = new CompletableResult<>(callback);
        new Thread(() -> {
            try {
                result.setValue(task.call());
            } catch (Exception exception) {
                result.setException(exception);
            }
        },"executor-" + idx.incrementAndGet()).start();
        return result;
    }

    @Override
    public <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException {
        if (!asyncResult.isComplete()) {
            asyncResult.wait();
        }
        return asyncResult.getValue();
    }

    /**
     * 简单的实现一个异步结果，允许用一个值成功完成它，
     */
    private static class CompletableResult<T> implements AsyncResult<T> {
        static final int RUNNING = 1;
        static final int FAILED = 2;
        static final int COMPLETED = 3;
        public static final String NO_FINISH = "执行没有完成";

        final Object lock;
        final Optional<AsyncCallback<T>> callback;

        volatile int state = RUNNING;
        T value;
        Exception exception;

        private CompletableResult(AsyncCallback<T> callback) {
            this.lock = new Object();
            this.callback = Optional.ofNullable(callback);
        }

        /**
         * 设置成功执行的值，并执行回调（如果可用）。通知任何等待的线程完成
         *
         * @param value 值
         */
        void setValue(T value) {
            this.value = value;
            this.state = COMPLETED;
            this.callback.ifPresent(ac -> ac.onComplete(value, Optional.<Exception>empty()));
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        /**
         * 设置失败执行，并执行回调（如果可用）。通知任何等待的线程
         */
        void setException(Exception exception) {
            this.exception = exception;
            this.state = FAILED;
            this.callback.ifPresent(ac -> ac.onComplete(null, Optional.of(exception)));
            synchronized (lock) {
                lock.notifyAll();
            }
        }

        @Override
        public boolean isComplete() {
            return state > RUNNING;
        }

        @Override
        public T getValue() throws ExecutionException {
            if (state == COMPLETED) {
                return value;
            } else if (state == FAILED) {
                throw new ExecutionException(exception);
            } else {
                throw new IllegalStateException(NO_FINISH);
            }
        }

        @Override
        public void await() throws InterruptedException {
            synchronized (lock) {
                if (!isComplete()) {
                    lock.wait();
                }
            }
        }
    }
}
