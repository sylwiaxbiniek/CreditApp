package com.biniek.sylwia.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<Customer> getAllByIds(List<Long> ids) {
    return customerRepository.findAllById(ids);
  }

  @Override
  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

}
