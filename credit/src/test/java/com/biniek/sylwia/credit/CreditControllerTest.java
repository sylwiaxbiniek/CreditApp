package com.biniek.sylwia.credit;

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

import com.biniek.sylwia.customer.Customer;
import com.biniek.sylwia.product.Product;

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
@WebMvcTest(CreditController.class)
public class CreditControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RestDataService service;

    @Test
    public void createCredit() throws Exception {
      Gson gson = new Gson();
      Customer customer = new Customer("Jan", "1234567890", "Kowalski");
      Product product = new Product("samolot", 1000000);
      Credit credit = new Credit("kredyt na samolot");
      RestData restData = new RestData(customer, product, credit);

      String inputJson = gson.toJson(restData);

      Long creditId = Long.valueOf(111);
      restData.getCredit().setCreditId(creditId);

      given(service.createCredit(Mockito.any())).willReturn(restData);

      mvc.perform(post("/createCredit")
         .contentType(MediaType.APPLICATION_JSON)
         .content(inputJson))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$.*", hasSize(1)))
         .andExpect(jsonPath("$.creditId").value(creditId));
      verify(service, VerificationModeFactory.times(1)).createCredit(Mockito.any());
      reset(service);
    }

    @Test
    public void getAllCredits() throws Exception {
      Long creditId = Long.valueOf(111);
      Customer customer = new Customer("Jan", "1234567890", "Kowalski");
      customer.setCreditId(creditId);
      Product product = new Product("samolot", 1000000);
      product.setCreditId(creditId);
      Credit credit = new Credit("kredyt na samolot");
      credit.setCreditId(creditId);
      RestData restData = new RestData(customer, product, credit);

      List<RestData> allRestData = Arrays.asList(restData);

      given(service.getAllCredits()).willReturn(allRestData);

      mvc.perform(get("/getCredits")
         .contentType(MediaType.APPLICATION_JSON)
         .content(""))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$", hasSize(1)))
         .andExpect(jsonPath("$[0].customer.*", hasSize(3)))
         .andExpect(jsonPath("$[0].product.*", hasSize(2)))
         .andExpect(jsonPath("$[0].credit.*", hasSize(1)))
         .andExpect(jsonPath("$[0].customer.firstName").value(customer.getFirstName()))
         .andExpect(jsonPath("$[0].customer.pesel").value(customer.getPesel()))
         .andExpect(jsonPath("$[0].customer.surname").value(customer.getSurname()))
         .andExpect(jsonPath("$[0].product.productName").value(product.getProductName()))
         .andExpect(jsonPath("$[0].product.value").value(product.getValue()))
         .andExpect(jsonPath("$[0].credit.creditName").value(credit.getCreditName()));
      verify(service, VerificationModeFactory.times(1)).getAllCredits();
      reset(service);
    }

}
