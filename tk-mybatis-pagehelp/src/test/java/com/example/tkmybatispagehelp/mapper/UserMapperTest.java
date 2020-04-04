package com.example.tkmybatispagehelp.mapper;

import com.example.tkmybatispagehelp.TkMybatisPagehelpApplication;
import com.example.tkmybatispagehelp.TkMybatisPagehelpApplicationTests;
import com.example.tkmybatispagehelp.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @author Wangzhihang
 * @date 2020/4/3/16:19
 */

@Slf4j
public class UserMapperTest extends TkMybatisPagehelpApplicationTests {

    @Autowired
    private UserMapper userMapper;

    /**
     * 单表的保存
     */
    @Test
    public void SaveUser() {

        User user = User.builder()
                .name("tw1")
                .password("123")
                .email("123@email.com")
                .phoneNumber("133161")
                .status(1)
                .lastLoginTime(null)
                .createTime(new Date())
                .lastUpdateTime(new Date())
                .build();

        try {
          int res =  userMapper.insertSelective(user);
            log.info("保存单个实体，自动生成主键并返回{}", res);
        } catch (Exception e) {
            log.info("保存单个实体，出现异常{}", e.getMessage());
        }

        try {
            user.setSalt("SALT");
            userMapper.insert(user);
            log.info("保存单个实体，自动生成主键并返回{}", user.getId());
        } catch (Exception e) {
            log.info("保存单个实体，出现异常{}", e.getMessage());
        }


//
//
//        try {
//            userMapper.insertUseGeneratedKeys(user);
//            log.info("保存单个实体，自动生成主键并返回{}", user.getId());
//        } catch (Exception e) {
//            log.info("保存单个实体，出现异常{}", e.getMessage());
//        }
//
        try {
            user.setId(user.getId() + 10);
            userMapper.insertUseGeneratedKeys(user);
            log.info("保存单个实体，自动生成主键并返回{}", user.getId());
        } catch (Exception e) {
            log.info("保存单个实体，出现异常{}", e.getMessage());
        }
    }

    /**
     * 单表的更新：
     * 重点如果只是修改部分参数如何更新呢？
     */
    public void UpdateUser() {

    }
}
