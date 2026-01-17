package com.unifiedlogs.platform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(
        basePackages = "com.unifiedlogs.platform.repository.search"
)
public class ElasticsearchConfig {
}
