/**
 *
 */
package dealprocessing.bo;

import java.io.Serializable;

/**
 * @author CHANDRAYAN
 *
 */
public class DrawDownBO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 640454712024411259L;

    private Integer id;
    private String description;
    private Double amount;

    /**
     * @param id
     * @param description
     * @param amount
     */
    public DrawDownBO(final Integer id, final String description, final Double amount) {
	super();
	this.id = id;
	this.description = description;
	this.amount = amount;
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
	return "DrawDownBO [id=" + id + ", description=" + description + ", amount=" + amount + "]";
    }

}
