/**
 *    2000 Copyright Columbia University - RASCAL.  All Rights Reserved.
 **/
package lab.ash.model.consent;

import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import lab.ash.model.AbstractPersistable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


/**
 * RascalUser entity.
 *
 * @author   $author$
 * @version  $Revision$, $Date$
 */
@Entity
@Table(
		name = "RASCAL_USER",
		uniqueConstraints = @UniqueConstraint(columnNames = "user_id")
		)
@SequenceGenerator(name="RascalUser_SEQUENCE", sequenceName="RascalUser_SEQ")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE, region="rascalCache")
public class RascalUser extends AbstractPersistable<Integer> {

	//~ Static fields/initializers -----------------------------------------------------------------

	/*public boolean directRequest = false; TODO
	 * the direct request variable causes bad deployments, because there is no DB column by the same
	 * name. I think we can just any of these old directRequest references because it is VAP
	 * related?
	 */
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 2574157210971703675L;

	//~ Instance fields ----------------------------------------------------------------------------

	@Column(
			insertable = true,
			updatable = true,
			name = "addressLine1",
			length = 60
			)
	private String addressLine1;

	@Column(
			insertable = true,
			updatable = true,
			name = "addressLine2",
			length = 60
			)
	private String addressLine2;

	@Column(
			insertable = true,
			updatable = true,
			name = "addressLine3",
			length = 60
			)
	private String addressLine3;

	@Column(
			insertable = true,
			updatable = true,
			name = "addressLine4",
			length = 60
			)
	private String addressLine4;

	@Column(
			insertable = true,
			updatable = true,
			name = "affiliatedInstitution",
			length = 60
			)
	private String affiliatedInstitution;

	@Column(
			insertable = true,
			updatable = true,
			name = "beeperPreferred",
			length = 16
			)
	private String beeperPreferred;

	@Column(
			insertable = true,
			updatable = true,
			name = "cancerCenter",
			length = 1
			)
	private String cancerCenter;

	@Column(
			insertable = true,
			updatable = true,
			name = "city",
			length = 60
			)
	private String city;

	@Column(
			insertable = true,
			updatable = true,
			name = "conflictInterest",
			length = 1
			)
	private String conflictInterest;

	@Column(
			insertable = true,
			updatable = true,
			name = "conflictInterestDate",
			length = 23
			)
	@Temporal(TemporalType.TIMESTAMP)
	private Date conflictInterestDate;

	@Column(
			insertable = true,
			updatable = true,
			name = "country",
			length = 60
			)
	private String country;

	@Column(
			insertable = true,
			updatable = true,
			name = "creation_date",
			nullable = false,
			length = 23
			)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@Column(
			insertable = true,
			updatable = true,
			name = "dateOfHire",
			length = 23
			)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfHire;

	@Column(
			insertable = true,
			updatable = true,
			name = "delete_flag",
			nullable = false,
			length = 1
			)
	private String deleteFlag;

	@Column(
			insertable = true,
			updatable = true,
			name = "dept_home",
			length = 3
			)
	private String deptHome;

	@Column(
			insertable = true,
			updatable = true,
			name = "email_preferred",
			length = 60
			)
	private String emailPreferred;

	@Column(
			insertable = true,
			updatable = true,
			name = "employmentGrade",
			length = 5
			)
	private String employmentGrade;

	@Column(
			insertable = true,
			updatable = true,
			name = "faxPreferred",
			length = 16
			)
	private String faxPreferred;

	@Column(
			insertable = true,
			updatable = true,
			name = "fromRascalPacFlag",
			length = 1
			)
	private String fromRascalPacFlag;

	@Column(
			insertable = true,
			updatable = true,
			name = "highestDegree",
			length = 70
			)
	private String highestDegree;

	@Column(
			insertable = true,
			updatable = true,
			name = "homeInstitution",
			length = 60
			)
	private String homeInstitution;

	@Column(
			insertable = true,
			updatable = true,
			name = "homePage"
			)
	private String homePage;

	@Column(
			insertable = true,
			updatable = true,
			name = "jobCode",
			length = 6
			)
	private String jobCode;

	@Column(
			insertable = true,
			updatable = true,
			name = "lastLogonDate",
			length = 23
			)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogonDate;

	@Column(
			insertable = true,
			updatable = true,
			name = "name_first",
			length = 30
			)
	private String nameFirst;

	@Column(
			insertable = true,
			updatable = true,
			name = "name_last",
			length = 30,
			nullable = false
			)
	private String nameLast;

	@Column(
			insertable = true,
			updatable = true,
			name = "name_middle_1",
			length = 30
			)
	private String nameMiddle1;

