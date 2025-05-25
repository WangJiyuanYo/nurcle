package icu.iseenu.service.impl;

import icu.iseenu.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
@Slf4j
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private SliderWindowLimit windowLimit;

    private final ChatClient client;

    public RedisServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.client = chatClientBuilder.build();
    }

    @Override
    public void testLua(String key, String value) {
        //简单的LUA设置Redis k-v 的demo
        String lua = """
                local key = KEYS[1]
                local value = ARGV[1]
                redis.call('SET', key, value)
                redis.call('SET', KEYS[2], ARGV[2])
                redis.call('Expire',key,60)
                return true
                """;
        RedisScript<Boolean> script = new DefaultRedisScript<>(lua, Boolean.class);
        //key的list，value1,value2...
        Object execute = redisTemplate.execute(script, Arrays.asList(key, "lua-key2"), value, "value2");
        log.info("redisTemplate eval execute result is :{}", execute);
    }

    @Override
    public String testLimit() {
        boolean request = windowLimit.limit(UUID.randomUUID().toString());
        return request ? "请求成功" : "请求失败";
    }


}
