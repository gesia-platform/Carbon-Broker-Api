package gesia.gesiabackend.modules.account;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccountInfo is a Querydsl query type for AccountInfo
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QAccountInfo extends BeanPath<AccountInfo> {

    private static final long serialVersionUID = 1393093677L;

    public static final QAccountInfo accountInfo = new QAccountInfo("accountInfo");

    public final StringPath businessNumber = createString("businessNumber");

    public final StringPath contact = createString("contact");

    public final StringPath detailAddress = createString("detailAddress");

    public final StringPath fax = createString("fax");

    public final StringPath introduction = createString("introduction");

    public final StringPath name = createString("name");

    public final StringPath representativeName = createString("representativeName");

    public final StringPath streetAddress = createString("streetAddress");

    public QAccountInfo(String variable) {
        super(AccountInfo.class, forVariable(variable));
    }

    public QAccountInfo(Path<? extends AccountInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccountInfo(PathMetadata metadata) {
        super(AccountInfo.class, metadata);
    }

}

