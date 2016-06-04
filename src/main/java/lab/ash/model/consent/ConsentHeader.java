package lab.ash.model.consent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lab.ash.model.AbstractAuditable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.joda.time.DateTime;

@Entity
@Table(name = "ConsentHeader")
@SequenceGenerator(name="ConsentHeader_SEQUENCE", sequenceName="ConsentHeader_SEQ")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rascalCache")
public class ConsentHeader extends AbstractAuditable<RascalUser, Long> implements Serializable {

    private static final long serialVersionUID = 2734406913209357302L;

    /*
    @JoinColumn(
    		insertable = true, 
    		updatable = true, 
    		name = "irbProtocolHeaderId", 
    		nullable = true)
    //@ManyToOne(fetch = FetchType.EAGER)
	//private IrbProtocolHeader irbProtocolHeader;
    */
    @Column(
            insertable = true,
            updatable = true,
            name = "irbProtocolHeaderId",
            nullable = true)
    //@ManyToOne(fetch = FetchType.EAGER)
    //private IrbProtocolHeader irbProtocolHeader;

    private Long irbProtocolHeaderId;

    @Column(
        insertable = true,
        updatable = true,
        name = "anticipatedNumberOfSubjects",
        length = 10
    )
    private String anticipatedNumberOfSubjects;

