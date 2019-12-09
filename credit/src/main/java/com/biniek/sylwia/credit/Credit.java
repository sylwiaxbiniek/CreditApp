package com.biniek.sylwia.credit;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Credit {

  private @Id Long id;
  private String creditName;

  public Credit(String creditName) {
    this.creditName = creditName;
  }

  public Credit(Long id, String creditName) {
    this.id = id;
    this.creditName = creditName;
  }

  public Long getId() {
    return id;
  }

  public String getCreditName() {
    return creditName;
  }

}
