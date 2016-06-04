package lab.ash.jparepo.consent;

import java.util.List;
import lab.ash.model.consent.RascalConsentSignatureLine;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RascalConsentSignatureLineDAO extends JpaRepository<RascalConsentSignatureLine, Long>{
		List<RascalConsentSignatureLine> findBySignatureType(String signatureType);
}