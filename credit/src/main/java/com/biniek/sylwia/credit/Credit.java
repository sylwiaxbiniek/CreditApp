package com.biniek.sylwia.credit;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
class Credit {

  private @Id Long creditId;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String creditName;

  public Credit(String creditName) {
    this.creditName = creditName;
  }

  public Credit(Long creditId, String creditName) {
    this.creditId = creditId;
    this.creditName = creditName;
  }

  public void setCreditId(Long creditId){
    this.creditId = creditId;
  }

  public Long getCreditId() {
    return creditId;
  }

  public void setCreditName(String creditName) {
    this.creditName = creditName;
  }

  public String getCreditName() {
    return creditName;
  }

}
