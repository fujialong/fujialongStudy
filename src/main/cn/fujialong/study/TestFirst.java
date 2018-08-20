package cn.fujialong.study;

import cn.fujialong.study.noun.Noun;
import org.junit.Test;

/**
 * @program: fujialongStudy
 * @description: 测试类
 * @author: fujialong
 * @create: 2018-06-10 15:03
 **/
public class TestFirst {

    public static void main(String[] args) {
        System.out.println("");
    }
    @Test
    public void test1(){
        Noun noun = new Noun();
        StringBuilder stringBuilder = (StringBuilder) noun.create("man");
        System.out.println(stringBuilder);
    }

}
