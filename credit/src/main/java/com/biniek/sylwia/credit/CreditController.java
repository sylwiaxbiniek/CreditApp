package com.biniek.sylwia.credit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CreditController {

    @Autowired
    private CreditService creditService;

    @PostMapping("/createCredit")
    public Long createCredit(@RequestBody InputData inputData) {
        return creditService.createCredit(inputData);
    }

    @GetMapping("/getCredits")
    public List<InputData> getCustomers() {
        return creditService.getAllData();
    }

}
