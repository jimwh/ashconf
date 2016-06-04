package lab.ash.jparepo.consent;

import java.util.List;
import lab.ash.model.consent.ConsentDynamicParagraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ConsentDynamicParagraphDAO extends JpaRepository<ConsentDynamicParagraph, Long>{

    @Query("select p from  ConsentDynamicParagraph p ,"  +
            "ConsentFormElement e ,ConsentHeader h where  e.paragraphOid = p.oid " +
            "and e.consentHeader = h.oid " +
            "and h.oid = :headerOid AND p.type = :texttype ")
    List<ConsentDynamicParagraph> findParagraphBy(@Param("headerOid") Long headerOid, @Param("texttype") String texttype);



}