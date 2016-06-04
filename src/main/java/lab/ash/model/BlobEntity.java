package lab.ash.model;

import java.sql.Blob;

public interface BlobEntity {
    Blob getBlob();
    void setBlob(Blob blob);
}
