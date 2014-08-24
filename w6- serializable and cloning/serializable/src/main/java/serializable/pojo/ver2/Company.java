package serializable.pojo.ver2;

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
    private static final long serialVersionUID = -7077269797519113293L;
    private String name;
    private List<Address> adrressList;
    private transient Date dob;
    private Long contactNo;

    /**
     * @param name
     * @param adrressList
     * @param dob
     * @param contactNo
     */
    public Company(final String name, final List<Address> adrressList, final Date dob, final Long contactNo) {
	super();
	this.name = name;
	this.adrressList = adrressList;
	this.dob = dob;
	this.contactNo = contactNo;
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

    /**
     * @return the contactNo
     */
    public final Long getContactNo() {
	return contactNo;
    }

    /**
     * @param contactNo
     *            the contactNo to set
     */
    public final void setContactNo(final Long contactNo) {
	this.contactNo = contactNo;
    }

}
