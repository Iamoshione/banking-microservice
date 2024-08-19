package banking.account.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "account")
public class Account {

    @Id
    private int user_id;

    @Column(name = "account_type")
    private String account_type;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "account_number")
    private int account_number;

    @OneToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Account(int user_id, String account_type, BigDecimal balance, int account_number, User user) {
        this.user_id = user_id;
        this.account_type = account_type;
        this.balance = balance;
        this.account_number = account_number;
        this.user = user;
    }

    public Account() {
    }
}

