package com.btlov._9_1_hw_autoconfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @ConditionalOnProperty(prefix = "netology.profile", value = "dev", havingValue = "true")
    @Bean(name = "devProfile")          //(name = "devProfile") - прописывать не надо. Определяется имя автоматически. Это только для примера
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @ConditionalOnProperty(prefix = "netology.profile", value = "dev", havingValue = "false")
    @Bean
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}