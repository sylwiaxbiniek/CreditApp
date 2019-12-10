package com.biniek.sylwia.credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;

import com.biniek.sylwia.customer.Customer;
import com.biniek.sylwia.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Service
@Transactional
public class RestDataServiceImpl implements RestDataService {

  @Bean
  public RestTemplate restTemplate() {
      return new RestTemplate();
  }

  @Autowired
  private CreditRepository creditRepository;

  @Autowired
  private RestTemplate restTemplate;

  static final String CUSTOMER_CRT = "http://customer:8080/createCustomer";
  static final String CUSTOMER_GET = "http://customer:8080/getCustomers";
  static final String PRODUCT_CRT = "http://product:8080/createProduct";
  static final String PRODUCT_GET = "http://product:8080/getProducts";

  @Override
  public RestData createCredit(RestData restData) {
    Long creditId = Long.valueOf(restData.hashCode());
    restData.getCredit().setCreditId(creditId);
    restData.getProduct().setCreditId(creditId);
    restData.getCustomer().setCreditId(creditId);

    creditRepository.save(restData.getCredit());

    ResponseEntity<Customer> custResp = restTemplate.postForEntity(CUSTOMER_CRT,
          restData.getCustomer(),
          Customer.class);

    ResponseEntity<Product> prodResp = restTemplate.postForEntity(PRODUCT_CRT,
          restData.getProduct(),
          Product.class);

    return restData;
  }

  @Override
  public List<RestData> getAllCredits() {
    List<Credit> credits = creditRepository.findAll();
    List<Long> creditIds = new ArrayList<Long>();
    for(Credit c : credits) {
      creditIds.add(c.getCreditId());
    }

    ResponseEntity<Product[]> prodResp = restTemplate.postForEntity(PRODUCT_GET,
          creditIds,
          Product[].class);
    Product[] prods = prodResp.getBody();

    ResponseEntity<Customer[]> custResp = restTemplate.postForEntity(CUSTOMER_GET,
          creditIds,
          Customer[].class);
    Customer[] custs = custResp.getBody();

    List<RestData> res = new ArrayList<RestData>();

    for(Credit cr : credits) {
      Product prod = Arrays.stream(prods)
        .filter(p -> cr.getCreditId().equals(p.getCreditId()))
        .findAny()
        .orElse(null);

      Customer cus = Arrays.stream(custs)
        .filter(c -> cr.getCreditId().equals(c.getCreditId()))
        .findAny()
        .orElse(null);

      res.add(new RestData(cus, prod, cr));
    }

    return res;
  }

}
