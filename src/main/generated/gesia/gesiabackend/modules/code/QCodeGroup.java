package gesia.gesiabackend.modules.code;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCodeGroup is a Querydsl query type for CodeGroup
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCodeGroup extends EntityPathBase<CodeGroup> {

    private static final long serialVersionUID = -1485060162L;

    public static final QCodeGroup codeGroup = new QCodeGroup("codeGroup");

    public final ListPath<Code, QCode> codes = this.<Code, QCode>createList("codes", Code.class, QCode.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath number = createString("number");

    public QCodeGroup(String variable) {
        super(CodeGroup.class, forVariable(variable));
    }

    public QCodeGroup(Path<? extends CodeGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCodeGroup(PathMetadata metadata) {
        super(CodeGroup.class, metadata);
    }

}

