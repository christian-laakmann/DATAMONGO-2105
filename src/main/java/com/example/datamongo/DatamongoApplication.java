package com.example.datamongo;

import com.example.datamongo.entities.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@SpringBootApplication
@Configuration
@EnableMongoRepositories
public class DatamongoApplication {

  public static void main(String[] args) {

    SpringApplication.run(DatamongoApplication.class, args);
  }

  @Autowired
  private MongoTemplate template;

  @PostConstruct
  public void setup() {

    DataEntity entity = new DataEntity();
    entity.setTimestamp(new BigDecimal(System.currentTimeMillis()));
    template.save(entity);
    template.findAll(DataEntity.class).forEach(data -> System.out.println("found entity: " + data.getTimestamp()));
  }

}
