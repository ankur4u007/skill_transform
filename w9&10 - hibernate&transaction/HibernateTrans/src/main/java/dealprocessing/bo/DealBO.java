/**
 *
 */
package dealprocessing.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author CHANDRAYAN
 *
 */
public class DealBO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4090028432844888328L;

    private Integer id;
    private String descrption;
    private Date startDate;
    private Date maturityDate;
    private List<FacilityBO> facilityBOList;

    /**
     * @param id
     * @param descrption
     * @param startDate
     * @param maturityDate
     * @param facilityBOList
     */
    public DealBO(final Integer id, final String descrption, final Date startDate, final Date maturityDate,
	    final List<FacilityBO> facilityBOList) {
	super();
	this.id = id;
	this.descrption = descrption;
	this.startDate = startDate;
	this.maturityDate = maturityDate;
	this.facilityBOList = facilityBOList;
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
     * @return the facilityBOList
     */
    public final List<FacilityBO> getFacilityBOList() {
	return facilityBOList;
    }

    /**
     * @param facilityBOList
     *            the facilityBOList to set
     */
    public final void setFacilityBOList(final List<FacilityBO> facilityBOList) {
	this.facilityBOList = facilityBOList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "DealBO [id=" + id + ", descrption=" + descrption + ", startDate=" + startDate + ", maturityDate="
		+ maturityDate + ", facilityBOList=" + facilityBOList + "]";
    }

}
