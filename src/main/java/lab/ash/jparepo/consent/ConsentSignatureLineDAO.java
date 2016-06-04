package lab.ash.jparepo.consent;

import java.util.List;
import lab.ash.model.consent.ConsentHeader;
import lab.ash.model.consent.ConsentSignatureLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConsentSignatureLineDAO extends JpaRepository<ConsentSignatureLine, Long>{

	 ConsentSignatureLine findByConsentHeaderAndSignatureTypeCodeOrderBySequence(
			 final ConsentHeader ch, final Long signatureTypeCode);

	 List<ConsentSignatureLine> findByConsentHeaderOrderBySequence(
			 final ConsentHeader ch);

	@Query(value=" select CSL.* FROM CONSENTSIGNATURELINE CSL, RASCALCONSENTSIGNATURELINE RCSL " +
				" WHERE RCSL.signaturetype=:signatureType AND   CSL.SIGNATURETYPECODE=RCSL.CODE " +
				" AND CSL.CONSENTHEADER_OID=:id ORDER BY CSL.SEQUENCE DESC ", nativeQuery = true)
	 List<ConsentSignatureLine> findByConsentHeaderAndSignatureType(
			@Param("id") Long id, @Param("signatureType") String signatureType);
}