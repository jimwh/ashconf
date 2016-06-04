/** 
*    2000 Copyright Columbia University - RASCAL.  All Rights Reserved. 
**/
package lab.ash.model.consent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lab.ash.model.AbstractPersistable;


/**
 * ConsentStaticParagraph entity.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "ConsentStaticParagraph")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rascalCache")
public class ConsentStaticParagraph extends AbstractPersistable<Long> {

    //~ Static fields/initializers -----------------------------------------------------------------

    /** Use serialVersionUID for interoperability. */
    private static final long serialVersionUID = 9209532711210422809L;

    //~ Instance fields ----------------------------------------------------------------------------

    // Fields

    @Column(
        insertable = true,
        updatable = true,
        name = "active",
        length = 1
    )
    private String active;

    @Column(
        insertable = true,
        updatable = true,
        name = "description"
    )
    private String description;

    @Column(
        insertable = true,
        updatable = true,
        name = "language",
        length = 30
    )
    private String language;

    // Fields

    @Column(
        insertable = true,
        updatable = true,
        name = "oid",
        unique = true,
        nullable = false,
        precision = 24,
        scale = 0
    )
    @Id private Long oid;

    @Column(
        insertable = true,
        updatable = true,
        name = "paragraphText"
    )
    private String paragraphText;

    @Column(
        insertable = true,
        updatable = true,
        name = "type",
        length = 30
    )
    private String type;

    //~ Constructors -------------------------------------------------------------------------------

    /** Constructors * default constructor. */
    public ConsentStaticParagraph() { }


    public ConsentStaticParagraph(Long oid) {
        this.oid = oid;
    }

    public ConsentStaticParagraph(Long oid, String description, String paragraphText,
        String language, String type, String active
        ) {
        this.oid = oid;
        this.description = description;
        this.paragraphText = paragraphText;
        this.language = language;
        this.type = type;
        this.active = active;
    }

    //~ Methods ------------------------------------------------------------------------------------

    public String getActive() {
        return this.active;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getParagraphText() {
        return this.paragraphText;
    }


    public String getType() {
        return this.type;
    }


    public void setActive(String active) {
        this.active = active;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }


    public void setParagraphText(String paragraphText) {
        this.paragraphText = paragraphText;
    }


    public void setType(String type) {
        this.type = type;
    }
    
	@Override
	public Long getId() {
		return this.oid;
	}

	@Override
	protected void setId(Long oid) {
		this.oid = oid;
		
	}
}
