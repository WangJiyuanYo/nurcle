package icu.iseenu.configration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisTemplateConfig {

    private final RedisProperties redisProperties;

    public RedisTemplateConfig(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        
        // 设置 key 的序列化为 String（推荐）
        template.setKeySerializer(new StringRedisSerializer());
        
        // 设置 value 的序列化为 JSON（使用 GenericJackson2JsonRedisSerializer）
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        
        // Hash 的 key 和 value 序列化方式也可以设置
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());

        // 绑定连接工厂
        template.setConnectionFactory(factory);
        
        return template;
    }

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setJmxEnabled(false);
        // 设置其他参数...
        return new JedisPool(config, redisProperties.getHost(), redisProperties.getPort(), 2000, null);
    }
}
