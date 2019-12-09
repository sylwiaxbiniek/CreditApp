package com.biniek.sylwia.credit;

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

    @PostMapping("/createCredit")
    public ResponseEntity createCredit(@RequestBody Credit customer) {
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/getCredits")
    public List<Credit> getCustomers() {
        return new ArrayList<Credit>();
    }

}
