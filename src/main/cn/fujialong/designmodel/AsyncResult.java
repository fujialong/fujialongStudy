package cn.fujialong.designmodel;

import java.util.concurrent.ExecutionException;

/**
 * @author fujialong
 */
public interface AsyncResult<T> {

    /**
     * 异步执行的状态
     *
     * @return boolean
     */
    boolean isComplete();

    /**
     * 获取完成异步状态的值
     *
     * @return T
     * @throws ExecutionException
     */
    T getValue() throws ExecutionException;


    /**
     * 阻止当前线程，直到异步线程完成
     *
     * @throws InterruptedException 如果执行被中断则抛出
     */
    void await() throws InterruptedException;
}
