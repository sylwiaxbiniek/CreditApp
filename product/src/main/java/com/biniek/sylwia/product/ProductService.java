package com.biniek.sylwia.product;

import java.util.List;

public interface ProductService {

  public List<Product> getAllByIds(List<Long> ids);

  public Product save(Product product);

}
