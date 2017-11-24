package com.phantom.sboot.service;

import com.github.pagehelper.Page;
import com.phantom.sboot.entity.User;

/**
 * @Author: tan.lei
 * @Description:
 * @Date: Create in 11:35 2017/11/17
 * @Modifiy:
 */
public interface UserService {

    Page<User> getAll(int pageNum, int pageSize);

    User getOne(Long id);

    int insert(User user);

    void update(User user);

    void delete(Long id);

}
