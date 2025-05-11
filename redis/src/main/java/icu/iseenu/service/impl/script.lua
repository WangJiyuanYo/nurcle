
                "local current_time = tonumber(ARGV[1])\n"
                + "local window_size = ARGV[2]\n"
                + "local window_start = current_time - 60000\n"

                + "redis.call('ZREMRANGEBYSCORE', KEYS[1], '-inf', window_start)\n"
                + "local count = redis.call('ZCARD', KEYS[1])\n"

                + "if count < window_size then\n"
                + "    redis.call('ZADD', KEYS[1], current_time, current_time)\n"
                + "    return 1\n"
                + "else\n"
                + "    return 0\n"
                + "end"