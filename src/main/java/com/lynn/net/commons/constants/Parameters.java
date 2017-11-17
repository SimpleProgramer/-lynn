package com.lynn.net.commons.constants;


import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统参数
 */
@Component
@Data
public class Parameters {

    @Value("#{'${security.noneSecurityPath}'.split(',')}")
    private  List<String> noneSecurityPath;

    /*****redis config start*******/
    @Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private int redisPort;
    @Value("${redis.auth}")
    private String redisAuth;
    @Value("${redis.max-idle}")
    private int redisMaxTotal;
    @Value("${redis.max-total}")
    private int redisMaxIdle;
    @Value("${redis.max-wait-millis}")
    private int redisMaxWaitMillis;
    /*****redis config end*******/

}
