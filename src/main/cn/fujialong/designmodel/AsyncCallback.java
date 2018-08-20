package cn.fujialong.designmodel;

import java.util.Optional;

/**
 * 异步回调接口
 *
 * @author fujialong
 */
public interface AsyncCallback<T> {

    /**
     * 任务处理完成或者出错执行的接口
     *
     * @param value             来自异步执行的值，执行失败是为定义，
     *                          如果执行成功
     * @param exceptionOptional 空值，如果执行失败则抛出异常
     */
    void onComplete(T value, Optional<Exception> exceptionOptional);
}
