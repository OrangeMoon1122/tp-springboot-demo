package com.example.tkmybatispagehelp.mapper;

import com.example.tkmybatispagehelp.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author wangz
 */

@Component("userMapper")
public interface UserMapper extends Mapper<User>, MySqlMapper<User> {
}
