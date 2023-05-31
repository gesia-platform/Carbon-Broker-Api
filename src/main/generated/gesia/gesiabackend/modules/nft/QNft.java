package gesia.gesiabackend.modules.nft;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNft is a Querydsl query type for Nft
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNft extends EntityPathBase<Nft> {

    private static final long serialVersionUID = 854598909L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNft nft = new QNft("nft");

    public final gesia.gesiabackend.modules.common.QBaseTimeEntity _super = new gesia.gesiabackend.modules.common.QBaseTimeEntity(this);

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final StringPath address = createString("address");

    public final NumberPath<Long> certificationId = createNumber("certificationId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final StringPath introduction = createString("introduction");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final ListPath<NftHistory, QNftHistory> nftHistories = this.<NftHistory, QNftHistory>createList("nftHistories", NftHistory.class, QNftHistory.class, PathInits.DIRECT2);

    public final EnumPath<NftMarketType> nftMarketType = createEnum("nftMarketType", NftMarketType.class);

    public final gesia.gesiabackend.modules.nfv.QNfv nfv;

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final StringPath ton = createString("ton");

    public final EnumPath<TransactionType> transactionType = createEnum("transactionType", TransactionType.class);

    public QNft(String variable) {
        this(Nft.class, forVariable(variable), INITS);
    }

    public QNft(Path<? extends Nft> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNft(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNft(PathMetadata metadata, PathInits inits) {
        this(Nft.class, metadata, inits);
    }

    public QNft(Class<? extends Nft> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nfv = inits.isInitialized("nfv") ? new gesia.gesiabackend.modules.nfv.QNfv(forProperty("nfv"), inits.get("nfv")) : null;
    }

}

