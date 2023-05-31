package gesia.gesiabackend.modules.nft;

import gesia.gesiabackend.modules.account.Account;
import gesia.gesiabackend.modules.account.AccountRepository;
import gesia.gesiabackend.modules.common.exception.BadRequestException;
import gesia.gesiabackend.modules.nfv.dto.NftResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static gesia.gesiabackend.modules.common.Const.*;

@Service
@RequiredArgsConstructor
@Transactional
public class NftService {

    private final NftRepository nftRepository;
    private final NftHistoryRepository  nftHistoryRepository;
    private final AccountRepository accountRepository;

    public NftResponse NftMarket() {
        List<Nft> nftList = nftRepository.findByNftMarketTypeAndTransactionType(NftMarketType.PROVIDER, TransactionType.SELL);

        if (nftList.isEmpty()) {
            throw new BadRequestException(CERTIFICATION_NFT_NOT_FOUND);
        }

        return NftResponse.builder()
                .nftList(nftList)
                .build();
    }

    public NftResponse NftMarketDetail(Long id) {
        Nft nft = nftRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_ACCOUNT_NOT_FOUND));

        List<Nft> nftDetail = nftRepository.findByIdAndTransactionType(id, TransactionType.SELL)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_NFT_NOT_FOUND));

        if (nftDetail.isEmpty()) {
            throw new BadRequestException(CERTIFICATION_NFT_NOT_FOUND);
        }

        return NftResponse.builder()
                .nftList(nftDetail)
                .build();
    }

    public void BrokerBuyNft(Long id, String username) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_ACCOUNT_NOT_FOUND));

        Nft nft = nftRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_ACCOUNT_NOT_FOUND));

        if (nft.getNftMarketType() != NftMarketType.PROVIDER || nft.getTransactionType() != TransactionType.SELL) {
            throw new BadRequestException(NFT_MARKET_TYPE_NOT_FOUND);
        }

        nft.setNftMarketType(NftMarketType.BROKER);
        nft.setTransactionType(TransactionType.BUY);
        nft.setAccountId(account.getId());

        Nft savedNft = nftRepository.save(nft);

        NftHistory nftHistory = NftHistory.builder()
                .nft(savedNft)
                .senderWalletAddress(nft.getAddress())
                .price(nft.getPrice())
                .quantity(nft.getQuantity())
                .ton(nft.getTon())
                .imageUrl(nft.getImageUrl())
                .build();

        nftHistory.setAccount(account);

        nftHistoryRepository.save(nftHistory);
    }

    public NftResponse NftMarketHistory(Long id) {
        List<NftHistory> nftHistories = nftHistoryRepository.findNftHistoriesByAccountId(id);

        if (nftHistories == null || nftHistories.isEmpty())
            throw new BadRequestException(NFT_MARKET_NOT_PURCHASE_HISTORY);

        return NftResponse.builder()
                .nftHistoryList(nftHistories)
                .build();
    }

    public NftResponse BrokerNftDetail(String username, Long historyId) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_ACCOUNT_NOT_FOUND));

        List<NftHistory> nftHistoryList = nftHistoryRepository.findByAccountIdAndHistoryId(account.getId(), historyId);

        if (nftHistoryList.isEmpty()) {
            throw new BadRequestException(NFT_MARKET_NOT_FOUND_BY_ID);
        }

            return NftResponse.builder()
                    .nftHistoryList(nftHistoryList)
                    .build();
        }

    public void BrokerSaleNft(Long id) {
        NftHistory nftHistory = nftHistoryRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(NFT_MARKET_NOT_PURCHASE_HISTORY));

        Nft nft = nftHistory.getNft();
        if (nft.getTransactionType() != TransactionType.BUY) {
            throw new BadRequestException(NFT_MARKET_REGISTERED_FOR_SALE);
        }

        nft.setTransactionType(TransactionType.SELL);
        nftHistory.setTransactionStatus(TransactionStatus.SALE);

        nftRepository.save(nft);
        nftHistoryRepository.save(nftHistory);
    }

    public NftResponse BrokerNftSaleDetail(String username) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_ACCOUNT_NOT_FOUND));

        List<NftHistory> nftHistoryList = nftHistoryRepository.findByAccountIdAndTransactionStatusIn(
                account.getId(), Arrays.asList(TransactionStatus.SALE, TransactionStatus.SOLD_OUT)
        );

        if (nftHistoryList.isEmpty()) {
            throw new BadRequestException(NFT_MARKET_NOT_FOUND_BY_ID);
        }

        return NftResponse.builder()
                .nftHistoryList(nftHistoryList)
                .build();
    }

    public NftResponse BrokerAppNftMarket() {
        List<Nft> nftList = nftRepository.findByNftMarketTypeAndTransactionType(NftMarketType.BROKER, TransactionType.SELL);

        if (nftList.isEmpty()) {
            throw new BadRequestException(CERTIFICATION_NFT_NOT_FOUND);
        }

        return NftResponse.builder()
                .nftList(nftList)
                .build();
    }

    public NftResponse BrokerAppNftMarketDetail(Long id) {
        Nft nft = nftRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_ACCOUNT_NOT_FOUND));

        List<Nft> nftDetail = nftRepository.findByIdAndTransactionType(id, TransactionType.SELL)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_NFT_NOT_FOUND));

        if (nftDetail.isEmpty()) {
            throw new BadRequestException(CERTIFICATION_NFT_NOT_FOUND);
        }

        return NftResponse.builder()
                .nftList(nftDetail)
                .build();
    }

    public void BrokerAppBuyNft(Long id, String username) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(NFT_MARKET_NOT_FOUND_BY_ID));

        Nft nft = nftRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(NFT_MARKET_NOT_FOUND_BY_ID));

        NftHistory nftHistory = nftHistoryRepository.findByNftAndTransactionStatus(nft, TransactionStatus.SALE)
                .orElseThrow(() -> new BadRequestException(NFT_MARKET_TYPE_NOT_FOUND));

        if (nft.getNftMarketType() != NftMarketType.BROKER || nft.getTransactionType() != TransactionType.SELL) {
            throw new BadRequestException(NFT_MARKET_TYPE_NOT_FOUND);
        }

        nft.setNftMarketType(NftMarketType.BROKER_APP);
        nft.setTransactionType(TransactionType.BUY);
        nft.setAccountId(account.getId());

        nftHistory.setTransactionStatus(TransactionStatus.SOLD_OUT);
        nftHistory.getAccount();

        Nft savedNft = nftRepository.save(nft);

        NftHistory createNftHistory = NftHistory.builder()
                .nft(savedNft)
                .senderWalletAddress(nft.getAddress())
                .price(nft.getPrice())
                .quantity(nft.getQuantity())
                .ton(nft.getTon())
                .imageUrl(nft.getImageUrl())
                .transactionStatus(TransactionStatus.HOLDING)
                .build();

        createNftHistory.setAccount(account);
        nftHistoryRepository.save(createNftHistory);
    }

    public NftResponse BrokerAppNftMarketHistory(Long id) {
        List<NftHistory> nftHistories = nftHistoryRepository.findNftHistoriesByAccountId(id);

        if (nftHistories == null || nftHistories.isEmpty())
            throw new BadRequestException(NFT_MARKET_NOT_PURCHASE_HISTORY);

        return NftResponse.builder()
                .nftHistoryList(nftHistories)
                .build();
    }

    public NftResponse BrokerAppNftDetail(String username, Long historyId) {
        Account account = accountRepository.findByUsername(username)
                .orElseThrow(() -> new BadRequestException(CERTIFICATION_ACCOUNT_NOT_FOUND));

        List<NftHistory> nftHistoryList = nftHistoryRepository.findByAccountIdAndIdAndTransactionStatus(account.getId(), historyId, TransactionStatus.HOLDING);

        if (nftHistoryList.isEmpty()) {
            throw new BadRequestException(NFT_MARKET_NOT_FOUND_BY_ID);
        }

        return NftResponse.builder()
                .nftHistoryList(nftHistoryList)
                .build();
    }
}