	@Column(
			insertable = true,
			updatable = true,
			name = "name_middle_2",
			length = 30
			)
	private String nameMiddle2;

	@Column(
			insertable = true,
			updatable = true,
			name = "name_suffix",
			length = 3
			)
	private String nameSuffix;

	@Column(
			insertable = true,
			updatable = true,
			name = "phone_preferred",
			length = 15
			)
	private String phonePreferred;

	@Column(
			insertable = true,
			updatable = true,
			name = "position",
			length = 30
			)
	private String position;

	@Column(
			insertable = true,
			updatable = true,
			name = "postalCode",
			length = 14
			)
	private String postalCode;

	// Fields

	@Column(
			insertable = true,
			updatable = true,
			name = "rid",
			unique = true,
			nullable = false
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE, generator="RascalUser_SEQUENCE"
			)
	@Id private Integer id;

	/*
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
			mappedBy = "rascalUser"
			)
			*/
//	private Set<RuAuthorizedDepartment> ruAuthorizedDepartments =
//	new HashSet<RuAuthorizedDepartment>(0);

	/*
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "rascalUser"
			)
	private Set<RuIcmexpSurgeryTraining> ruIcmexpSurgeryTrainings =
	new HashSet<RuIcmexpSurgeryTraining>(0);
	*/
	/*
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "rascalUser"
			)
	private Set<RuOccHealthProgEnrollment> ruOccHealthProgEnrollments =
	new HashSet<RuOccHealthProgEnrollment>(0);

	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "rascalUser"
			)
	private Set<RuRadiationSafetyBadge> ruRadiationSafetyBadges =
	new HashSet<RuRadiationSafetyBadge>(0);
	*/

	/*
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "rascalUser"
			)
	private Set<RuSimpleTrainingEnrollment> ruSimpleTrainingEnrollments =
	new HashSet<RuSimpleTrainingEnrollment>(0);
	*/

	@Column(
			insertable = true,
			updatable = true,
			name = "state",
			length = 14
			)
	private String state;

	@Column(
			insertable = true,
			updatable = true,
			name = "statusFlag",
			length = 1
			)
	private String statusFlag;

	@Column(
			insertable = true,
			updatable = true,
			name = "statusFlagUpdateDate",
			length = 23
			)
	@Temporal(TemporalType.TIMESTAMP)
	private Date statusFlagUpdateDate;

	/*@Column(
			insertable = true,
			updatable = true,
			name = "sub_dept_home",
			length = 2
			)
	private String subDeptHome;*/

	/*
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "rascalUser"
			)
	private Set<TcuserEhs> tcuserEhses = new HashSet<TcuserEhs>(0);

	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY,
			mappedBy = "rascalUser"
			)
	private Set<TcuserRequiredCourse> tcuserRequiredCourses = new HashSet<TcuserRequiredCourse>(0);
	*/

	@Column(
			insertable = true,
			updatable = true,
			name = "title"
			)
	private String title;

	@Column(
			insertable = true,
			updatable = true,
			name = "usCitizenStatus",
			length = 30
			)
	private String usCitizenStatus;

	@Column(
			insertable = true,
			updatable = true,
			name = "user_id",
			unique = true,
			nullable = false,
			length = 15
			)
	private String userId;

	@Column(
			insertable = true,
			updatable = true,
			name = "yearAppointed",
			length = 4
			)
	private String yearAppointed;
	
	@Column(
			insertable = true,
			updatable = true,
			name = "requiredCoi",
			length = 1
			)
	private String requiredCoi;

	//~ Constructors -------------------------------------------------------------------------------

	/**
	 * minimal constructor.
	 *
	 * @param  userId  TODO: DOCUMENT ME!
	 */
	public RascalUser(String userId) {
		this.creationDate = Calendar.getInstance().getTime();
		this.deleteFlag = "N";
		this.userId = userId;
		this.nameLast = "Name Unknown";
	}

	/** Constructors * default constructor. */
	protected RascalUser() { }

