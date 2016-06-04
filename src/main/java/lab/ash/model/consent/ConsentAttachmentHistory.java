/** 
*    2000 Copyright Columbia University - RASCAL.  All Rights Reserved. 
**/
package lab.ash.model.consent;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lab.ash.model.AbstractPersistable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * ConsentAttachmentHistory entity.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "ConsentAttachmentHistory")
@SequenceGenerator(name="ConsentAttachmentHistory_SEQUENCE", sequenceName="ConsentAttachmentHistory_SEQ")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rascalCache")
public class ConsentAttachmentHistory extends AbstractPersistable<Long> {

    //~ Static fields/initializers -----------------------------------------------------------------

    /** Use serialVersionUID for interoperability. */
    private static final long serialVersionUID = 7092352561170241995L;

    //~ Instance fields ----------------------------------------------------------------------------

    // Fields
    @JoinColumn(
    		insertable = true, 
    		updatable = true, 
    		name = "whoRid", 
    		nullable = false)
	@OneToOne(fetch = FetchType.EAGER)
	private RascalUser createdBy;
    
    @Column(
        insertable = true,
        updatable = true,
        name = "action",
        length = 10
    )
    private String action;

    @Column(
        insertable = true,
        updatable = true,
        name = "actionDate",
        length = 23
    )
    @Temporal(TemporalType.TIMESTAMP)
    private Date actionDate;

    @JoinColumn(
        name = "consentHeader_Id",
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
        precision = 11,
        scale = 0
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE, generator="ConsentAttachmentHistory_SEQUENCE" 
    )
    @Id private Long oid;



    //~ Constructors -------------------------------------------------------------------------------

    protected ConsentAttachmentHistory() {
    }
    

    public ConsentAttachmentHistory(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
    }
    
    public ConsentAttachmentHistory(Long oid, ConsentHeader consentHeader, String action,
        Date actionDate, RascalUser createdBy
        ) {
        this.oid = oid;
        this.consentHeader = consentHeader;
        this.action = action;
        this.actionDate = actionDate;
        this.createdBy = createdBy;
    }


    protected ConsentAttachmentHistory(Long oid, ConsentHeader consentHeader) {
        this.oid = oid;
        this.consentHeader = consentHeader;
    }

    //~ Methods ------------------------------------------------------------------------------------

    public RascalUser getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(RascalUser createdBy) {
		this.createdBy = createdBy;
	}

    
    
    public String getAction() {
        return this.action;
    }

    

	public Date getActionDate() {
        return this.actionDate;
    }

    public ConsentHeader getConsentHeader() {
        return this.consentHeader;
    }


    public void setAction(String action) {
        this.action = action;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public void setConsentHeader(ConsentHeader consentHeader) {
        this.consentHeader = consentHeader;
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
