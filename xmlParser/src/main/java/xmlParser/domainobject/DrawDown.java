/**
 *
 */
package xmlParser.domainobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author CHANDRAYAN
 *
 */
@Entity
@Table(name = "DRAWDOWN")
public class DrawDown implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2750326851123615224L;
    @Id
    @Column(name = "DRAWDOWN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "DRAWDOWN_DESC")
    private String description;
    @Column(name = "DRAWDOWN_AMOUNT")
    private Double amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACILITY_ID", nullable = false)
    private Facility facility;

    /**
     *
     */
    public DrawDown() {
	super();
    }

    /**
     * @param id
     * @param description
     * @param amount
     * @param facility
     */
    public DrawDown(final Integer id, final String description, final Double amount, final Facility facility) {
	super();
	this.id = id;
	this.description = description;
	this.amount = amount;
	this.facility = facility;
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
     * @return the description
     */
    public final String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public final void setDescription(final String description) {
	this.description = description;
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
     * @return the facility
     */
    public final Facility getFacility() {
	return facility;
    }

    /**
     * @param facility
     *            the facility to set
     */
    public final void setFacility(final Facility facility) {
	this.facility = facility;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "DrawDown [id=" + id + ", description=" + description + ", amount=" + amount + ", facility=" + facility
		+ "]";
    }

}
