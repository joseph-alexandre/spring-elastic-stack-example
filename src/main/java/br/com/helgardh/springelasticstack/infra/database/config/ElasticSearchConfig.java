package br.com.helgardh.springelasticstack.infra.database.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.text.MessageFormat;

@Configuration
@EnableElasticsearchRepositories(basePackages = "br.com.helgardh.springelasticstack.infra.database.repository")
public class ElasticSearchConfig {

    @Value("${elasticsearch.host}")
    private String host;

    @Value("${elasticsearch.port}")
    private String port;

    @Bean
    public RestHighLevelClient client() throws Exception {
        ClientConfiguration clientConfiguration
                = ClientConfiguration.builder()
                .connectedTo(MessageFormat.format("{0}:{1}", host, port))
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception {
        return new ElasticsearchRestTemplate(client());
    }
}
