package lab.ash.jparepo.utils;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.jdbc.support.SQLExceptionSubclassTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.util.Assert;

import lab.ash.model.BlobEntity;
import lab.ash.model.StampedBlobEntity;

public class HibernateBlobUtil implements BlobUtil {
    @PersistenceContext
    private EntityManager entityManager;

    private Blob createBlob(final InputStream inputStream, final long streamLength) {
        Assert.notNull(inputStream);
        
        final Session session = entityManager.unwrap(Session.class);
        return Hibernate.getLobCreator(session).createBlob(inputStream, streamLength);
    }

    @Override
    public void setBlob(final BlobEntity blobEntity, final InputStream inputStream,
            final long streamLength) {
        Assert.notNull(blobEntity);

        final Blob blob = createBlob(inputStream, streamLength);
        blobEntity.setBlob(blob);
    }

    @Override
    public void setStampedBlob(final StampedBlobEntity stampedBlobEntity, final InputStream inputStream,
            final long streamLength) {
        Assert.notNull(stampedBlobEntity);

        final Blob blob = createBlob(inputStream, streamLength);
        stampedBlobEntity.setStampedBlob(blob);
    }

    @Override
    public void copy(final BlobEntity source, final BlobEntity destination) {
        try {
            destination.setBlob(createBlob(source.getBlob().getBinaryStream(), 1L));
        } catch (SQLException e) {
            final SQLExceptionTranslator sqlExceptionTranslator = new SQLExceptionSubclassTranslator();
            throw sqlExceptionTranslator.translate("Create Blob", null, e);
        }
    }

}
