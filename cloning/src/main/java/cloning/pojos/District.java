/**
 *
 */
package cloning.pojos;

import java.io.IOException;
import java.io.Serializable;

/**
 * @author CHANDRAYAN
 *
 */
public class District implements Serializable, Cloneable {
    /**
     *
     */
    private static final long serialVersionUID = -833801815199115084L;
    private String name;
    private Tahasil tehsil;

    /**
     * @param name
     * @param tehsil
     */
    public District(final String name, final Tahasil tehsil) {
	super();
	this.name = name;
	this.tehsil = tehsil;
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
     * @return the tehsil
     */
    public final Tahasil getTehsil() {
	return tehsil;
    }

    /**
     * @param tehsil
     *            the tehsil to set
     */
    public final void setTehsil(final Tahasil tehsil) {
	this.tehsil = tehsil;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
	final District district = (District) super.clone();
	district.setName(district.getName().toUpperCase());
	return district;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "District [name=" + name + ", tehsil=" + tehsil + "]";
    }

    private void writeObject(final java.io.ObjectOutputStream stream) throws IOException {
	stream.writeObject(name.toUpperCase());
	stream.writeObject(tehsil);
    }

    private void readObject(final java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
	name = (String) stream.readObject();
	tehsil = (Tahasil) stream.readObject();
    }
}
