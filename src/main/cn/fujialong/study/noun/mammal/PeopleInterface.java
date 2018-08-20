package cn.fujialong.study.noun.mammal;

/**
 * @author fujialong
 */
public interface PeopleInterface<T> {
    /** 
    * 吃
    *        
    * @param food
    * @return void 
    * @Author fujialong 
    * @Date 2018/6/21 
    */ 
    void eat(T... food);
}
