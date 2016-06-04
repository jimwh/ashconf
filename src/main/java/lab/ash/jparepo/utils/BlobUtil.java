package lab.ash.jparepo.utils;

import java.io.InputStream;
import lab.ash.model.BlobEntity;
import lab.ash.model.StampedBlobEntity;

public interface BlobUtil {
    void setBlob(final BlobEntity blobEntity, final InputStream inputStream, final long streamLength);
    void setStampedBlob(final StampedBlobEntity stampedBlobEntity, final InputStream inputStream, final long streamLength);
    void copy(final BlobEntity source, final BlobEntity destination);
}
