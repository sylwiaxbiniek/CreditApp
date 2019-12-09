package com.biniek.sylwia.credit;

import com.biniek.sylwia.customer.Customer;
import com.biniek.sylwia.product.Product;

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
@WebMvcTest(CreditController.class)
public class CreditControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CreditService service;

    @Test
    public void addCredit() throws Exception {
      Gson gson = new Gson();
      InputData data = new InputData();
      data.product = new Product("dummy", 123);
      data.customer = new Customer("jan", "123", "kowalski");
      data.credit = new Credit("fancy");

      Long id = Long.valueOf(76543);

      given(service.createCredit(Mockito.any())).willReturn(id);

      mvc.perform(post("/createCredit")
         .contentType(MediaType.APPLICATION_JSON)
         .content(gson.toJson(data)))
         .andExpect(status().isOk());
      verify(service, VerificationModeFactory.times(1)).createCredit(Mockito.any());
      reset(service);
    }

    @Test
    public void getCredits() throws Exception {
      Gson gson = new Gson();
      InputData data = new InputData();
      data.product = new Product("dummy", 123);
      data.customer = new Customer("jan", "123", "kowalski");
      data.credit = new Credit("fancy");
      List<InputData> dats = Arrays.asList(data,data,data);

      given(service.getAllData()).willReturn(dats);

      mvc.perform(get("/getCredits")
         .contentType(MediaType.APPLICATION_JSON)
         .content(""))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$[0].product.productName", is("dummy")));
      verify(service, VerificationModeFactory.times(1)).getAllData();
      reset(service);
    }
}
