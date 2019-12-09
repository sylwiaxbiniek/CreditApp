package com.biniek.sylwia.credit;

import java.util.List;

public interface CreditService {

  public Long createCredit(InputData inputData);

  public List<InputData> getAllData();

}
