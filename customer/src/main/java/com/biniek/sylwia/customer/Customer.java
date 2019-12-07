package com.biniek.sylwia.customer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Customer {

  private @Id Long creditId;
  private String firstName;
  private String pesel;
  private String surname;

  public Customer(Long creditId, String firstName, String pesel, String surname) {
    this.creditId = creditId;
    this.firstName = firstName;
    this.pesel = pesel;
    this.surname = surname;
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
