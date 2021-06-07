package uzdeveloper.store_income_expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private String message;

    private Boolean status;

    private Object object;


}
