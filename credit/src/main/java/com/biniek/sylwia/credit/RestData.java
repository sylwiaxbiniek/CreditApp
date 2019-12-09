package com.biniek.sylwia.credit;

import com.biniek.sylwia.customer.Customer;
import com.biniek.sylwia.product.Product;

class RestData {

  private Customer customer;
  private Product product;
  private Credit credit;

  public RestData(Customer customer,
   Product product,
   Credit credit) {
     this.customer = customer;
     this.product = product;
     this.credit = credit;
   }

   public Customer getCustomer(){ return customer;}
   public Product getProduct(){return product;}
   public Credit getCredit(){return credit;}

}
