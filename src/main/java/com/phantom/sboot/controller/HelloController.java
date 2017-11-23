package com.phantom.sboot.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.phantom.sboot.entity.User;
import com.phantom.sboot.service.UserMapperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: tan.lei
 * @Description:
 * @Date: 2017/11/16 15:54
 */
//@RestController //controller所有方法都以json格式输出
@Slf4j // 可直接使用log对象
@Controller
public class HelloController {

    @Autowired
    private UserMapperService userMapperService;

    @RequestMapping("/hello")
    public String index() {
        return "Hello World <-:->";
    }

    @ResponseBody
    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    @Cacheable(value = "key-user")
    public User getUser(@PathVariable(name = "id") long id) {
        log.debug("第一次未调用缓存。。。。");
        return userMapperService.getOne(id);
    }

    @ResponseBody
    @RequestMapping("/getUsers/{pageNum}/{pageSize}")
    @Cacheable(value="key-users") // 放进redis缓存
    public PageInfo<User> getUsers(@PathVariable(name = "pageNum") int pageNum, @PathVariable(name = "pageSize") int pageSize) {
        log.debug("第一次未调用缓存。。。。");
        Page<User> users = userMapperService.getAll(pageNum, pageSize);
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        log.debug("pageInfo====" + pageInfo.toString());
        return pageInfo;
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @Cacheable(value = "key-user")
    public boolean addUser(User user) {
        log.debug("第一次未调用缓存。。。。");
        return userMapperService.insert(user) == 1 ? true : false;
    }


    @RequestMapping("/uid")
    public String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
            log.debug("uid为null,自动生成uid为:{}", uid);
        }

        session.setAttribute("uid", uid);
        log.debug("当前uid:${}", uid);
        return session.getId();
    }

    @RequestMapping("/getAll")
    public String getAll(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        model.addAttribute("title", "我的页面");
        model.addAttribute("name", name);
        model.addAttribute("greeting", "this is greet!");
        model.addAttribute("currentTime", new Date());
        return "wechat/hello";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }



}
