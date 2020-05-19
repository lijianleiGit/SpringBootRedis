package com.blaineli.controller;



import com.blaineli.entity.UserBean;
import com.blaineli.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * redis 测试controller
 */
@RestController
@RequestMapping("/redis/")
@Api(description = "redis-API")
public class RedisTestController {

    private  static int expireTime = 60;// redis中存储的过期时间 60s


    @Autowired
    private RedisUtil redisUtil;
    @ApiOperation(value = "测试添加String类型")
    @GetMapping("setString")
    public boolean redisSetString(){
        UserBean userBean= new UserBean();
        userBean.setId(15L);
        userBean.setGuid("0015");
        userBean.setName("BlaineLi");
        userBean.setAge("23");
        userBean.setCreateTime(new Date());
        return  redisUtil.set("userBean",userBean);

    }

    @ApiOperation(value = "根据key获取值")
    @GetMapping("get/{key}")
    public Object redisGet(@PathVariable("key") String key){
        return redisUtil.get(key);
    }

    @ApiOperation(value = "设置key过期时间")
    @GetMapping("expire/{key}")
    public boolean expire(@PathVariable("key") String key){
        return redisUtil.expire(key,expireTime);
    }


    @ApiOperation(value = "查看某个key的过期剩余时间")
    @GetMapping("expire/get/{key}")
    public Long getExpire(@PathVariable("key") String key){
        return redisUtil.getExpire(key );
    }
}
