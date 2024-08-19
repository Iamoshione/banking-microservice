package banking.account.service.service;


import banking.account.service.model.Account;

import java.util.List;
import java.util.Optional;

public interface IAccountService {
    Optional<Account> findById(int id);
    List<Account> findAll();
    void save(Account account);
    void delete(int id);
}
