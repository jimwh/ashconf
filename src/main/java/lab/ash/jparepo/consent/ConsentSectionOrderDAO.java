package lab.ash.jparepo.consent;


import java.util.List;
import lab.ash.model.consent.ConsentHeader;
import lab.ash.model.consent.ConsentSectionOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsentSectionOrderDAO extends JpaRepository<ConsentSectionOrder, Long> {
    List<ConsentSectionOrder> findByConsentHeaderOrderByOrderNumber(final ConsentHeader consent);
    ConsentSectionOrder findByConsentHeaderAndSectionId(final ConsentHeader consent, final Integer sectionId);
}
