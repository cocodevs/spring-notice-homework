package com.rsupport.rsupporthomework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@Configuration
@EnableJpaRepositories("com.rsupport.rsupporthomework.repository")
public class JpaConfig {
}
