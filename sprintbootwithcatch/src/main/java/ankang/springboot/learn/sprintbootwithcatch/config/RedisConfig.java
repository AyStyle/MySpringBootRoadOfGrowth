package ankang.springboot.learn.sprintbootwithcatch.config;

import ankang.springboot.learn.sprintbootwithcatch.pojo.Comment;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

/**
 * @author: ankang
 * @email: dreedisgood@qq.com
 * @create: 2020-10-09
 */
@Configuration
public class RedisConfig {

    /**
     * 自定义一个RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Comment> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        final RedisTemplate<String, Comment> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // 创建Json格式序列化对象，对缓存数据的key和value进行转换
        final Jackson2JsonRedisSerializer<Comment> redisSerializer = new Jackson2JsonRedisSerializer<>(Comment.class);

        // 解决查询缓存转换异常问题
        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES , false);
        objectMapper.setVisibility(PropertyAccessor.ALL , JsonAutoDetect.Visibility.ANY);
        // objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        redisSerializer.setObjectMapper(objectMapper);


        // 设置RedisTemplate模板API的序列化方式为Json
        template.setDefaultSerializer(redisSerializer);
        return template;
    }

    /**
     * 创建RedisCatchManager，使用RedisCacheManager可以实现基于注解的缓存管理
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
        // 设置Redis缓存
        final Jackson2JsonRedisSerializer<Comment> jsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Comment.class);

        final ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL , JsonAutoDetect.Visibility.ANY);

        jsonRedisSerializer.setObjectMapper(objectMapper);

        // 创建RedisCacheManager
        final RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofDays(1))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jsonRedisSerializer))
                .disableCachingNullValues();

        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(redisCacheConfiguration).build();
    }

}