	/**
	 * full constructor.
	 *
	 * @param  creationDate                 TODO: DOCUMENT ME!
	 * @param  deleteFlag                   TODO: DOCUMENT ME!
	 * @param  deptHome                     TODO: DOCUMENT ME!
	 * @param  emailPreferred               TODO: DOCUMENT ME!
	 * @param  nameFirst                    TODO: DOCUMENT ME!
	 * @param  nameLast                     TODO: DOCUMENT ME!
	 * @param  nameMiddle1                  TODO: DOCUMENT ME!
	 * @param  nameMiddle2                  TODO: DOCUMENT ME!
	 * @param  nameSuffix                   TODO: DOCUMENT ME!
	 * @param  phonePreferred               TODO: DOCUMENT ME!
	 * @param  userId                       TODO: DOCUMENT ME!
	 * @param  position                     TODO: DOCUMENT ME!
	 * @param  addressLine1                 TODO: DOCUMENT ME!
	 * @param  addressLine2                 TODO: DOCUMENT ME!
	 * @param  addressLine3                 TODO: DOCUMENT ME!
	 * @param  addressLine4                 TODO: DOCUMENT ME!
	 * @param  city                         TODO: DOCUMENT ME!
	 * @param  state                        TODO: DOCUMENT ME!
	 * @param  postalCode                   TODO: DOCUMENT ME!
	 * @param  country                      TODO: DOCUMENT ME!
	 * @param  faxPreferred                 TODO: DOCUMENT ME!
	 * @param  beeperPreferred              TODO: DOCUMENT ME!
	 * @param  affiliatedInstitution        TODO: DOCUMENT ME!
	 * @param  homePage                     TODO: DOCUMENT ME!
	 * @param  conflictInterest             TODO: DOCUMENT ME!
	 * @param  conflictInterestDate         TODO: DOCUMENT ME!
	 * @param  cancerCenter                 TODO: DOCUMENT ME!
	 * @param  title                        TODO: DOCUMENT ME!
	 * @param  yearAppointed                TODO: DOCUMENT ME!
	 * @param  homeInstitution              TODO: DOCUMENT ME!
	 * @param  usCitizenStatus              TODO: DOCUMENT ME!
	 * @param  dateOfHire                   TODO: DOCUMENT ME!
	 * @param  lastLogonDate                TODO: DOCUMENT ME!
	 * @param  employmentGrade              TODO: DOCUMENT ME!
	 * @param  statusFlag                   TODO: DOCUMENT ME!
	 * @param  statusFlagUpdateDate         TODO: DOCUMENT ME!
	 * @param  highestDegree                TODO: DOCUMENT ME!
	 * @param  jobCode                      TODO: DOCUMENT ME!
	 * @param  fromRascalPacFlag            TODO: DOCUMENT ME!
	 */
	protected RascalUser(Integer rid, Date creationDate, String deleteFlag, String deptHome,
			String emailPreferred, String nameFirst, String nameLast, String nameMiddle1,
			String nameMiddle2, String nameSuffix, String phonePreferred, /*String subDeptHome,*/
			String userId, String position, String addressLine1, String addressLine2,
			String addressLine3, String addressLine4, String city, String state, String postalCode,
			String country, String faxPreferred, String beeperPreferred, String affiliatedInstitution,
			String homePage, String conflictInterest, Date conflictInterestDate, String cancerCenter,
			String title, String yearAppointed, String homeInstitution, String usCitizenStatus,
		    Date dateOfHire, Date lastLogonDate, String employmentGrade, String statusFlag,
			Date statusFlagUpdateDate, String highestDegree, String jobCode,
                         String fromRascalPacFlag
			//Set<TcuserEhs> tcuserEhses, Set<RuOccHealthProgEnrollment> ruOccHealthProgEnrollments,
			//Set<TcuserRequiredCourse> tcuserRequiredCourses,
			//Set<RuIcmexpSurgeryTraining> ruIcmexpSurgeryTrainings,
			//Set<RuRadiationSafetyBadge> ruRadiationSafetyBadges,
			//Set<RuSimpleTrainingEnrollment> ruSimpleTrainingEnrollments,
			//Set<RuAuthorizedDepartment> ruAuthorizedDepartments
			) {
		this.id = rid;
		this.creationDate = creationDate;
		this.deleteFlag = deleteFlag;
		this.deptHome = deptHome;
		this.emailPreferred = emailPreferred;
		this.nameFirst = nameFirst;
		this.nameLast = nameLast;
		this.nameMiddle1 = nameMiddle1;
		this.nameMiddle2 = nameMiddle2;
		this.nameSuffix = nameSuffix;
		this.phonePreferred = phonePreferred;
		//this.subDeptHome = subDeptHome;
		this.userId = userId;
		this.position = position;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.addressLine4 = addressLine4;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.faxPreferred = faxPreferred;
		this.beeperPreferred = beeperPreferred;
		this.affiliatedInstitution = affiliatedInstitution;
		this.homePage = homePage;
		this.conflictInterest = conflictInterest;
		this.conflictInterestDate = conflictInterestDate;
		this.cancerCenter = cancerCenter;
		this.title = title;
		this.yearAppointed = yearAppointed;
		this.homeInstitution = homeInstitution;
		this.usCitizenStatus = usCitizenStatus;
		this.dateOfHire = dateOfHire;
		this.lastLogonDate = lastLogonDate;
		this.employmentGrade = employmentGrade;
		this.statusFlag = statusFlag;
		this.statusFlagUpdateDate = statusFlagUpdateDate;
		this.highestDegree = highestDegree;
		this.jobCode = jobCode;
		this.fromRascalPacFlag = fromRascalPacFlag;
		//this.tcuserEhses = tcuserEhses;
		//this.ruOccHealthProgEnrollments = ruOccHealthProgEnrollments;
		//this.tcuserRequiredCourses = tcuserRequiredCourses;
		//this.ruIcmexpSurgeryTrainings = ruIcmexpSurgeryTrainings;
		//this.ruRadiationSafetyBadges = ruRadiationSafetyBadges;
		//this.ruSimpleTrainingEnrollments = ruSimpleTrainingEnrollments;
		//this.ruAuthorizedDepartments = ruAuthorizedDepartments;
	}

