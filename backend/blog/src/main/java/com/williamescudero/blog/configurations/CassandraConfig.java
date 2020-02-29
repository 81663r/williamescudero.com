package com.williamescudero.blog.configurations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.convert.CassandraCustomConversions;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.username}")
    private String cassandraUsername;

    @Value("${spring.data.cassandra.password}")
    private String cassandraPassword;

    @Value("${spring.data.cassandra.contact-points}")
    private String cassandraContactPoints;

    @Override
    protected String getKeyspaceName(){
        return "williamescudero_com";
    }

    @Override
    public SchemaAction getSchemaAction(){
        
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {"com.williamescudero.blog.entities"};
    }

    @Bean
    public CassandraClusterFactoryBean cluster(){
        CassandraClusterFactoryBean cluster = new CassandraClusterFactoryBean();

        cluster.setContactPoints(this.cassandraContactPoints);
        cluster.setPort(9142);
        cluster.setJmxReportingEnabled(false);
        cluster.setSslEnabled(true);
        cluster.setUsername(this.cassandraUsername);
        cluster.setPassword(this.cassandraPassword);

        

        return cluster;
    }

    @Bean
    public CassandraMappingContext cassandraMappingContext() throws ClassNotFoundException {
        return new CassandraMappingContext();
    }

    @Bean
    public CassandraCustomConversions customConversions(){

        List<Converter<?, ?>> converters = new ArrayList<>();

        return new CassandraCustomConversions(converters);
    }

}