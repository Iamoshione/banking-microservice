package banking.account.service.controllers;



import banking.account.service.controllers.dto.AccountDTO;
import banking.account.service.model.Account;
import banking.account.service.service.IAccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final IAccountService iAccountService;

    public AccountController(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAll() {
        List<AccountDTO> accountList = iAccountService.findAll()
                .stream()
                .map(account -> AccountDTO.builder()
                        .account_number(account.getAccount_number())
                        .account_type(account.getAccount_type())
                        .balance(account.getBalance())
                        .user(account.getUser())
                        .build())
                .toList();
        return ResponseEntity.ok(accountList);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        Optional<Account> accountOptional = iAccountService.findById(id);

        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            AccountDTO accountDTO = AccountDTO.builder()
                    .account_number(account.getAccount_number())
                    .account_type(account.getAccount_type())
                    .balance(account.getBalance())
                    .user(account.getUser())
                    .build();
            return ResponseEntity.ok(accountDTO);
        }
        return ResponseEntity.notFound().build();
    }

   /* @PostMapping(value = "/save")
    public ResponseEntity<?> save(@RequestBody AccountDTO accountDTO) {

        if(accountDTO.getAccount_type().isBlank()){
            return ResponseEntity.badRequest().build();
        }
    }
*/

}
