package uzdeveloper.store_income_expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzdeveloper.store_income_expense.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
