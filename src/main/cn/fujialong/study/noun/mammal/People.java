package cn.fujialong.study.noun.mammal;

import cn.fujialong.study.noun.AbstractHasNameAndShape;

/**
 * @program: fujialongStudy
 * @description: 人类
 * @author: fujialong
 * @create: 2018-06-21 20:57
 **/
public  class People<T> extends AbstractHasNameAndShape implements PeopleInterface<T> {

    /**
     * 吃饭
     */
    @Override
    public void eat(T... s) {
        for (T t : s) {
            System.out.println("eat:"+t+",");
        }
    }
}
