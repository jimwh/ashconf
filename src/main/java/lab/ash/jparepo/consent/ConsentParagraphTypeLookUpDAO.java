package lab.ash.jparepo.consent;

import lab.ash.model.consent.ConsentParagraphTypeLookUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsentParagraphTypeLookUpDAO extends JpaRepository<ConsentParagraphTypeLookUp, Long> {

    ConsentParagraphTypeLookUp findByTypeName(String typeName);

    ConsentParagraphTypeLookUp findByUrlName(String urlName);

}