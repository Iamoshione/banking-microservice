package banking.account.service.controllers.dto;

import banking.account.service.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {

    private String account_type;
    private BigDecimal balance;
    private int account_number;
    private User user;
}

