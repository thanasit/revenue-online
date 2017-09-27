package th.or.pao.revenueonline.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import th.or.pao.revenueonline.model.Account;
import th.or.pao.revenueonline.service.account.AccountService;
import th.or.pao.revenueonline.util.CustomErrorType;

import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class RevenueOnlineApiController {

    public static final Logger logger = LoggerFactory.getLogger(RevenueOnlineApiController.class);

    @Autowired
    AccountService accountService; //Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All Users---------------------------------------------

    @RequestMapping(value = "/account/", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> listAllAccounts() {
        List<Account> accounts = accountService.findAllAccounts();
        if (accounts.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    // -------------------Retrieve Single User------------------------------------------

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    public ResponseEntity<Account> getAccount(@PathVariable("id") long id) {
        logger.info("Fetching Account with id {}", id);
        Account account = accountService.findById(id);
        if (account == null) {
            logger.error("User with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Account with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    // -------------------Create a User-------------------------------------------

    @RequestMapping(value = "/account/", method = RequestMethod.POST)
    public ResponseEntity<String> createAccount(@RequestBody Account account, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Account : {}", account);

        if (accountService.isAccountExist(account)) {
            logger.error("Unable to create. A User with name {} already exist", account.getAccountName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Account with name " +
                    account.getAccountName() + " already exist."), HttpStatus.CONFLICT);
        }
        accountService.saveAccount(account);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/v1/api/account/{id}").buildAndExpand(account.getAccountId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    // ------------------- Update a User ------------------------------------------------

    @RequestMapping(value = "/account/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Account> updateAccount(@PathVariable("id") long id, @RequestBody Account account) {
        logger.info("Updating Account with id {}", id);

        Account currentAccount = accountService.findById(id);

        if (currentAccount == null) {
            logger.error("Unable to update. Account with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to update. Account with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentAccount.setAccountName(account.getAccountName());
        currentAccount.setAccountType(account.getAccountType());
        currentAccount.setAddress(account.getAddress());
        currentAccount.setBranchName(account.getBranchName());
        currentAccount.setPhone(account.getPhone());
        currentAccount.setRegistrationCer(account.getRegistrationCer());
        currentAccount.setTaxPayer(account.getTaxPayer());
        if (account.getProvince() != null) {
            currentAccount.setProvince(account.getProvince());
        }

        accountService.updateAccount(currentAccount);
        return new ResponseEntity<>(currentAccount, HttpStatus.OK);
    }

    // ------------------- Delete a User-----------------------------------------

    @RequestMapping(value = "/account/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Account with id {}", id);

        Account account = accountService.findById(id);
        if (account == null) {
            logger.error("Unable to delete. Account with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Account with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        accountService.deleteAccountById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ------------------- Delete All Users-----------------------------

    @RequestMapping(value = "/account/", method = RequestMethod.DELETE)
    public ResponseEntity<Account> deleteAllAccounts() {
        logger.info("Deleting All Accounts");

        accountService.deleteAllAccounts();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
