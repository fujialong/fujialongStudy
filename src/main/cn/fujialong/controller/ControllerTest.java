package cn.fujialong.controller;

import cn.fujialong.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 普通java对象api文档测试
 *
 * @author yu 2018/06/27.
 */
@RestController
@RequestMapping("simple/")
public class ControllerTest {
    /**
     * 返回普通String测试
     *
     * @return
     */
    @PostMapping("/str")
    public String testString() {
        return null;
    }

    /**
     * 返回普通javabean
     *
     * @param user
     * @return
     */
    @PostMapping("/user")
    public User testUser(@RequestBody User user) {
        return null;
    }

}
