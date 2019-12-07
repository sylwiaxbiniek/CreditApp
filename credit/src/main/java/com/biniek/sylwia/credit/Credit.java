package com.biniek.sylwia.credit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
class Credit {

  private @Id @GeneratedValue Long id;
  private String creditName;

}
