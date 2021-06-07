package uzdeveloper.store_income_expense.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uzdeveloper.store_income_expense.Response;
import uzdeveloper.store_income_expense.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public Response getOneProduct(@PathVariable Integer id){
        return productService.getOneProduct(id);
    }



}
