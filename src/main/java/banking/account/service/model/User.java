package banking.account.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name="user_id")
    private int user_id;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne(mappedBy = "user" , cascade = CascadeType.ALL ,orphanRemoval = true ,fetch = FetchType.LAZY)
    @JsonIgnore
    private Account account;

    public User(int user_id, String full_name, String address, String email, String phone, Account account) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    public User() {
    }
}
