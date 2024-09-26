package com.zero.atomikos;

import com.zero.atomikos.common.config.DBConfig1;
import com.zero.atomikos.common.config.DBConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties(value = { DBConfig1.class, DBConfig2.class })
public class ZeroAtomikosJavaApplication {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(ZeroAtomikosJavaApplication.class, args);
        long end = System.currentTimeMillis();
        System.out.println("启动时间：" + (end - start) + "ms");
    }

}
