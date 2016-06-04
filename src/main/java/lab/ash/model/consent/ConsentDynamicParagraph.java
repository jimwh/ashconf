/** 
*    2000 Copyright Columbia University - RASCAL.  All Rights Reserved. 
**/
package lab.ash.model.consent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lab.ash.model.AbstractPersistable;


/**
 * ConsentDynamicParagraph entity.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "ConsentDynamicParagraph")
@SequenceGenerator(name="ConsentDynamicParagraph_SEQUENCE", sequenceName="ConsentDynamicParagraph_SEQ")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rascalCache")
public class ConsentDynamicParagraph extends AbstractPersistable<Long> {

    //~ Static fields/initializers -----------------------------------------------------------------

    /** Use serialVersionUID for interoperability. */
    private static final long serialVersionUID = 7957334089165870416L;

    //~ Instance fields ----------------------------------------------------------------------------

    // Fields

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
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, generator="ConsentDynamicParagraph_SEQUENCE" 
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

    
    
    @Column(
            insertable = true,
            updatable = true,
            name = "EDITABLE"
        )
    private String editable;
    
    //~ Constructors -------------------------------------------------------------------------------

	/** Constructors * default constructor. */
    public ConsentDynamicParagraph() { }


    public ConsentDynamicParagraph(Long oid) {
        this.oid = oid;
    }


    public ConsentDynamicParagraph(Long oid, String description, String paragraphText,
        String language, String type
        ) {
        this.oid = oid;
        this.description = description;
        this.paragraphText = paragraphText;
        this.language = language;
        this.type = type;
    }

    //~ Methods ------------------------------------------------------------------------------------

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


	public boolean isEditable() {
		return "Y".equals(editable);
	}

	public void setEditable(boolean editable) {
		if(editable) {
			this.editable = "Y";
		} else {
			this.editable = "N";
		}
	}

}
