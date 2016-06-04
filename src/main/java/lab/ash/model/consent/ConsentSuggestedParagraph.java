/** 
*    2000 Copyright Columbia University - RASCAL.  All Rights Reserved. 
**/
package lab.ash.model.consent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lab.ash.model.AbstractPersistable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "ConsentSuggestedParagraph")
@SequenceGenerator(name="ConsentSuggestedParagraph_SEQUENCE", sequenceName="ConsentSuggestedParagraph_SEQ")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rascalCache")
public class ConsentSuggestedParagraph extends AbstractPersistable<Long> {

    //~ Static fields/initializers -----------------------------------------------------------------

    /** Use serialVersionUID for interoperability. */
    private static final long serialVersionUID = 1001216151088335930L;

    //~ Instance fields ----------------------------------------------------------------------------

    // Fields
    @JoinColumn(name = "consentHeader_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsentHeader consentHeader;
    
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
        strategy = GenerationType.SEQUENCE, generator="ConsentSuggestedParagraph_SEQUENCE" 
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
            name = "sequenceNumber",
            nullable = false
        )
    private Integer sequenceNumber;


    @Column(
            insertable = true,
            updatable = true,
            name = "EDITABLE"
        )
    private String editable;
    
    
    //~ Constructors -------------------------------------------------------------------------------

    /** Constructors * default constructor. */
    public ConsentSuggestedParagraph() { }


    public ConsentSuggestedParagraph(Long oid) {
        this.oid = oid;
    }


    public ConsentSuggestedParagraph(Long oid, String type, String description,
        String paragraphText, String language
        ) {
        this.oid = oid;
        this.type = type;
        this.description = description;
        this.paragraphText = paragraphText;
        this.language = language;
    }

    //~ Methods ------------------------------------------------------------------------------------


    public ConsentHeader getConsentHeader() {
        return consentHeader;
    }

    public void setConsentHeader(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
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
    
    public Integer getSequenceNumber() {
        return this.sequenceNumber == null ? Integer.valueOf(0) : this.sequenceNumber;
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
    
    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
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
