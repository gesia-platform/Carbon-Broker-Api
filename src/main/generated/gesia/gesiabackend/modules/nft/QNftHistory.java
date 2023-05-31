package gesia.gesiabackend.modules.nft;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNftHistory is a Querydsl query type for NftHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNftHistory extends EntityPathBase<NftHistory> {

    private static final long serialVersionUID = -1923010345L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNftHistory nftHistory = new QNftHistory("nftHistory");

    public final gesia.gesiabackend.modules.common.QBaseTimeEntity _super = new gesia.gesiabackend.modules.common.QBaseTimeEntity(this);

    public final gesia.gesiabackend.modules.account.QAccount account;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final QNft nft;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final StringPath recipientWalletAddress = createString("recipientWalletAddress");

    public final StringPath senderWalletAddress = createString("senderWalletAddress");

    public final StringPath ton = createString("ton");

    public final EnumPath<TransactionStatus> transactionStatus = createEnum("transactionStatus", TransactionStatus.class);

    public QNftHistory(String variable) {
        this(NftHistory.class, forVariable(variable), INITS);
    }

    public QNftHistory(Path<? extends NftHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNftHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNftHistory(PathMetadata metadata, PathInits inits) {
        this(NftHistory.class, metadata, inits);
    }

    public QNftHistory(Class<? extends NftHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new gesia.gesiabackend.modules.account.QAccount(forProperty("account"), inits.get("account")) : null;
        this.nft = inits.isInitialized("nft") ? new QNft(forProperty("nft"), inits.get("nft")) : null;
    }

}

