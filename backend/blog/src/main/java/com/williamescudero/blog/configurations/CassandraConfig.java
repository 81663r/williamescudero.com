package com.williamescudero.blog.configurations;

import java.util.ArrayList;
import java.util.List;

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

        cluster.setContactPoints("localhost");
        // cluster.setPort(9142);
        cluster.setJmxReportingEnabled(false);

        

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