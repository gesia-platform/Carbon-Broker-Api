package gesia.gesiabackend.modules.key;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QApiKey is a Querydsl query type for ApiKey
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QApiKey extends EntityPathBase<ApiKey> {

    private static final long serialVersionUID = 947883265L;

    public static final QApiKey apiKey = new QApiKey("apiKey");

    public final gesia.gesiabackend.modules.common.QBaseTimeEntity _super = new gesia.gesiabackend.modules.common.QBaseTimeEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DateTimePath<java.time.LocalDateTime> dueDate = createDateTime("dueDate", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath key = createString("key");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath secretKey = createString("secretKey");

    public final EnumPath<ApiKeyType> type = createEnum("type", ApiKeyType.class);

    public QApiKey(String variable) {
        super(ApiKey.class, forVariable(variable));
    }

    public QApiKey(Path<? extends ApiKey> path) {
        super(path.getType(), path.getMetadata());
    }

    public QApiKey(PathMetadata metadata) {
        super(ApiKey.class, metadata);
    }

}

