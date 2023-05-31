package gesia.gesiabackend.modules.account;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccountManager is a Querydsl query type for AccountManager
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccountManager extends EntityPathBase<AccountManager> {

    private static final long serialVersionUID = -1725307954L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccountManager accountManager = new QAccountManager("accountManager");

    public final gesia.gesiabackend.modules.common.QBaseTimeEntity _super = new gesia.gesiabackend.modules.common.QBaseTimeEntity(this);

    public final QAccount account;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public QAccountManager(String variable) {
        this(AccountManager.class, forVariable(variable), INITS);
    }

    public QAccountManager(Path<? extends AccountManager> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccountManager(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccountManager(PathMetadata metadata, PathInits inits) {
        this(AccountManager.class, metadata, inits);
    }

    public QAccountManager(Class<? extends AccountManager> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new QAccount(forProperty("account"), inits.get("account")) : null;
    }

}

