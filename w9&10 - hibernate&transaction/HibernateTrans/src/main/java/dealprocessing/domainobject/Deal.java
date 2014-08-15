package dealprocessing.domainobject;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author CHANDRAYAN
 *
 */
@Entity
@Table(name = "DEAL")
public class Deal implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5029865173248067717L;
    @Id
    @Column(name = "DEAL_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "DEAL_DESC")
    private String descrption;
    @Column(name = "DEAL_START_DATE")
    private Date startDate;
    @Column(name = "DEAL_MATURITY_DATE")
    private Date maturityDate;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST, mappedBy = "deal")
    private List<Facility> facilityList;

    /**
     *
     */
    public Deal() {
	super();
    }

    /**
     * @param id
     * @param descrption
     * @param startDate
     * @param maturityDate
     * @param facilityList
     */
    public Deal(final Integer id, final String descrption, final Date startDate, final Date maturityDate,
	    final List<Facility> facilityList) {
	super();
	this.id = id;
	this.descrption = descrption;
	this.startDate = startDate;
	this.maturityDate = maturityDate;
	this.facilityList = facilityList;
    }

    /**
     * @return the id
     */
    public final Integer getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public final void setId(final Integer id) {
	this.id = id;
    }

    /**
     * @return the descrption
     */
    public final String getDescrption() {
	return descrption;
    }

    /**
     * @param descrption
     *            the descrption to set
     */
    public final void setDescrption(final String descrption) {
	this.descrption = descrption;
    }

    /**
     * @return the startDate
     */
    public final Date getStartDate() {
	return startDate;
    }

    /**
     * @param startDate
     *            the startDate to set
     */
    public final void setStartDate(final Date startDate) {
	this.startDate = startDate;
    }

    /**
     * @return the maturityDate
     */
    public final Date getMaturityDate() {
	return maturityDate;
    }

    /**
     * @param maturityDate
     *            the maturityDate to set
     */
    public final void setMaturityDate(final Date maturityDate) {
	this.maturityDate = maturityDate;
    }

    /**
     * @return the facilityList
     */
    public final List<Facility> getFacilityList() {
	return facilityList;
    }

    /**
     * @param facilityList
     *            the facilityList to set
     */
    public final void setFacilityList(final List<Facility> facilityList) {
	this.facilityList = facilityList;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Deal [id=" + id + ", descrption=" + descrption + ", startDate=" + startDate + ", maturityDate="
		+ maturityDate + ", facilityList=" + facilityList + "]";
    }

}
