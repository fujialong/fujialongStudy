package cn.fujialong.balking;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @program: fujialongStudy
 * @description: 洗衣机
 * @author: fujialong
 * @create: 2018-06-28 21:00
 **/
public class WashingMachine {
    private static final Logger logger = LoggerFactory.getLogger(WashingMachine.class);

    private WashingMachineState washingMachineState;

    public WashingMachine() {
        washingMachineState = WashingMachineState.ENABLED;
    }

    public WashingMachineState getWashingMachineState() {
        return washingMachineState;
    }

    /**
     *如果对象处于适当的状态就开始执行洗的方法
     */
    public void wash(){
        synchronized (this) {
            logger.info("{}:Actual machine state :{}",Thread.currentThread().getName(),getWashingMachineState());

            if (washingMachineState == WashingMachineState.WASHING) {
                logger.error("ERROR Cant wash if zhe machine has been already washing");
                return;
            }

            washingMachineState = WashingMachineState.WASHING;
        }
        logger.info("{}: Doing the washing", Thread.currentThread().getName());

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 结束洗衣的方法
     * 通过改变状态
     */
    public synchronized void endOfWashing() {
        washingMachineState = WashingMachineState.ENABLED;
        logger.info("{} ",Thread.currentThread().getId());
    }
}
