package hu.uni.ekcu.java;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootConfiguration
public class AppConfig {

    @Bean("adjustment")
    public int adjustment() {
        return 5;
    }
}
