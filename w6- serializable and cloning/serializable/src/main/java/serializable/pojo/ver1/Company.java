/**
 *
 */
package serializable.pojo.ver1;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author CHANDRAYAN
 *
 */
public class Company implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5898825885379847052L;
    private String name;
    private List<Address> adrressList;
    private transient Date dob;

    /**
     * @param name
     * @param adrressList
     * @param dob
     */
    public Company(final String name, final List<Address> adrressList, final Date dob) {
	super();
	this.name = name;
	this.adrressList = adrressList;
	this.dob = dob;
    }

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
     * @return the dob
     */
    public final Date getDob() {
	return dob;
    }

    /**
     * @param dob
     *            the dob to set
     */
    public final void setDob(final Date dob) {
	this.dob = dob;
    }

}
