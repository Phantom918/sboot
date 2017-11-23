package com.phantom.sboot.jersey;

import com.phantom.sboot.entity.User;
import com.phantom.sboot.service.UserMapperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @Description: 服务类,详细使用方式参照：https://www.cnblogs.com/pixy/p/4838268.html
 * @Author: tan.lei
 * @Date: 2017/11/22 14:23
 */
@Slf4j
@Component
@Path("/user")
public class UserServer {

    @Autowired
    private UserMapperService userMapperService;

    @GET
    @Path("/getUser/{id}")
    @Produces(MediaType.APPLICATION_JSON)//返回值类型JSON
    @Cacheable(value = "key-user")
    public User getUser(@PathParam("id") long id) {
        log.debug("第一次未调用缓存。。。。");
        return userMapperService.getOne(id);
    }

}
