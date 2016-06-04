package lab.ash.jparepo.consent;

import java.util.List;
import lab.ash.model.consent.ConsentHeader;
import lab.ash.model.consent.ConsentSuggestedParagraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsentSuggestedParagraphDAO extends JpaRepository<ConsentSuggestedParagraph, Long> {
	
	 List<ConsentSuggestedParagraph> findByTypeAndLanguageOrderBySequenceNumberAsc(
			 final String type, final String language);

	 List<ConsentSuggestedParagraph> findByConsentHeaderAndTypeAndLanguageOrderBySequenceNumberAsc(
			 ConsentHeader consentHeader, String type, String language);



}