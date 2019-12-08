package com.biniek.sylwia.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/getProducts")
    public List<Product> getProducts(@RequestBody List<Long> credits) {
        return productService.getAllByIds(credits);
    }

}
