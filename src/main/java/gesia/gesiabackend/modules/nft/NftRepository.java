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
public interface NftRepository extends JpaRepository <Nft, Long> {

    Optional<Nft> findById(Long id);

    @Query("SELECT n FROM Nft n WHERE n.nftMarketType = :nftMarketType AND n.transactionType = :transactionType")
    List<Nft> findByNftMarketTypeAndTransactionType(@Param("nftMarketType") NftMarketType nftMarketType, @Param("transactionType") TransactionType transactionType);

    Optional<List<Nft>> findByIdAndTransactionType(Long id, TransactionType transactionType);
}