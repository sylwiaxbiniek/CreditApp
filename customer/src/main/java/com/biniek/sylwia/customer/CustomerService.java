package com.biniek.sylwia.customer;

import java.util.List;

public interface CustomerService {

  public List<Customer> getAllByIds(List<Long> ids);

  public Customer save(Customer customer);

}
