package com.example.tkmybatispagehelp.mapper;

import com.example.tkmybatispagehelp.TkMybatisPagehelpApplication;
import com.example.tkmybatispagehelp.TkMybatisPagehelpApplicationTests;
import com.example.tkmybatispagehelp.entity.User;
import com.sun.deploy.association.utility.WinRegistryUtil;
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

                .createTime(new Date())
                .lastUpdateTime(new Date())
                .build();

        // 测试保存部分参数
        try {
            int res = userMapper.insertSelective(user);
            log.info("保存单个实体，自动生成主键并返回受影响的条数 {} ", res);
        } catch (Exception e) {
            log.error("保存单个实体，出现异常{}", e.getMessage());
        }

        // 测试保存一个实体
        // 数据库设置自增主键的时候，如果当前数据库主键最大 5 实体自定义了主键 100，
        // 那么会选择实体的主键，且下次从当前最大主键继续增加为 101
        try {
            user.setSalt("SALT");
            user.setStatus(1);
            user.setLastLoginTime(null);
            user.setId(100L);
            userMapper.insert(user);
            log.info("保存单个实体，自动生成主键并返回{}", user.getId());
        } catch (Exception e) {
            log.error("保存单个实体，出现异常{}", e.getMessage());
        }

        // 测试保存自动生成id，插入选择的属性
        try {
            userMapper.insertUseGeneratedKeys(user);
            log.info("保存单个实体，自动生成主键并返回{}", user.getId());
        } catch (Exception e) {
            log.error("保存单个实体，出现异常{}", e.getMessage());
        }

        // 测试保存自动设置的id
        try {
            user.setId(user.getId() + 10);
            userMapper.insertUseGeneratedKeys(user);
            log.info("保存单个实体，自动生成主键并返回{}", user.getId());
        } catch (Exception e) {
            log.error("保存单个实体，出现异常{}", e.getMessage());
        }
    }

    /**
     * 单表的更新：
     * 重点如果只是修改部分参数如何更新呢？
     */
    @Test
    public void UpdateUser() {

        User user = userMapper.selectByPrimaryKey(100);
        user.setEmail("测试更新");

        try {
            userMapper.updateByPrimaryKey(user);
            log.info("更新单个实体成功");
        }catch (Exception e){
            log.error("更新单个实体{}",e.getMessage());
        }

    }
}
