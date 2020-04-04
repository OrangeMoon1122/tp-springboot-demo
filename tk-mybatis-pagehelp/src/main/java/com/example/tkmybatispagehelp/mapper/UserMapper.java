package com.example.tkmybatispagehelp.mapper;

import com.example.tkmybatispagehelp.entity.User;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author wangz
 */
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}
