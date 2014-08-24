/**
 *
 */
package serializable.pojo.ver2;

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
    private Long pinNumber;

    /**
     * @param houseNo
     * @param location
     * @param pinNumber
     */
    public Address(final String houseNo, final String location, final Long pinNumber) {
	super();
	this.houseNo = houseNo;
	this.location = location;
	this.pinNumber = pinNumber;
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

    /**
     * @return the pinNumber
     */
    public final Long getPinNumber() {
	return pinNumber;
    }

    /**
     * @param pinNumber
     *            the pinNumber to set
     */
    public final void setPinNumber(final Long pinNumber) {
	this.pinNumber = pinNumber;
    }

}
