/** 
*    2000 Copyright Columbia University - RASCAL.  All Rights Reserved. 
**/
package lab.ash.model.consent;

import lab.ash.model.AbstractPersistable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * ConsentAccessControl entity.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "ConsentParagraphTypeLookUp")@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rascalCache")
public class ConsentParagraphTypeLookUp extends AbstractPersistable<Long> {

    //~ Static fields/initializers -----------------------------------------------------------------

    /** Use serialVersionUID for interoperability. */
    private static final long serialVersionUID = -3547784551007158391L;

    //~ Instance fields ----------------------------------------------------------------------------


    // Fields
    @Column(
        insertable = true,
        updatable = true,
        name = "typeId",
        unique = true,
        nullable = false,
        precision = 24,
        scale = 0
    )
    @Id private Long typeid;

    @Column(
            insertable = true,
            updatable = true,
            name = "typeName",
            length = 40
    )
    private String typeName;

    @Column(
            insertable = true,
            updatable = true,
            name = "urlName",
            length = 30
    )
    private String urlName;

    //~ Constructors -------------------------------------------------------------------------------

    /** Constructors * default constructor. */
    public ConsentParagraphTypeLookUp() { }


    public ConsentParagraphTypeLookUp(Long typeid) {
        this.typeid = typeid;
    }

    public Long getTypeid() {
        return typeid;
    }

    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public ConsentParagraphTypeLookUp(Long typeid, String typeName, String urlName) {
        this.typeid = typeid;
        this.typeName = typeName;

        this.urlName = urlName;
    }

    @Override
    public Long getId() {
        return typeid;
    }

    @Override
    protected void setId(Long id) {
        typeid = id;
    }
}
