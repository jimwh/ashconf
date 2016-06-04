/** 
*    2015 Copyright Columbia University - RASCAL.  All Rights Reserved. 
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lab.ash.model.AbstractPersistable;


/**
 * ConsentTemplate entity.
 *
 * @author   gc2563
 * @version  $Revision$, $Date$
 */
@Entity
@Table(name = "ConsentTrackChanges")
@SequenceGenerator(name="ConsentTrackChanges_SEQUENCE", sequenceName="CONSENTTEMPLATE_SEQ")
public class ConsentTrackChanges extends  AbstractPersistable<Long>   {


    /** Use serialVersionUID for interoperability. */
    private static final long serialVersionUID = -6617905682054858262L;

   

    //~ Instance fields ----------------------------------------------------------------------------

    // Fields
    @Column( insertable = true,  updatable = true,    name = "id",   unique = true, nullable = false, precision = 24,scale = 0 )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator="ConsentTrackChanges_SEQUENCE"  )   @Id 	private Long id;
    @Column( insertable = true, updatable = true,  name = "PARAMETER"  )  													private String  parameter; 
    @Column( insertable = true, updatable = true,  name = "VALUE"  )  														private String  value; 
    @Column( insertable = true, updatable = true,  name = "createdBy"  )  													private Integer createdBy; 
    @Column( insertable = true, updatable = true,  name = "createDate",  length = 23 )  @Temporal(TemporalType.TIMESTAMP) 	private Date 	createDate;
      
 
    @JoinColumn(name = "consentHeaderOid")
    @ManyToOne(fetch = FetchType.LAZY)
    private ConsentHeader consentHeader;
    
    
	public ConsentTrackChanges() {
	    this(null);
	}
	
	public ConsentTrackChanges(ConsentHeader cfHeader) {
		this.consentHeader = cfHeader;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public ConsentHeader getConsentHeader() {
		return consentHeader;
	}
	public void setConsentHeader(ConsentHeader consentHeader) {
		this.consentHeader = consentHeader;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


}



