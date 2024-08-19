package banking.account.service.persistence.impl;

import banking.account.service.Repository.AccountRepository;
import banking.account.service.model.Account;
import banking.account.service.persistence.IAccountDAO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class AccountDAOImpl implements IAccountDAO {
    private final AccountRepository accountRepository;

    public AccountDAOImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Optional<Account> findById(int id) {
        return accountRepository.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void delete(int id) {
        accountRepository.deleteById(id);
    }
}
