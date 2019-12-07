package com.biniek.sylwia.product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Product {

  private @Id Long creditId;
  private String productName;
  private int value;

}
