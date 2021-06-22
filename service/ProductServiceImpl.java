package uzdeveloper.store_income_expense.service;

import org.springframework.stereotype.Service;
import uzdeveloper.store_income_expense.Response;
import uzdeveloper.store_income_expense.entity.Product;
import uzdeveloper.store_income_expense.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Response getOneProduct(Integer id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isEmpty())
            return new Response("such product id was not found", false, null);
        return new Response("success", true, optionalProduct.get());

    }
}
