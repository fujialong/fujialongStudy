package cn.fujialong.study.noun;


/**
 * @program: fujialongStudy
 * @description:女娲类
 * @author: fujialong
 * @create: 2018-06-21 20:05
 **/
public class Noun {
    public  Object create(String thing) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("create" + thing);
        
        return stringBuilder;
    }


}
