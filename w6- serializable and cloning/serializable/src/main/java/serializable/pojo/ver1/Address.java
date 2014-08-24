/**
 *
 */
package serializable.pojo.ver1;

import java.io.Serializable;

/**
 * @author CHANDRAYAN
 *
 */
public class Address implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6875096154861989530L;
    private String houseNo;
    private String location;

    /**
     * @param houseNo
     * @param location
     */
    public Address(final String houseNo, final String location) {
	super();
	this.houseNo = houseNo;
	this.location = location;
    }

    /**
     * @return the houseNo
     */
    public final String getHouseNo() {
	return houseNo;
    }

    /**
     * @param houseNo
     *            the houseNo to set
     */
    public final void setHouseNo(final String houseNo) {
	this.houseNo = houseNo;
    }

    /**
     * @return the location
     */
    public final String getLocation() {
	return location;
    }

    /**
     * @param location
     *            the location to set
     */
    public final void setLocation(final String location) {
	this.location = location;
    }

}
