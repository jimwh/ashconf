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
 * RascalConsentSignatureLine entity.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "RascalConsentSignatureLine")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rascalCache")
public class RascalConsentSignatureLine extends AbstractPersistable<Long> {

    //~ Static fields/initializers -----------------------------------------------------------------

    /** Use serialVersionUID for interoperability. */
    private static final long serialVersionUID = 2469678380837673308L;

    //~ Instance fields ----------------------------------------------------------------------------

    // Fields

    @Column(
        insertable = true,
        updatable = true,
        name = "code",
        unique = true,
        nullable = false,
        precision = 24,
        scale = 0
    )
    @Id private Long code;

    
    @Column(
        insertable = true,
        updatable = true,
        name = "description",
        length = 50
    )
    private String description;

    @Column(
            insertable = true,
            updatable = true,
            name = "SIGNATURETYPE"
        )
    private String signatureType;
    
    
    
    //~ Constructors -------------------------------------------------------------------------------

    /** Constructors * default constructor. */
    public RascalConsentSignatureLine() { }


    public RascalConsentSignatureLine(Long code) {
        this.code = code;
    }

    public RascalConsentSignatureLine(Long code, String description) {
        this.code = code;
        this.description = description;
    }

    //~ Methods ------------------------------------------------------------------------------------

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
	@Override
	public Long getId() {
		return this.code;
	}

	@Override
	protected void setId(Long code) {
		this.code = code;
		
	}


	public String getSignatureType() {
		return signatureType;
	}


	public void setSignatureType(String signatureType) {
		this.signatureType = signatureType;
	}
	
	
}
