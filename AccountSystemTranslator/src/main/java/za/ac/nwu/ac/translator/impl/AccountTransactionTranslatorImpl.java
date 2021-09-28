package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {

    private final AccountTransactionRepository repo;

    @Autowired
    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.repo = accountTransactionRepository;
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction){
        try{
            return repo.save(accountTransaction);
        }catch (Exception error){
            throw new RuntimeException("Unable to save to the Database");
        }
    }

    @Override
    public List<AccountTransaction> getAllAccountTransactions() {
        List<AccountTransaction> accountTransactions;
        try{
            accountTransactions = new ArrayList<>(repo.findAll());
        }catch (Exception error){
            throw new RuntimeException("Unable to save to the Database");
        }
        return accountTransactions;
    }

    @Override
    public AccountTransaction getAccountTransactionByPk(Long transactionId) {
        try{
            return repo.findById(transactionId).orElse(null);
        }catch (Exception error){
            throw new RuntimeException("Unable to save to the Database");
        }
    }
}
