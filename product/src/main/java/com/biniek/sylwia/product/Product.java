package com.biniek.sylwia.product;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {

  private @Id Long creditId;
  private String productName;
  private int value;

  public Product() {
  }

  public Product(String productName, int value) {
    this.productName = productName;
    this.value = value;
  }

  public Product(Long creditId, String productName, int value) {
    this.creditId = creditId;
    this.productName = productName;
    this.value = value;
  }

  public void setCreditId(Long creditId){
    this.creditId = creditId;
  }

  public Long getCreditId() {
    return creditId;
  }

  public String getProductName() {
    return productName;
  }

  public int getValue() {
    return value;
  }

}
