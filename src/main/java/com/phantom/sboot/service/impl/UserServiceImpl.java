package com.phantom.sboot.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.phantom.sboot.config.DsConfig.DS;
import com.phantom.sboot.entity.User;
import com.phantom.sboot.dao.UserMapper;
import com.phantom.sboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: tan.lei
 * @Description:
 * @Date: Create in 11:39 2017/11/17
 * @Modifiy:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> getAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> users = userMapper.getAll();
        return users;
    }

    @Override
    @DS(value = "ds1")
    public User getOne(Long id) {
        return userMapper.getOne(id);
    }

    @Override
    @Transactional//事务管理  声明在类上面：类的所有方法有效 声明在方法上面：该方法有效
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(Long id) {
        userMapper.delete(id);
    }
}
