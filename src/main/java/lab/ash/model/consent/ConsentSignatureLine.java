/** 
*    2000 Copyright Columbia University - RASCAL.  All Rights Reserved. 
**/
package lab.ash.model.consent;

import java.util.Comparator;
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
@Table(name = "ConsentSignatureLine")
@SequenceGenerator(name="ConsentSignatureLine_SEQUENCE", sequenceName="ConsentSignatureLine_SEQ")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rascalCache")
public class ConsentSignatureLine extends AbstractPersistable<Long> implements Comparable<ConsentSignatureLine> {

    //~ Static fields/initializers -----------------------------------------------------------------

    /** Use serialVersionUID for interoperability. */
    private static final long serialVersionUID = 9152894615148103523L;

    //~ Instance fields ----------------------------------------------------------------------------

    // Fields
    @JoinColumn(name = "consentHeader_oid")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsentHeader consentHeader;

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
        strategy = GenerationType.SEQUENCE, generator="ConsentSignatureLine_SEQUENCE" 
    )
    @Id private Long oid;

    @Column(
        insertable = true,
        updatable = true,
        name = "signatureLineNumber"
    )
    private Integer signatureLineNumber;

 @Column(
        insertable = true,
        updatable = true,
        name = "signatureTypeCode",
        precision = 24,
        scale = 0
    )
    private Long signatureTypeCode; 

    
    
    @Column(
            insertable = true,
            updatable = true,
            name = "SEQUENCE"
        )
    private Integer sequence;
    
    //~ Constructors -------------------------------------------------------------------------------

    /** Constructors * default constructor. */
    public ConsentSignatureLine() { }

    public ConsentSignatureLine(Long oid) {
        this.oid = oid;
    }

    public ConsentSignatureLine(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
    }


    public ConsentSignatureLine(Long oid, ConsentHeader consentHeader, Integer signatureLineNumber ) {
        this.oid = oid;
        this.consentHeader = consentHeader;
        this.signatureLineNumber = signatureLineNumber;
    }

    //~ Methods ------------------------------------------------------------------------------------

    public static Comparator<ConsentSignatureLine> sortBySignatureTypeCode() {
        return new Comparator<ConsentSignatureLine>() {
                @Override
				public int compare(ConsentSignatureLine csl1, ConsentSignatureLine csl2) {
                    if(csl1==null) return 0;
                    else if(csl1.sequence==null) return 0;
                    else if(csl2==null) return 1;
                    else if(csl2.sequence==null) return 1;
                    else return csl1.sequence - csl2.sequence;
                }

            };

    }

    public ConsentHeader getConsentHeader() {
        return this.consentHeader;
    }

    public Integer getSignatureLineNumber() {
        return this.signatureLineNumber;
    }
    


    public void setConsentHeader(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
    }

    public void setSignatureLineNumber(Integer signatureLineNumber) {
        this.signatureLineNumber = signatureLineNumber;
    }

    public void setSignatureTypeCode(Long signatureTypeCode) {
        this.signatureTypeCode = signatureTypeCode;
    }
    
    public Long getSignatureTypeCode() {
        return this.signatureTypeCode;
    }
    
    
	@Override
	public Long getId() {
		return this.oid;
	}

	@Override
	protected void setId(Long oid) {
		this.oid = oid;
		
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}


	@Override
	public int compareTo(ConsentSignatureLine o1) {
		 return(sequence - o1.sequence);
	}
	
}
