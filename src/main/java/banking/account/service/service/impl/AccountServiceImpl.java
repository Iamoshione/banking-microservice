package banking.account.service.service.impl;

import banking.account.service.model.Account;
import banking.account.service.persistence.IAccountDAO;
import banking.account.service.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountServiceImpl implements IAccountService {

    private final IAccountDAO accountDAO;

    public AccountServiceImpl(IAccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Optional<Account> findById(int id) {
        return accountDAO.findById(id);
    }

    @Override
    public List<Account> findAll() {
        return accountDAO.findAll();
    }


    @Override
    public void save(Account account) {
        accountDAO.save(account);
    }

    @Override
    public void delete(int id) {
        accountDAO.delete(id);
    }
}
