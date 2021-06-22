package uzdeveloper.store_income_expense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import uzdeveloper.store_income_expense.entity.AttachmentContent;

import java.util.Optional;

@Service
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {


    Optional<AttachmentContent> findByAttachment_Id(Integer attachment_id);

}
