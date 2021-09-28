package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long>{

    /*@Query(value = "SELECT "+
            "         ACCOUNT_TYPE_DETAILS_ID," +
            "         ACCOUNT_TX_ID," +
            "         NUMBER_OF_ITEMS," +
            "         PARTHNER_NAME" +
            "     FROM " +
            "         JABULANE.ACCOUNT_TX_DETAILS" +
            "     WHERE at.account_tx_details_id = :account_tx_details_id", nativeQuery = true)
    AccountTransaction getAllAccountTransactions(String account_tx_details_id);

    @Query(value = "SELECT " +
            "        at" +
            "    FROM " +
            "        AccountType at" +
            "     WHERE at.account_tx_details_id = :account_tx_details_id")
    AccountType getAccountTransactionByPk(String mnemonic);*/


}
