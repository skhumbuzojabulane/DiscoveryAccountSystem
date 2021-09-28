package za.ac.nwu.ac.translator.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.persistence.AccountTransactionDetails;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionDetailsTranslator;

@Component
public class AccountTransactionDetailsTranslatorImpl implements AccountTransactionDetailsTranslator {

    private final AccountTransactionRepository repo;

    public AccountTransactionDetailsTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.repo = accountTransactionRepository;
    }

    @Override
    public AccountTransactionDetails save(AccountTransactionDetails accountTransactionDetails) {
        return null;
    }

    /*@Override
    public AccountTransactionDetails save(AccountTransactionDetails accountTransactionDetails) {
        try{
            return repo.save(accountTransactionDetails);
        }catch (Exception error){
            throw new RuntimeException("Unable to save from Database", error);
        }
    }*/
}