    @Column(
            insertable = true,
            updatable = true,
            name = "printSignatureWithDateTime"
        )
        private String printSignatureWithDateTime;
    
    
    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "consentHeader"
    )
    @OrderBy
    private List<ConsentAccessControl> consentAccessControls = new ArrayList<ConsentAccessControl>(0);

    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "consentHeader"
    )
    private List<ConsentAttachmentHistory> consentAttachmentHistories =
        new ArrayList<ConsentAttachmentHistory>(0);


    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "consentHeader"
    )
    @OrderBy
    private List<ConsentFormElement> consentFormElements = new ArrayList<ConsentFormElement>(0);

    @Column(
        insertable = true,
        updatable = true,
        name = "consentNumber",
        length = 10
    )
    private String consentNumber;

    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "consentHeader"
    )
    private Set<ConsentSignatureLine> consentSignatureLines = new HashSet<ConsentSignatureLine>(0);

    @Column(
            insertable = true,
            updatable = true,
            name = "legacy",
            length = 1
    )
    private String legacy;

    @OneToMany(
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        mappedBy = "consentHeader"
    )
    private List<ConsentSuggestedParagraph> consentSuggestedParagraph = new ArrayList<ConsentSuggestedParagraph>(0);

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "consentHeader"
    )
    @OrderBy
    private List<ConsentSectionOrder> consentSectionOrder = new ArrayList<ConsentSectionOrder>(0);

    public List<ConsentSectionOrder> getConsentSectionOrder() {
        return this.consentSectionOrder;
    }

    public void setConsentSectionOrder(List<ConsentSectionOrder> list) {
        this.consentSectionOrder = list;
    }

    @Column(
        insertable = true,
        updatable = true,
        name = "footerInformation"
    )
    private String footerInformation;

    @Column(
        insertable = true,
        updatable = true,
        name = "formType",
        length = 20
    )
    private String formType;

    @Column(
        insertable = true,
        updatable = true,
        name = "language",
        length = 30
    )
    private String language;

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
        strategy = GenerationType.SEQUENCE, generator="ConsentHeader_SEQUENCE" 
    )
    @Id private Long oid;

    @Column(
        insertable = true,
        updatable = true,
        name = "participationDuration"
    )
    private String participationDuration;

    @Column(
        insertable = true,
        updatable = true,
        name = "previousConsentHeaderOid",
        precision = 24,
        scale = 0
    )
    private Long previousConsentHeaderOid;

    @Column(
        insertable = true,
        updatable = true,
        name = "researchPurpose"
    )
    private String researchPurpose;

    @Column(
        insertable = true,
        updatable = true,
        name = "title"
    )
    private String title;

    public ConsentHeader() {
    	this.legacy = "N";
        this.setCreatedDate(new DateTime());
    }

    public ConsentHeader(RascalUser aUser) {
        this.setCreatedDate(new DateTime());
        this.setCreatedBy(aUser);
        this.setLastModifiedBy(aUser);
        this.setLastModifiedDate(new DateTime());

    }

    public String getAnticipatedNumberOfSubjects() {
        return this.anticipatedNumberOfSubjects;
    }

    public List<ConsentAccessControl> getConsentAccessControls() {
        return this.consentAccessControls;
    }

    public List<ConsentAttachmentHistory> getConsentAttachmentHistories() {
        return this.consentAttachmentHistories;
    }

    public List<ConsentFormElement> getConsentFormElements() {
        return this.consentFormElements;
    }

    public String getConsentNumber() {
        return this.consentNumber;
    }

    public Set<ConsentSignatureLine> getConsentSignatureLines() {
        return this.consentSignatureLines;
    }

    public String getFooterInformation() {
        return this.footerInformation;
    }

    public String getFormType() {
        return this.formType;
    }

    public String getLanguage() {
        return this.language;
    }


    public String getParticipationDuration() {
        return this.participationDuration;
    }

    public List<ConsentSuggestedParagraph> getConsentSuggestedParagraph() {
		return consentSuggestedParagraph;
	}

	public void setConsentSuggestedParagraph(
			List<ConsentSuggestedParagraph> consentSuggestedParagraph) {
		this.consentSuggestedParagraph = consentSuggestedParagraph;
	}

    public Long getPreviousConsentHeaderOid() {
        return this.previousConsentHeaderOid;
    }

    public String getResearchPurpose() {
        return this.researchPurpose;
    }


    public String getTitle() {
        return this.title;
    }
    
    public void setAnticipatedNumberOfSubjects(String anticipatedNumberOfSubjects) {
        this.anticipatedNumberOfSubjects = anticipatedNumberOfSubjects;
    }

    public void setConsentAccessControls(List<ConsentAccessControl> consentAccessControls) {
        this.consentAccessControls = consentAccessControls;
    }

    public void setConsentAttachmentHistories( List<ConsentAttachmentHistory> consentAttachmentHistories) {
        this.consentAttachmentHistories = consentAttachmentHistories;
    }

    public void setConsentFormElements(List<ConsentFormElement> consentFormElements) {
        this.consentFormElements = consentFormElements;
    }

    public void setConsentNumber(String consentNumber) {
        this.consentNumber = consentNumber;
    }


    public void setConsentSignatureLines(Set<ConsentSignatureLine> consentSignatureLines) {
        this.consentSignatureLines = consentSignatureLines;
    }

    public void setFooterInformation(String footerInformation) {
        this.footerInformation = footerInformation;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }


    public void setLanguage(String language) {
        this.language = language;
    }


    public void setParticipationDuration(String participationDuration) {
        this.participationDuration = participationDuration;
    }


    public void setPreviousConsentHeaderOid(Long previousConsentHeaderOid) {
        this.previousConsentHeaderOid = previousConsentHeaderOid;
    }

 
    public void setResearchPurpose(String researchPurpose) {
        this.researchPurpose = researchPurpose;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    
	@Override
	public Long getId() {
		return this.oid;
	}

	@Override
	protected void setId(Long oid) {
		this.oid = oid;
	}

    /*
	public IrbProtocolHeader getIrbProtocolHeader() {
		return irbProtocolHeader;
	}

	public void setIrbProtocolHeader(IrbProtocolHeader irbProtocolHeader) {
		this.irbProtocolHeader = irbProtocolHeader;
	}
    */
    public Long getIrbProtocolHeaderId() {
        return irbProtocolHeaderId;
    }

    public void setIrbProtocolHeaderId(Long irbProtocolHeaderId) {
        this.irbProtocolHeaderId = irbProtocolHeaderId;
    }

	public String getPrintSignatureWithDateTime() {
		return printSignatureWithDateTime;
	}

	public void setPrintSignatureWithDateTime(String printSignatureWithDateTime) {
		this.printSignatureWithDateTime = printSignatureWithDateTime;
	}

    public String getLegacy() {
        return legacy;
    }
    public void setLegacy(final String legacy) {
        this.legacy = legacy;
    }
	// public boolean isLegacy() {  return "Y".equals(this.legacy); }
}
