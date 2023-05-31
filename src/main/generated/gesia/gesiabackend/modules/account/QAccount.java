package gesia.gesiabackend.modules.account;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 1786551007L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccount account = new QAccount("account");

    public final gesia.gesiabackend.modules.common.QBaseTimeEntity _super = new gesia.gesiabackend.modules.common.QBaseTimeEntity(this);

    public final QAccountInfo accountInfo;

    public final ListPath<AccountManager, QAccountManager> accountManager = this.<AccountManager, QAccountManager>createList("accountManager", AccountManager.class, QAccountManager.class, PathInits.DIRECT2);

    public final EnumPath<AccountType> accountType = createEnum("accountType", AccountType.class);

    public final EnumPath<ApprovalStatus> approvalStatus = createEnum("approvalStatus", ApprovalStatus.class);

    public final QBank bank;

    public final ListPath<gesia.gesiabackend.modules.nfv.Certification, gesia.gesiabackend.modules.nfv.QCertification> certifications = this.<gesia.gesiabackend.modules.nfv.Certification, gesia.gesiabackend.modules.nfv.QCertification>createList("certifications", gesia.gesiabackend.modules.nfv.Certification.class, gesia.gesiabackend.modules.nfv.QCertification.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DateTimePath<java.time.LocalDateTime> disableAt = createDateTime("disableAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final ListPath<gesia.gesiabackend.modules.nft.NftHistory, gesia.gesiabackend.modules.nft.QNftHistory> nftHistories = this.<gesia.gesiabackend.modules.nft.NftHistory, gesia.gesiabackend.modules.nft.QNftHistory>createList("nftHistories", gesia.gesiabackend.modules.nft.NftHistory.class, gesia.gesiabackend.modules.nft.QNftHistory.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final StringPath username = createString("username");

    public QAccount(String variable) {
        this(Account.class, forVariable(variable), INITS);
    }

    public QAccount(Path<? extends Account> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccount(PathMetadata metadata, PathInits inits) {
        this(Account.class, metadata, inits);
    }

    public QAccount(Class<? extends Account> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.accountInfo = inits.isInitialized("accountInfo") ? new QAccountInfo(forProperty("accountInfo")) : null;
        this.bank = inits.isInitialized("bank") ? new QBank(forProperty("bank")) : null;
    }

}

