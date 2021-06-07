package uzdeveloper.store_income_expense.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentContent {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Attachment attachment;

    private byte[] mainContent;

    public AttachmentContent(Attachment attachment, byte[] mainContent) {
        this.attachment = attachment;
        this.mainContent = mainContent;
    }
}
