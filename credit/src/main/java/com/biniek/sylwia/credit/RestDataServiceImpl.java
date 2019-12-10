package com.biniek.sylwia.credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RestDataServiceImpl implements RestDataService {

  @Autowired
  private CreditRepository creditRepository;

  @Override
  public RestData createCredit(RestData restData) {
    Long creditId = Long.valueOf(666);
    restData.getCredit().setCreditId(creditId);
    restData.getProduct().setCreditId(creditId);
    restData.getCustomer().setCreditId(creditId);

    creditRepository.save(restData.getCredit());

    return restData;
  }

  @Override
  public List<RestData> getAllCredits() {
    List<Credit> creditIds = creditRepository.findAll();
    return new ArrayList<RestData>();
  }

}
