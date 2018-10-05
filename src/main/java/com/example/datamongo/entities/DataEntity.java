package com.example.datamongo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document()
@TypeAlias("data")
public class DataEntity extends DataModel {

  @Id
  private String id;

  public String getId() {

    return id;
  }

  public void setId(String id) {

    this.id = id;
  }
}
