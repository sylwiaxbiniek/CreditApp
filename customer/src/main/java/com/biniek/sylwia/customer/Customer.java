package com.biniek.sylwia.customer;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Customer {

  private @Id Long creditId;
  private String firstName;
  private String pesel;
  private String surname;

}