	//~ Methods ------------------------------------------------------------------------------------

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param   lastName   TODO: DOCUMENT ME!
	 * @param   firstName  TODO: DOCUMENT ME!
	 * @param   uni        TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	public static String buildLastFirstNameUni(String lastName, String firstName, String uni) {
		String nameUni = "";
		String name = "";

		if (lastName.trim().equals("Name Unknown") || firstName.trim().equals("Name Unknown") ||
				lastName.trim().equals("") && firstName.trim().equals("")
				) {
			name = "Name Unknown";
		} else {

			if (!lastName.trim().equals("")) {
				name = lastName.trim();
			} else {
				name = "-";
			}

			if (!firstName.trim().equals("")) {
				name = name + ", " + firstName.trim();
			} else {
				name = name + ", " + "-";
			}
		}

		if (!uni.trim().equals("")) {
			nameUni = name + " (" + uni.trim() + ")";
		} else {
			nameUni = name + " (-)";
		}

		return nameUni;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getAddressLine1() {
		return this.addressLine1;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getAddressLine2() {
		return this.addressLine2;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getAddressLine3() {
		return this.addressLine3;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getAddressLine4() {
		return this.addressLine4;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getAffiliatedInstitution() {
		return this.affiliatedInstitution;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param   anApplication  TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Vector<RuAuthorizedDepartment> getAuthorizedDepartmentsFor(String anApplication) {

		Vector<RuAuthorizedDepartment> someVector = new Vector<RuAuthorizedDepartment>();

		for (RuAuthorizedDepartment authDept : ruAuthorizedDepartments) {
			if (authDept != null && authDept.getApplicationId().equalsIgnoreCase(
					anApplication
			)) {
				someVector.add(authDept);
			}
		}

		return someVector;

	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param   applicationId  TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Vector<RuAuthorizedDepartment> getAuthorizedDepartmentsFor(int rid, String applicationId) {
		return getAuthorizedDepartmentsFor(applicationId);
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param   applicationId  TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Vector<RuAuthorizedDepartment> getAuthorizedDepartmentsSortedByDeptCode(int rid,
			String applicationId
			) {
		return getAuthorizedDepartmentsFor(applicationId);
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param   applicationId  TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Vector<RuAuthorizedDepartment> getAuthorizedDepartmentsSortedByDeptName(int rid,
			String applicationId
			) {
		return getAuthorizedDepartmentsFor(applicationId);
	}
    */

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getBeeperPreferred() {
		return this.beeperPreferred;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getCancerCenter() {
		return this.cancerCenter;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getCity() {
		return this.city;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getConflictInterest() {
		return this.conflictInterest;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public Date getConflictInterestDate() {
		return this.conflictInterestDate;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getCountry() {
		return this.country;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public Date getCreationDate() {
		return this.creationDate;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public Date getDateOfHire() {
		return this.dateOfHire;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getDeptHome() {
		return this.deptHome;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getEmailPreferred() {
		return this.emailPreferred;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getEmploymentGrade() {
		return this.employmentGrade;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getFaxPreferred() {
		return this.faxPreferred;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getFromRascalPacFlag() {
		return this.fromRascalPacFlag;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getHighestDegree() {
		return this.highestDegree;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getHomeInstitution() {
		return this.homeInstitution;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getHomePage() {
		return this.homePage;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getJobCode() {
		return this.jobCode;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public Date getLastLogonDate() {
		return this.lastLogonDate;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getNameFirst() {
		return this.nameFirst;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getNameLast() {
		return this.nameLast;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getNameMiddle1() {
		return this.nameMiddle1;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getNameMiddle2() {
		return this.nameMiddle2;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getNameSuffix() {
		return this.nameSuffix;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getPhonePreferred() {
		return this.phonePreferred;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getPosition() {
		return this.position;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Set<RuAuthorizedDepartment> getRuAuthorizedDepartments() {
		return this.ruAuthorizedDepartments;
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Set<RuIcmexpSurgeryTraining> getRuIcmexpSurgeryTrainings() {
		return this.ruIcmexpSurgeryTrainings;
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Set<RuOccHealthProgEnrollment> getRuOccHealthProgEnrollments() {
		return this.ruOccHealthProgEnrollments;
	}
    */

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Set<RuRadiationSafetyBadge> getRuRadiationSafetyBadges() {
		return this.ruRadiationSafetyBadges;
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param   trainingType  TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Set<RuSimpleTrainingEnrollment> getRuSimpleTrainingDateByTrainingProgram(
			String trainingType
			) {
		Set<RuSimpleTrainingEnrollment> byTrainingType = new HashSet<RuSimpleTrainingEnrollment>();
		Set<RuSimpleTrainingEnrollment> allTraining = getRuSimpleTrainingEnrollments();

		for (RuSimpleTrainingEnrollment training : allTraining) {

			if (training.getTrainingProgram().equals(trainingType)) {
				byTrainingType.add(training);
			}
		}

		if (byTrainingType.isEmpty()) return Collections.EMPTY_SET;

		return byTrainingType;

	}
    */

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Set<RuSimpleTrainingEnrollment> getRuSimpleTrainingEnrollments() {
		return this.ruSimpleTrainingEnrollments;
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getState() {
		return this.state;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getStatusFlag() {
		return this.statusFlag;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public Date getStatusFlagUpdateDate() {
		return this.statusFlagUpdateDate;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	/*public String getSubDeptHome() {
		return this.subDeptHome;
	}*/

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Set<TcuserEhs> getTcuserEhses() {
		return this.tcuserEhses;
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
    /*
	public Set<TcuserRequiredCourse> getTcuserRequiredCourses() {
		return this.tcuserRequiredCourses;
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getTitle() {
		return this.title;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getUsCitizenStatus() {
		return this.usCitizenStatus;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	public String getUserFirstLastName() {
		String userName = "";
		String firstName = "";
		String lastName = "";

		if (this.getNameFirst() != null) {
			firstName = this.getNameFirst();
		}

		if (this.getNameLast() != null) {
			lastName = this.getNameLast();
		}

		userName = buildFirstLastName(lastName, firstName);

		return userName;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	public String getUserFirstLastNameUni() {
		String userName = "";
		String firstName = "";
		String lastName = "";

		if (this.getNameFirst() != null) {
			firstName = this.getNameFirst();
		}

		if (this.getNameLast() != null) {
			lastName = this.getNameLast();
		}

		userName = buildFirstLastNameUni(lastName, firstName, this.getUserId());

		return userName;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getUserId() {
		return this.userId;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	public String getUserLastFirstName() {
		String userName = "";
		String firstName = "";
		String lastName = "";

		if (this.getNameFirst() != null) {
			firstName = this.getNameFirst();
		}

		if (this.getNameLast() != null) {
			lastName = this.getNameLast();
		}

		userName = buildLastFirstName(lastName, firstName);

		return userName;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	public String getUserLastFirstNameUni() {
		String userName = "";
		String firstName = "";
		String lastName = "";

		if (this.getNameFirst() != null) {
			firstName = this.getNameFirst();
		}

		if (this.getNameLast() != null) {
			lastName = this.getNameLast();
		}

		userName = buildLastFirstNameUni(lastName, firstName, this.getUserId());

		return userName;
	}

	/**
	 * TODO: DOCUMENT ME!
	 * @return	TODO: DOCUMENT ME!
	 */
	public String getDepartmentHomeFull() {
		String departmentString = "";

		return departmentString;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	public Vector<Object> getValues() {

		Vector<Object> values = new Vector<Object>();

		values.addElement(userId);
		values.addElement(id);
		values.addElement(creationDate);
		values.addElement(nameFirst);
		values.addElement(nameLast);
		values.addElement(nameMiddle1);
		values.addElement(nameMiddle2);
		values.addElement(nameSuffix);
		values.addElement(emailPreferred);
		values.addElement(phonePreferred);
		values.addElement(deptHome);
		//values.addElement(subDeptHome);
		values.addElement(position);
		values.addElement(addressLine1);
		values.addElement(addressLine2);
		values.addElement(addressLine3);
		values.addElement(addressLine4);
		values.addElement(city);
		values.addElement(state);
		values.addElement(postalCode);
		values.addElement(country);
		values.addElement(faxPreferred);
		values.addElement(beeperPreferred);
		values.addElement(homePage);
		values.addElement(affiliatedInstitution);
		// values.addElement(getCancerCenter());
		// values.addElement(getConflictOfInterest());
		// values.addElement(getConflictOfInterestDate());

		return values;

	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */

	public String getYearAppointed() {
		return this.yearAppointed;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	public boolean hasCancerCenter() {

		return this.cancerCenter != null && this.cancerCenter.equals("Y");
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	public boolean hasPopulatedRequiredFields() {

		boolean master = false;

		boolean flagFirst = false;
		boolean flagLast = false;
		boolean flagEmail = false;
		boolean flagPhone = false;
		boolean flagDept = false;

		if (nameFirst != null) {

			if (nameFirst.trim().length() > 0) flagFirst = true;
		}

		if (nameLast != null) {

			if (nameLast.trim().length() > 0 || nameLast.toLowerCase().contains("unknown"))
				flagLast = true;
		}

		if (emailPreferred != null) {

			if (emailPreferred.trim().length() > 0) flagEmail = true;
		}

		if (phonePreferred != null) {

			if (phonePreferred.trim().length() > 0) flagPhone = true;
		}

		if (deptHome != null) {

			if (deptHome.trim().length() > 0) flagDept = true;
		}

		if (flagFirst && flagLast && flagEmail && flagPhone && flagDept) master = true;

		return master;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param   aString  TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	public String prepText(String aString) {
		int start = 0;
		int index = 0;
		String match = "'";
		StringBuilder newString = new StringBuilder("");

		while ((index = aString.indexOf(match, start)) >= 0) {
			newString.append(aString.substring(start, index));
			newString.append("''");
			start = index + 1;
		}

		if (start < aString.length()) {
			newString.append(aString.substring(start, aString.length()));
		}

		return newString.toString();
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  aChild  TODO: DOCUMENT ME!
	 */
    /*
	public void removeAuthorizedDepartment(RuAuthorizedDepartment aChild) {
		ruAuthorizedDepartments.remove(aChild);
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  ruBO  TODO: DOCUMENT ME!
	 */
    /*
	public void removeIcmSurgeryTrainingResponsible(RuIcmexpSurgeryTraining ruBO) {
		ruIcmexpSurgeryTrainings.remove(ruBO);
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  ruBO  TODO: DOCUMENT ME!
	 */
    /*
	public void removeIcmSurgeryTrainingTrainee(RuIcmexpSurgeryTraining ruBO) {
		ruIcmexpSurgeryTrainings.remove(ruBO);
	}
    */
    /*
	public void removeOccHealthProgEnrollment(RuOccHealthProgEnrollment ruBO) {
		ruOccHealthProgEnrollments.remove(ruBO);
	}

	public void removeRadiationSafetyBadge(RuRadiationSafetyBadge ruBO) {
		ruRadiationSafetyBadges.remove(ruBO);
	}

	public void removeSimpleTrainingEnrollment(RuSimpleTrainingEnrollment ruBO) {
		ruSimpleTrainingEnrollments.remove(ruBO);
	}
    */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  addressLine1  TODO: DOCUMENT ME!
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  addressLine2  TODO: DOCUMENT ME!
	 */
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  addressLine3  TODO: DOCUMENT ME!
	 */
	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  addressLine4  TODO: DOCUMENT ME!
	 */
	public void setAddressLine4(String addressLine4) {
		this.addressLine4 = addressLine4;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  affiliatedInstitution  TODO: DOCUMENT ME!
	 */
	public void setAffiliatedInstitution(String affiliatedInstitution) {
		this.affiliatedInstitution = affiliatedInstitution;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  beeperPreferred  TODO: DOCUMENT ME!
	 */
	public void setBeeperPreferred(String beeperPreferred) {
		this.beeperPreferred = beeperPreferred;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  cancerCenter  TODO: DOCUMENT ME!
	 */
	public void setCancerCenter(String cancerCenter) {
		this.cancerCenter = cancerCenter;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  city  TODO: DOCUMENT ME!
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  conflictInterest  TODO: DOCUMENT ME!
	 */
	public void setConflictInterest(String conflictInterest) {
		this.conflictInterest = conflictInterest;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  conflictInterestDate  TODO: DOCUMENT ME!
	 */
	public void setConflictInterestDate(Date conflictInterestDate) {
		this.conflictInterestDate = conflictInterestDate;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  country  TODO: DOCUMENT ME!
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  creationDate  TODO: DOCUMENT ME!
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  dateOfHire  TODO: DOCUMENT ME!
	 */
	public void setDateOfHire(Date dateOfHire) {
		this.dateOfHire = dateOfHire;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  deleteFlag  TODO: DOCUMENT ME!
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  deptHome  TODO: DOCUMENT ME!
	 */
	public void setDeptHome(String deptHome) {
		this.deptHome = deptHome;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  emailPreferred  TODO: DOCUMENT ME!
	 */
	public void setEmailPreferred(String emailPreferred) {
		this.emailPreferred = emailPreferred;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  employmentGrade  TODO: DOCUMENT ME!
	 */
	public void setEmploymentGrade(String employmentGrade) {
		this.employmentGrade = employmentGrade;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  faxPreferred  TODO: DOCUMENT ME!
	 */
	public void setFaxPreferred(String faxPreferred) {
		this.faxPreferred = faxPreferred;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  fromRascalPacFlag  TODO: DOCUMENT ME!
	 */
	public void setFromRascalPacFlag(String fromRascalPacFlag) {
		this.fromRascalPacFlag = fromRascalPacFlag;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  highestDegree  TODO: DOCUMENT ME!
	 */
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  homeInstitution  TODO: DOCUMENT ME!
	 */
	public void setHomeInstitution(String homeInstitution) {
		this.homeInstitution = homeInstitution;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  homePage  TODO: DOCUMENT ME!
	 */
	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  jobCode  TODO: DOCUMENT ME!
	 */
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  lastLogonDate  TODO: DOCUMENT ME!
	 */
	public void setLastLogonDate(Date lastLogonDate) {
		this.lastLogonDate = lastLogonDate;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  nameFirst  TODO: DOCUMENT ME!
	 */
	public void setNameFirst(String nameFirst) {
		this.nameFirst = nameFirst;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  nameLast  TODO: DOCUMENT ME!
	 */
	public void setNameLast(String nameLast) {
		this.nameLast = nameLast;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  nameMiddle1  TODO: DOCUMENT ME!
	 */
	public void setNameMiddle1(String nameMiddle1) {
		this.nameMiddle1 = nameMiddle1;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  nameMiddle2  TODO: DOCUMENT ME!
	 */
	public void setNameMiddle2(String nameMiddle2) {
		this.nameMiddle2 = nameMiddle2;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  nameSuffix  TODO: DOCUMENT ME!
	 */
	public void setNameSuffix(String nameSuffix) {
		this.nameSuffix = nameSuffix;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  phonePreferred  TODO: DOCUMENT ME!
	 */
	public void setPhonePreferred(String phonePreferred) {
		this.phonePreferred = phonePreferred;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  position  TODO: DOCUMENT ME!
	 */
	public void setPosition(String position) {
		this.position = position;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  postalCode  TODO: DOCUMENT ME!
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  ruAuthorizedDepartments  TODO: DOCUMENT ME!
	 */
/*
	public void setRuAuthorizedDepartments(Set<RuAuthorizedDepartment> ruAuthorizedDepartments) {
		this.ruAuthorizedDepartments = ruAuthorizedDepartments;
	}

	public void setRuIcmexpSurgeryTrainings(Set<RuIcmexpSurgeryTraining> ruIcmexpSurgeryTrainings) {
		this.ruIcmexpSurgeryTrainings = ruIcmexpSurgeryTrainings;
	}
*/
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  ruOccHealthProgEnrollments  TODO: DOCUMENT ME!
	 */
/*
	public void setRuOccHealthProgEnrollments(
			Set<RuOccHealthProgEnrollment> ruOccHealthProgEnrollments
			) {
		this.ruOccHealthProgEnrollments = ruOccHealthProgEnrollments;
	}

	public void setRuRadiationSafetyBadges(Set<RuRadiationSafetyBadge> ruRadiationSafetyBadges) {
		this.ruRadiationSafetyBadges = ruRadiationSafetyBadges;
	}

	public void setRuSimpleTrainingEnrollments(
			Set<RuSimpleTrainingEnrollment> ruSimpleTrainingEnrollments
			) {
		this.ruSimpleTrainingEnrollments = ruSimpleTrainingEnrollments;
	}
*/
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  state  TODO: DOCUMENT ME!
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  statusFlag  TODO: DOCUMENT ME!
	 */
	public void setStatusFlag(String statusFlag) {
		this.statusFlag = statusFlag;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  statusFlagUpdateDate  TODO: DOCUMENT ME!
	 */
	public void setStatusFlagUpdateDate(Date statusFlagUpdateDate) {
		this.statusFlagUpdateDate = statusFlagUpdateDate;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  subDeptHome  TODO: DOCUMENT ME!
	 */
	/*public void setSubDeptHome(String subDeptHome) {
		this.subDeptHome = subDeptHome;
	}*/

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  tcuserEhses  TODO: DOCUMENT ME!
	 */
/*
	public void setTcuserEhses(Set<TcuserEhs> tcuserEhses) {
		this.tcuserEhses = tcuserEhses;
	}


	public void setTcuserRequiredCourses(Set<TcuserRequiredCourse> tcuserRequiredCourses) {
		this.tcuserRequiredCourses = tcuserRequiredCourses;
	}
*/
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  title  TODO: DOCUMENT ME!
	 */
	/* TODO the direct request variable causes bad deployments, because
	 * there is no DB column by the same name. I think we can just any of these old directRequest
	 * references because it is VAP related? public boolean getDirectRequest() {    return
	 * directRequest; }
	 */

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  title  newValue TODO: DOCUMENT ME!
	 */
	/* TODO the direct request variable causes bad deployments, because
	 * there is no DB column by the same name. I think we can just any of these old directRequest
	 * references because it is VAP related? public void setDirectRequest(boolean newValue) {
	 * this.directRequest = newValue; }
	 */
	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  title  TODO: DOCUMENT ME!
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  usCitizenStatus  TODO: DOCUMENT ME!
	 */
	public void setUsCitizenStatus(String usCitizenStatus) {
		this.usCitizenStatus = usCitizenStatus;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  userId  TODO: DOCUMENT ME!
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param  yearAppointed  TODO: DOCUMENT ME!
	 */
	public void setYearAppointed(String yearAppointed) {
		this.yearAppointed = yearAppointed;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param   lastName   TODO: DOCUMENT ME!
	 * @param   firstName  TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	private String buildFirstLastName(String lastName, String firstName) {
		String name = "";

		if (lastName.trim().equals("Name Unknown") || firstName.trim().equals("Name Unknown") ||
				lastName.trim().equals("") && firstName.trim().equals("")
				) {
			name = "Name Unknown";
		} else {

			if (!firstName.trim().equals("")) {
				name = firstName.trim();
			} else {
				name = "-";
			}

			if (!lastName.trim().equals("")) {
				name = name + " " + lastName.trim();
			} else {
				name = name + " " + "-";
			}
		}

		return name;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param   lastName   TODO: DOCUMENT ME!
	 * @param   firstName  TODO: DOCUMENT ME!
	 * @param   uni        TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	private String buildFirstLastNameUni(String lastName, String firstName, String uni) {
		String nameUni = "";
		String name = "";

		if (lastName.trim().equals("Name Unknown") || firstName.trim().equals("Name Unknown") ||
				lastName.trim().equals("") && firstName.trim().equals("")
				) {
			name = "Name Unknown";
		} else {

			if (!firstName.trim().equals("")) {
				name = firstName.trim();
			} else {
				name = "-";
			}

			if (!lastName.trim().equals("")) {
				name = name + " " + lastName.trim();
			} else {
				name = name + " " + "-";
			}
		}

		if (!uni.trim().equals("")) {
			nameUni = name + " (" + uni.trim() + ")";
		} else {
			nameUni = name + " (-)";
		}

		return nameUni;
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param   lastName   TODO: DOCUMENT ME!
	 * @param   firstName  TODO: DOCUMENT ME!
	 *
	 * @return  TODO: DOCUMENT ME!
	 */
	private String buildLastFirstName(String lastName, String firstName) {
		String name = "";

		if (lastName.trim().equals("Name Unknown") || firstName.trim().equals("Name Unknown") ||
				lastName.trim().equals("") && firstName.trim().equals("")
				) {
			name = "Name Unknown";
		} else {

			if (!lastName.trim().equals("")) {
				name = lastName.trim();
			} else {
				name = "-";
			}

			if (!firstName.trim().equals("")) {
				name = name + ", " + firstName.trim();
			} else {
				name = name + ", " + "-";
			}
		}

		return name;
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	@Override
	protected void setId(Integer id) {
		this.id = id;

	}

	/**
	 * TODO: DOCUMENT ME!
	 * 
	 * @return the requiredCoi TODO: DOCUMENT ME!
	 */
	public String getRequiredCoi() {
		return requiredCoi == null ?"":requiredCoi;
	}

	/**
	 * TODO: DOCUMENT ME!
	 * 
	 * @param requiredCoi the requiredCoi to set TODO: DOCUMENT ME!
	 */
	public void setRequiredCoi(String requiredCoi) {
		this.requiredCoi = requiredCoi;
	}
}
