package icu.iseenu.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 滑动窗口限流方案
 */
@Component
@RequiredArgsConstructor
public class SliderWindowLimit {

    private final JedisPool jedisPool;

    private static final int WINDOW_SIZE = 3;


    private static final String METHOD = "SliderWindowLimit:key";

    public boolean limit(String requeset) {
        long currentTimeMillis = System.currentTimeMillis();
        Jedis jedis = jedisPool.getResource();
        String luaScript = """
                local current_time_str = ARGV[1]
                local window_size_str = ARGV[2]"
                local current_time = tonumber(current_time_str)
                
                if not current_time then
                    return { err = 'invalid current_time: ' .. current_time_str }
                end
                
                local window_size = tonumber(window_size_str)
                if not window_size then
                    return { err = 'invalid window_size: ' .. window_size_str }
                end
                local window_start = current_time - 60000
                redis.call('ZREMRANGEBYSCORE', KEYS[1], '-inf', window_start)
                local count = redis.call('ZCARD', KEYS[1])
                
                 "if count < window_size then
                   redis.call('ZADD', KEYS[1], current_time, current_time)
                   return 1
                else
                    return 0
                end
                """;
        Object result = jedis.eval(luaScript, 1, METHOD, String.valueOf(currentTimeMillis), String.valueOf(WINDOW_SIZE));

        return (Long) result == 1;
    }
}
