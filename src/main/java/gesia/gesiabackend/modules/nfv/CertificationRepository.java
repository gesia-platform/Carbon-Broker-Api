package gesia.gesiabackend.modules.nfv;

import gesia.gesiabackend.modules.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface CertificationRepository extends JpaRepository <Certification, Long>, CertificationRepositoryCustom {

    Optional<Certification> findById(Long id);

    @Query("select c.category.name from Certification c where c.id = :certificationId")
    String findCategoryNameById(@Param("certificationId") Long certificationId);

    List<Certification> findByAccount(Account account);
}
