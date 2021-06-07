package uzdeveloper.store_income_expense.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    @ManyToOne
    private Store store;

    @ManyToOne
    private Provider provider;

    @ManyToMany
    private List<Product> product;

    @ManyToOne
    private Measurement measurement;

    private Double amount;

    private Double cost;

    private Date dueTime;

    @ManyToOne
    private Currency currency;

    private Integer invoiceNumber;





}
