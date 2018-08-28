package cn.fujialong.model;

import lombok.Data;

/**
 * Description:
 * 用户对象
 *
 * @author yu 2018/06/12.
 */
@Data
public class User {
    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户地址
     */
    private String userAddress;

    /**
     * 用户年龄
     */
    private int userAge;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * ipv6
     */
    private String ipv6;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 子用户信息
     */
    private SubUser subUser;
}
