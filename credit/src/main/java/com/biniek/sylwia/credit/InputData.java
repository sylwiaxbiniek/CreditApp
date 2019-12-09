package com.biniek.sylwia.credit;

import com.biniek.sylwia.customer.Customer;
import com.biniek.sylwia.product.Product;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class InputData {
  Customer customer;
  Product product;
  @Id Credit credit;

  public InputData() {
  }

  public InputData(Customer customer, Product product, Credit credit) {
    this.customer = customer;
    this.credit = credit;
    this.product = product;
  }

  public Customer getCustomer() {
    return customer;
  }

  public Product getProduct() {
    return product;
  }

  public Credit getCredit() {
    return credit;
  }
}
