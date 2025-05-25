package icu.iseenu.service;


public interface RedisService {
    void testLua(String key,String value);

    String testLimit();

}
