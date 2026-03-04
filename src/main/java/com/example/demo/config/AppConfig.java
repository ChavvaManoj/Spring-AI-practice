package com.example.demo.config;


import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.pgvector.PgVectorStore;
import org.springframework.ai.vectorstore.redis.RedisVectorStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPooled;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class AppConfig {


    @Bean
    public VectorStore vectorStore(JdbcTemplate jdbcTemplate, EmbeddingModel embeddingModel){
        return PgVectorStore.builder(jdbcTemplate,embeddingModel)
                .dimensions(1536)
                .distanceType(PgVectorStore.PgDistanceType.COSINE_DISTANCE)
                .indexType(PgVectorStore.PgIndexType.HNSW)
                .build();
    }

    @Bean
    public JedisPooled jedisPooled(){
        return new JedisPooled("localhost,6379");
    }

    public VectorStore vectorStore(JedisPooled jedisPooled,EmbeddingModel embeddingModel){
        return RedisVectorStore.builder(jedisPooled,embeddingModel)
                .indexName("product-index")
                .initializeSchema(true)
                .build();
    }



}
