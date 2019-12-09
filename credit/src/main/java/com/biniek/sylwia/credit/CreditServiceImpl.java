package com.biniek.sylwia.credit;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CreditServiceImpl implements CreditService {

  @Autowired
  private CreditRepository creditRepository;

  @Override
  public Long createCredit(InputData inputData){
    int hash = 23;
    hash = hash * 31 + inputData.customer.getPesel().hashCode();
    hash = hash * 31 + inputData.product.getProductName().hashCode();
    hash = hash * 31 + inputData.product.getValue();

    inputData.credit.setId(Long.valueOf(hash));
    inputData.customer.setCreditId(Long.valueOf(hash));
    inputData.product.setCreditId(Long.valueOf(hash));

    creditRepository.save(inputData.credit);

    return Long.valueOf(hash);
  }

  @Override
  public List<InputData> getAllData(){
    List<Credit> credits = creditRepository.findAll();
    return new ArrayList<InputData>();
  }

}
