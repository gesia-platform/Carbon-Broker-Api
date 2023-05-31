package gesia.gesiabackend.modules.nfv;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCertification is a Querydsl query type for Certification
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCertification extends EntityPathBase<Certification> {

    private static final long serialVersionUID = 514737981L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCertification certification = new QCertification("certification");

    public final gesia.gesiabackend.modules.common.QBaseTimeEntity _super = new gesia.gesiabackend.modules.common.QBaseTimeEntity(this);

    public final gesia.gesiabackend.modules.account.QAccount account;

    public final StringPath address = createString("address");

    public final StringPath apiParameter = createString("apiParameter");

    public final StringPath apiUrl = createString("apiUrl");

    public final EnumPath<gesia.gesiabackend.modules.account.ApprovalStatus> approvalStatus = createEnum("approvalStatus", gesia.gesiabackend.modules.account.ApprovalStatus.class);

    public final EnumPath<BusinessType> businessType = createEnum("businessType", BusinessType.class);

    public final QCategory category;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DateTimePath<java.time.LocalDateTime> dueDate = createDateTime("dueDate", java.time.LocalDateTime.class);

    public final StringPath filePath = createString("filePath");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath institutionName = createString("institutionName");

    public final EnumPath<IssuanceType> issuanceType = createEnum("issuanceType", IssuanceType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final QNfv nfv;

    public final StringPath number = createString("number");

    public final EnumPath<ParticipationType> participationType = createEnum("participationType", ParticipationType.class);

    public final StringPath registrationNumber = createString("registrationNumber");

    public final StringPath representativeName = createString("representativeName");

    public final StringPath walletAddr = createString("walletAddr");

    public final StringPath yearlyAuthQuantity = createString("yearlyAuthQuantity");

    public QCertification(String variable) {
        this(Certification.class, forVariable(variable), INITS);
    }

    public QCertification(Path<? extends Certification> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCertification(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCertification(PathMetadata metadata, PathInits inits) {
        this(Certification.class, metadata, inits);
    }

    public QCertification(Class<? extends Certification> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new gesia.gesiabackend.modules.account.QAccount(forProperty("account"), inits.get("account")) : null;
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
        this.nfv = inits.isInitialized("nfv") ? new QNfv(forProperty("nfv"), inits.get("nfv")) : null;
    }

}

