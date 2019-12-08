package com.biniek.sylwia.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> getAllByIds(List<Long> ids) {
    return productRepository.findAllById(ids);
  }

  @Override
  public Product save(Product product) {
    return productRepository.save(product);
  }

}
