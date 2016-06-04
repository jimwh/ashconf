package lab.ash.model;

import java.sql.Blob;

public interface StampedBlobEntity {
    Blob getStampedBlob();
    void setStampedBlob(Blob stampedBlob);
}
