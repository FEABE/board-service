package com.pratice.boardservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing//JPA Auditing 활성화
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return ()-> Optional.of("jun");

    }
}
