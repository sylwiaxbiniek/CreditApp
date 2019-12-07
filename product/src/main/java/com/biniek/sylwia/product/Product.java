package com.biniek.sylwia.product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Product {

  private @Id Long creditId;
  private String productName;
  private int value;

  public Product(Long creditId, String productName, int value) {
    this.creditId = creditId;
    this.productName = productName;
    this.value = value;
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
