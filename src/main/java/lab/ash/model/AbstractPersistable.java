package lab.ash.model;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostRemove;
import javax.persistence.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class AbstractPersistable<PK extends Serializable> implements Persistable<PK> {

    private static final long serialVersionUID = -5554308939380869754L;
    private static final Logger LOG = LoggerFactory.getLogger(AbstractPersistable.class);

    @Version private Integer version;

    @Override public abstract PK getId();

    @Override public boolean equals(final Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!getClass().equals(obj.getClass())) {
            return false;
        }

        final AbstractPersistable<?> that = (AbstractPersistable<?>) obj;

        return null != this.getId() && this.getId().equals(that.getId());
    }

    public Integer getVersion() {
        return version;
    }

    @Override public int hashCode() {

        int hashCode = 17;

        hashCode += null == getId() ? 0 : getId().hashCode() * 31;

        return hashCode;
    }

    @Override public boolean isNew() {
        return null == getId();
    }

    @Override public String toString() {
        return String.format("type=%s, id=%s", this.getClass().getName(), getId());
    }

    protected abstract void setId(final PK id);

    protected void setVersion(final Integer version) {
        this.version = version;
    }

    @PostRemove
    private void auditLogger() {//NOPMD
        LOG.warn("{} has deleted", this.toString());
    }
}
