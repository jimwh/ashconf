package lab.ash.service;


import java.io.InputStream;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lab.ash.jparepo.consent.ConsentSnapshotDAO;
import lab.ash.jparepo.utils.BlobUtil;
import lab.ash.model.consent.ConsentHeader;
import lab.ash.model.consent.ConsentSnapshot;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ConsentSnapshotService {

    @Resource
    private ConsentSnapshotDAO snapshotDAO;

    @Resource
    private BlobUtil blobUtil;


    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void delete(final Long headerId) {
        snapshotDAO.delete(headerId);
    }

    @Transactional
    protected void delete(final ConsentHeader consentHeader) {
        final List<ConsentSnapshot> snapshotList = findByConsentHeader(consentHeader);
        for (final ConsentSnapshot snapshot : snapshotList) {
            this.delete(snapshot.getId());
        }
    }

    public ConsentSnapshot findById(final Long headerId) {
        return snapshotDAO.findOne(headerId);
    }

    @Transactional
    public ConsentSnapshot save(final ConsentSnapshot entity,
                                final InputStream stream,
                                final long streamLength) {
        blobUtil.setBlob(entity, stream, streamLength);
        return this.save(entity);
    }

    @Transactional
    public ConsentSnapshot save(final ConsentSnapshot entity) {
        return snapshotDAO.save(entity);
    }

    @Transactional(readOnly = true)
    public List<ConsentSnapshot> findByConsentHeader(final ConsentHeader consentHeader) {
        return snapshotDAO.findByConsentHeaderOrderByOidDesc(consentHeader);
    }

}
