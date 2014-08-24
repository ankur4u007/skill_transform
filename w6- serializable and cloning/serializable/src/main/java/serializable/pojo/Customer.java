/**
 *
 */
package serializable.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @author CHANDRAYAN
 *
 */
public class Customer implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5898825885379847052L;
    /**
     *
     */
    private String name;
    private List<Address> adrressList;
    private Integer id;
    private transient String details;

    /**
     * @return the name
     */
    public final String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public final void setName(final String name) {
	this.name = name;
    }

    /**
     * @return the adrressList
     */
    public final List<Address> getAdrressList() {
	return adrressList;
    }

    /**
     * @param adrressList
     *            the adrressList to set
     */
    public final void setAdrressList(final List<Address> adrressList) {
	this.adrressList = adrressList;
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
     * @return the details
     */
    public final String getDetails() {
	return details;
    }

    /**
     * @param details
     *            the details to set
     */
    public final void setDetails(final String details) {
	this.details = details;
    }

    /**
     * @param name
     * @param adrressList
     * @param id
     * @param details
     */
    public Customer(final String name, final List<Address> adrressList, final Integer id, final String details) {
	super();
	this.name = name;
	this.adrressList = adrressList;
	this.id = id;
	this.details = details;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Customer [name=" + name + ", adrressList=" + adrressList + ", id=" + id + ", details=" + details + "]";
    }

}
