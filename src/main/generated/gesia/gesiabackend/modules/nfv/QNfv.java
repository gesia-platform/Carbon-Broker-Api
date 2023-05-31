package gesia.gesiabackend.modules.nfv;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QNfv is a Querydsl query type for Nfv
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNfv extends EntityPathBase<Nfv> {

    private static final long serialVersionUID = 856445953L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QNfv nfv = new QNfv("nfv");

    public final gesia.gesiabackend.modules.common.QBaseTimeEntity _super = new gesia.gesiabackend.modules.common.QBaseTimeEntity(this);

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final QCertification certification;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imageUrl = createString("imageUrl");

    public final StringPath introduction = createString("introduction");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final ListPath<gesia.gesiabackend.modules.nft.Nft, gesia.gesiabackend.modules.nft.QNft> nfts = this.<gesia.gesiabackend.modules.nft.Nft, gesia.gesiabackend.modules.nft.QNft>createList("nfts", gesia.gesiabackend.modules.nft.Nft.class, gesia.gesiabackend.modules.nft.QNft.class, PathInits.DIRECT2);

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final NumberPath<Integer> quantity = createNumber("quantity", Integer.class);

    public final StringPath ton = createString("ton");

    public QNfv(String variable) {
        this(Nfv.class, forVariable(variable), INITS);
    }

    public QNfv(Path<? extends Nfv> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QNfv(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QNfv(PathMetadata metadata, PathInits inits) {
        this(Nfv.class, metadata, inits);
    }

    public QNfv(Class<? extends Nfv> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.certification = inits.isInitialized("certification") ? new QCertification(forProperty("certification"), inits.get("certification")) : null;
    }

}

