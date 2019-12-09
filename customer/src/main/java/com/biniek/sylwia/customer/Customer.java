package com.biniek.sylwia.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

  private @Id Long creditId;
  private String firstName;
  private String pesel;
  private String surname;

  public Customer() {}

  public Customer(String firstName, String pesel, String surname) {
    this.firstName = firstName;
    this.pesel = pesel;
    this.surname = surname;
  }

  public Customer(Long creditId, String firstName, String pesel, String surname) {
    this.creditId = creditId;
    this.firstName = firstName;
    this.pesel = pesel;
    this.surname = surname;
  }

  public void setCreditId(Long creditId){
    this.creditId = creditId;
  }

  public Long getCreditId() {
    return creditId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getPesel() {
    return pesel;
  }

  public String getSurname() {
    return surname;
  }

}
