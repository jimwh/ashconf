package lab.ash.jparepo.consent;

import java.util.List;
import lab.ash.model.consent.ConsentHeader;
import lab.ash.model.consent.ConsentSnapshot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsentSnapshotDAO extends JpaRepository<ConsentSnapshot, Long> {

    List<ConsentSnapshot> findByConsentHeaderOrderByOidDesc(final ConsentHeader consentHeader);
}