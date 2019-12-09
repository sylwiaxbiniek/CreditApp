package com.biniek.sylwia.credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CreditController {

    @Autowired
    private RestDataService restDataService;

    @PostMapping("/createCredit")
    public Credit createCredit(@RequestBody RestData restData) {
        RestData data = restDataService.createCredit(restData);
        Credit credit = data.getCredit();
        credit.setCreditName(null);
        return credit;
    }

    @GetMapping("/getCredits")
    public List<RestData> getCustomers() {
      List<RestData> allData = restDataService.getAllCredits();
      for(RestData data : allData) {
        data.getCredit().setCreditId(null);
        data.getCustomer().setCreditId(null);
        data.getProduct().setCreditId(null);
      }

      return allData;
    }

}
