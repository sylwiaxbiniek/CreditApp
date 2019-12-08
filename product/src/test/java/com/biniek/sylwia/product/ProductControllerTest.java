package com.biniek.sylwia.product;

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
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService service;

    @Test
    public void addProduct() throws Exception {
      Gson gson = new Gson();
      Product prod = new Product(Long.valueOf(1), "dummy", 123);
      given(service.save(Mockito.any())).willReturn(prod);

      mvc.perform(post("/createProduct")
         .contentType(MediaType.APPLICATION_JSON)
         .content(gson.toJson(prod)))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$.productName", is("dummy")));
      verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
      reset(service);
    }

    @Test
    public void getProducts() throws Exception {
      Gson gson = new Gson();
      Product prod1 = new Product(Long.valueOf(1), "dummy1", 123);
      Product prod2 = new Product(Long.valueOf(2), "dummy2", 33);
      Product prod3 = new Product(Long.valueOf(3), "dummy3", 55);
      List<Product> prods = Arrays.asList(prod1, prod2, prod3);
      List<Long> ids = Arrays.asList(Long.valueOf(1),Long.valueOf(2),Long.valueOf(3));

      given(service.getAllByIds(Mockito.any())).willReturn(prods);

      mvc.perform(post("/getProducts")
         .contentType(MediaType.APPLICATION_JSON)
         .content(gson.toJson(ids)))
         .andExpect(status().isOk())
         .andExpect(jsonPath("$[0].productName", is("dummy1")))
         .andExpect(jsonPath("$[1].productName", is("dummy2")))
         .andExpect(jsonPath("$[2].productName", is("dummy3")));
      verify(service, VerificationModeFactory.times(1)).getAllByIds(Mockito.any());
      reset(service);
    }
}
