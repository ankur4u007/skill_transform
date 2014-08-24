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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author CHANDRAYAN
 *
 */
@Entity
@Table(name = "FACILITY")
public class Facility implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6771181907266200342L;
    @Id
    @Column(name = "FACILITY_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "FACILITY_AMOUNT")
    private Double amount;
    @Column(name = "FACILITY_START_DATE")
    private Date startDate;
    @Column(name = "FACILITY_MATURITY_DATE")
    private Date maturityDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEAL_ID", nullable = false)
    private Deal deal;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "facility", cascade = CascadeType.PERSIST)
    private List<DrawDown> drawDownList;

    /**
     *
     */
    public Facility() {
	super();
    }

    /**
     * @param id
     * @param amount
     * @param startDate
     * @param maturityDate
     * @param deal
     * @param drawDownList
     */
    public Facility(final Integer id, final Double amount, final Date startDate, final Date maturityDate,
	    final Deal deal, final List<DrawDown> drawDownList) {
	super();
	this.id = id;
	this.amount = amount;
	this.startDate = startDate;
	this.maturityDate = maturityDate;
	this.deal = deal;
	this.drawDownList = drawDownList;
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
     * @param maturityDate
     *            the maturityDate to set
     */
    public final void setMaturityDate(final Date maturityDate) {
	this.maturityDate = maturityDate;
    }

    /**
     * @return the deal
     */
    public final Deal getDeal() {
	return deal;
    }

    /**
     * @param deal
     *            the deal to set
     */
    public final void setDeal(final Deal deal) {
	this.deal = deal;
    }

    /**
     * @return the drawDownList
     */
    public final List<DrawDown> getDrawDownList() {
	return drawDownList;
    }

    /**
     * @param drawDownList
     *            the drawDownList to set
     */
    public final void setDrawDownList(final List<DrawDown> drawDownList) {
	this.drawDownList = drawDownList;
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
	return "Facility [id=" + id + ", amount=" + amount + ", startDate=" + startDate + ", maturityDate="
		+ maturityDate + ", deal=" + deal + ", drawDownList=" + drawDownList + "]";
    }

}
