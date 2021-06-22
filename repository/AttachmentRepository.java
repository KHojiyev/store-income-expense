package uzdeveloper.store_income_expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uzdeveloper.store_income_expense.entity.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {


}
