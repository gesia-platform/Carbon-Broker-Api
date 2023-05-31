package gesia.gesiabackend.modules.account;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBank is a Querydsl query type for Bank
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QBank extends BeanPath<Bank> {

    private static final long serialVersionUID = 137626314L;

    public static final QBank bank = new QBank("bank");

    public final StringPath accountNumber = createString("accountNumber");

    public final StringPath name = createString("name");

    public QBank(String variable) {
        super(Bank.class, forVariable(variable));
    }

    public QBank(Path<? extends Bank> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBank(PathMetadata metadata) {
        super(Bank.class, metadata);
    }

}

