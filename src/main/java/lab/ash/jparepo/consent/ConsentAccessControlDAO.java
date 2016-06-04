package lab.ash.jparepo.consent;

import java.util.List;
import lab.ash.model.consent.ConsentAccessControl;
import lab.ash.model.consent.ConsentHeader;
import lab.ash.model.consent.RascalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsentAccessControlDAO extends JpaRepository<ConsentAccessControl, Long> {

	ConsentAccessControl findByConsentHeaderAndRascalUser(
			final ConsentHeader ch, final RascalUser rascalUser);
	
	List<ConsentAccessControl> findByConsentHeader(final ConsentHeader ch);

	List<ConsentAccessControl> findByRascalUser(RascalUser rascalUser);
}