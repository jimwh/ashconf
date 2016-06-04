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



/**
 * ConsentFormElement entity.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "ConsentFormElement")
@SequenceGenerator(name="ConsentFormElement_SEQUENCE", sequenceName="ConsentFormElement_SEQ")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rascalCache")
public class ConsentFormElement extends AbstractPersistable<Long> {

    //~ Static fields/initializers -----------------------------------------------------------------

    /** Use serialVersionUID for interoperability. */
    private static final long serialVersionUID = -1849360270316851488L;

    //~ Instance fields ----------------------------------------------------------------------------

    // Fields

    @JoinColumn(
        name = "consentHeader_oid",
        nullable = false
    )
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
        strategy = GenerationType.SEQUENCE, generator="ConsentFormElement_SEQUENCE" 
    )
    @Id private Long oid;

    @Column(
        insertable = true,
        updatable = true,
        name = "paragraphOid",
        precision = 24,
        scale = 0
    )
    private Long paragraphOid;

    @Column(
        insertable = true,
        updatable = true,
        name = "paragraphType"
    )
    private Integer paragraphType;

    @Column(
        insertable = true,
        updatable = true,
        name = "sequenceNumber"
    )
    private Integer sequenceNumber;

    //~ Constructors -------------------------------------------------------------------------------

    /** Constructors * default constructor. */
    public ConsentFormElement() { }


    public ConsentFormElement(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
    }


    public ConsentFormElement(Long oid, ConsentHeader consentHeader) {
        this.oid = oid;
        this.consentHeader = consentHeader;
    }


    public ConsentFormElement(Long oid, ConsentHeader consentHeader, Integer sequenceNumber,
        Long paragraphOid, Integer paragraphType
        ) {
        this.oid = oid;
        this.consentHeader = consentHeader;
        this.sequenceNumber = sequenceNumber;
        this.paragraphOid = paragraphOid;
        this.paragraphType = paragraphType;
    }

    //~ Methods ------------------------------------------------------------------------------------

    public ConsentHeader getConsentHeader() {
        return this.consentHeader;
    }

    public Long getParagraphOid() {
        return this.paragraphOid;
    }

    public Integer getParagraphType() {
        return this.paragraphType;
    }

    public Integer getSequenceNumber() {
        return this.sequenceNumber;
    }


    public void setConsentHeader(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
    }


    public void setParagraphOid(Long paragraphOid) {
        this.paragraphOid = paragraphOid;
    }


    public void setParagraphType(Integer paragraphType) {
        this.paragraphType = paragraphType;
    }


    public void setSequenceNumber(Integer sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
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
