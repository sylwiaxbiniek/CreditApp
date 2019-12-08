package com.biniek.sylwia.customer;

import com.google.gson.Gson;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService service;

    @Test
    public void addCustomerAndGet() throws Exception {
      Gson gson = new Gson();
      Customer cust = new Customer(Long.valueOf(1), "jan", "123", "kowalski");
      given(service.save(Mockito.any())).willReturn(cust);

      mvc.perform(post("/createCustomer")
         .contentType(MediaType.APPLICATION_JSON)
         .content(gson.toJson(cust)))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$.firstName", is("jan")))
         .andExpect(jsonPath("$.pesel", is("123")))
         .andExpect(jsonPath("$.surname", is("kowalski")));
      verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
      reset(service);
    }

    @Test
    public void getCustomers() throws Exception {
      Gson gson = new Gson();
      Customer cust1 = new Customer(Long.valueOf(1), "jan", "123", "kowalski");
      Customer cust2 = new Customer(Long.valueOf(1), "jan", "453", "kowalski");
      Customer cust3 = new Customer(Long.valueOf(1), "jan", "565", "kowalski");
      List<Customer> custs = Arrays.asList(cust1, cust2, cust3);
      List<Long> ids = Arrays.asList(Long.valueOf(1),Long.valueOf(2),Long.valueOf(3));

      given(service.getAllByIds(Mockito.any())).willReturn(custs);

      mvc.perform(post("/getCustomers")
         .contentType(MediaType.APPLICATION_JSON)
         .content(gson.toJson(ids)))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$[0].pesel", is("123")))
         .andExpect(jsonPath("$[1].pesel", is("453")))
         .andExpect(jsonPath("$[2].pesel", is("565")));
      verify(service, VerificationModeFactory.times(1)).getAllByIds(Mockito.any());
      reset(service);
    }
}
