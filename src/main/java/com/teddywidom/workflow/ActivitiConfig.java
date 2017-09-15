package com.teddywidom.workflow;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.impl.history.HistoryLevel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ActivitiConfig {
    // TODO is there any way to make these immutable once set by Spring?
    @Value("${spring.datasource.url}")
    String activitiJdbcUrl;

    @Value("${sbbc.activiti.jdbcUsername}")
    String activitiJdbcUsername;

    @Value("${sbbc.activiti.jdbcPassword}")
    String activitiJdbcPassword;

    @Value("${sbbc.activiti.dbSchema}")
    String activitiDbSchema;

    @Bean
    public ProcessEngine getProcessEngine() {
        return ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
                .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_FALSE)
                .setJdbcDriver("org.postgresql.Driver")
                .setJdbcUrl(activitiJdbcUrl)
                .setJdbcUsername(activitiJdbcUsername)
                .setJdbcPassword(activitiJdbcPassword)
                .setDatabaseSchema(activitiDbSchema)
                .setHistoryLevel(HistoryLevel.AUDIT)
                .buildProcessEngine();
    }
}
