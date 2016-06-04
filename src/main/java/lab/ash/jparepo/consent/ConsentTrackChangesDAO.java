package lab.ash.jparepo.consent;

import lab.ash.model.consent.ConsentTrackChanges;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsentTrackChangesDAO extends JpaRepository<ConsentTrackChanges, Long>{

}