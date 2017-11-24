package com.phantom.sboot.dao;

import com.github.pagehelper.Page;
import com.phantom.sboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper //@MapperScan("com.phantom.sboot.dao")//在启动的application类上面为所有路径下添加扫描
public interface UserMapper {

	Page<User> getAll();

	User getOne(Long id);

	/*设数据库表的ID主键是自增长的，添加一条数据要得到自增长的ID:
      useGeneratedKeys=true：获取数据库生成的主键
      keyProperty="id"：把主键值存入User对象的id属性
     */
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(User user);

	void update(User user);

	void delete(Long id);
}