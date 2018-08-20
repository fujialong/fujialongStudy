package cn.fujialong.designmodel;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * AsyncExecutor 接口
 *
 * @author fujialong
 */
public interface AsyncExecutor {

    /**
     * 开始处理异常，返回处理结果
     *
     * @param task 任务异步执行
     * @return T 任务的异步结果
     */
    <T> AsyncResult<T> startProcess(Callable<T> task);

    /**
     * 开始处理异步任务，立即返回异步结果，任务完成时执行回掉
     *
     * @param task     异步执行的任务
     * @param callback 回调函数
     * @return 执行结果
     */
    <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback callback);

    /**
     * 结束异步处理,根据需要阻止当前线程
     * @param asyncResult 任务的异步结果
     * @return 已完成的任务的值
     * @throws ExecutionException 如果任务执行失败
     * @throws InterruptedException 如果任务执行中断
     */
    <T> T endProcess(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException;

}
