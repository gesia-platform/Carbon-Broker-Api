package gesia.gesiabackend.modules.nfv;

import com.querydsl.jpa.impl.JPAQueryFactory;
import gesia.gesiabackend.modules.account.QAccount;
import gesia.gesiabackend.modules.nft.Nft;
import gesia.gesiabackend.modules.nft.QNft;
import gesia.gesiabackend.modules.nft.QNftHistory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CertificationRepositoryImpl implements CertificationRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Nfv> findNFVListByCertId(Long id) {
        QNfv nfv = QNfv.nfv;

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        return queryFactory.selectFrom(nfv)
                .where(nfv.certification.id.eq(id))
                .fetch();
    }

    @Override
    public List<Nft> findNftListByAccountSq(Long id) {
        QAccount account = QAccount.account;
        QCertification certification = QCertification.certification;
        QNfv nfv = QNfv.nfv;
        QNft nft = QNft.nft;
        QNftHistory nftHistory = QNftHistory.nftHistory;

        JPAQueryFactory queryFactory = new JPAQueryFactory(entityManager);
        return queryFactory.selectFrom(nft)
                .join(nft.nfv, nfv)
                .join(nfv.certification, certification)
                .join(certification.account, account)
                .join(nft.nftHistories, nftHistory)
                .where(account.id.eq(id))
                .fetch();
    }
}
