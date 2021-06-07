package uzdeveloper.store_income_expense.service;

import org.springframework.stereotype.Service;
import uzdeveloper.store_income_expense.Response;

@Service
public interface ProductService {

    Response getOneProduct(Integer id);

}
