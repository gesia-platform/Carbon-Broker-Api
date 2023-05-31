package gesia.gesiabackend.modules.nfv;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QType is a Querydsl query type for Type
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QType extends EntityPathBase<Type> {

    private static final long serialVersionUID = 780217687L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QType type = new QType("type1");

    public final QCategory category;

    public final StringPath code = createString("code");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QType(String variable) {
        this(Type.class, forVariable(variable), INITS);
    }

    public QType(Path<? extends Type> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QType(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QType(PathMetadata metadata, PathInits inits) {
        this(Type.class, metadata, inits);
    }

    public QType(Class<? extends Type> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
    }

}

