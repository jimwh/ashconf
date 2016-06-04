package lab.ash.jparepo.consent;


import java.util.List;
import lab.ash.model.consent.ConsentHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsentHeaderDAO extends JpaRepository<ConsentHeader, Long> {

	List<ConsentHeader> findByPreviousConsentHeaderOid(Long previousConsentHeaderOid);
	List<ConsentHeader> findByConsentNumberOrderByCreatedDateDesc(String consentNumber);
}