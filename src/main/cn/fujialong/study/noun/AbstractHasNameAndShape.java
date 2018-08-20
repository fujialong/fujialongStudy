package cn.fujialong.study.noun;

import lombok.Data;

import java.util.Date;

/**
 * @program: fujialongStudy
 * @description: 有名有形
 * @author: fujialong
 * @create: 2018-06-21 20:38
 **/
@Data
public abstract class AbstractHasNameAndShape {
    private String sex;
    private String name;
    private Integer age;
    private Date birthDay;
}
