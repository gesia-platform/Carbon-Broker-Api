package gesia.gesiabackend.modules.nft;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface NftHistoryRepository extends JpaRepository <NftHistory, Long> {

    @Query("SELECT n FROM Account a JOIN a.nftHistories n WHERE a.id = :id")
    List<NftHistory> findNftHistoriesByAccountId(@Param("id") Long id);

    @Query("SELECT n FROM NftHistory n WHERE n.account.id = :accountId AND n.id = :historyId")
    List<NftHistory> findByAccountIdAndHistoryId(@Param("accountId") Long accountId, @Param("historyId") Long historyId);

    List<NftHistory> findByAccountIdAndTransactionStatusIn(Long id, List<TransactionStatus> asList);

    Optional<NftHistory> findByNftAndTransactionStatus(Nft nft, TransactionStatus sale);

    List<NftHistory> findByAccountIdAndIdAndTransactionStatus(Long accountId, Long historyId, TransactionStatus holding);
}