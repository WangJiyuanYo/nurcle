package icu.iseenu.controller;

import icu.iseenu.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("redis")
@Slf4j
@RestController
public class RedisController {

    private RedisService redisService = null;

    @Autowired
    public void setRedisService(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/lua")
    public String testLua() {
        redisService.testLua("lua-key", String.valueOf(UUID.randomUUID()));
        return "已经生成了所需要的key";
    }

    @GetMapping("limit")
    public String testLimit() {
        return redisService.testLimit();
    }
}
