package lab.ash.jparepo.consent;

import lab.ash.model.consent.ConsentAttachmentHistory;
import lab.ash.model.consent.ConsentHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ConsentAttachmentHistoryDAO extends JpaRepository<ConsentAttachmentHistory, Long> {

	@Query("select x from ConsentAttachmentHistory x where x.consentHeader = ?1 and x.actionDate = (select max(actionDate) from ConsentAttachmentHistory where consentHeader = ?1)")
	ConsentAttachmentHistory findByCurrentConsentHeaderOrderByActionDateDesc(
			final ConsentHeader consentHeader);

}