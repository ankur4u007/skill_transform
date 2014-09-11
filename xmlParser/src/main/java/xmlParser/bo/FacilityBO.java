/**
 *
 */
package xmlParser.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author CHANDRAYAN
 *
 */
public class FacilityBO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7114249515226066327L;

    private Integer id;
    private Double amount;
    private Date startDate;
    private final Date maturityDate;
    private List<DrawDownBO> drawDownBOList;

    /**
     * @param id
     * @param amount
     * @param startDate
     * @param dateMaturityDate
     * @param drawDownBOList
     */
    public FacilityBO(final Integer id, final Double amount, final Date startDate, final Date maturityDate,
	    final List<DrawDownBO> drawDownBOList) {
	super();
	this.id = id;
	this.amount = amount;
	this.startDate = startDate;
	this.maturityDate = maturityDate;
	this.drawDownBOList = drawDownBOList;
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
     * @return the amount
     */
    public final Double getAmount() {
	return amount;
    }

    /**
     * @param amount
     *            the amount to set
     */
    public final void setAmount(final Double amount) {
	this.amount = amount;
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
     * @return the drawDownBOList
     */
    public final List<DrawDownBO> getDrawDownBOList() {
	return drawDownBOList;
    }

    /**
     * @param drawDownBOList
     *            the drawDownBOList to set
     */
    public final void setDrawDownBOList(final List<DrawDownBO> drawDownBOList) {
	this.drawDownBOList = drawDownBOList;
    }

    /**
     * @return the serialversionuid
     */
    public static final long getSerialversionuid() {
	return serialVersionUID;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "FacilityBO [id=" + id + ", amount=" + amount + ", startDate=" + startDate + ", maturityDate="
		+ maturityDate + ", drawDownBOList=" + drawDownBOList + "]";
    }

}
