package lab.ash.jparepo.consent;

import java.util.List;
import lab.ash.model.consent.ConsentFormElement;
import lab.ash.model.consent.ConsentHeader;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsentFormElementDAO extends JpaRepository<ConsentFormElement, Long>{

	List<ConsentFormElement> findByConsentHeaderOrderBySequenceNumber(final ConsentHeader consent);

	ConsentFormElement findByParagraphOid(final Long oid);

}