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
public class Tahasil implements Serializable, Cloneable {
    /**
     *
     */
    private static final long serialVersionUID = -7908088015875177940L;
    private String name;

    /**
     * @param name
     */
    public Tahasil(final String name) {
	super();
	this.name = name;
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
	final Tahasil tahasil = (Tahasil) super.clone();
	tahasil.setName(tahasil.getName().toUpperCase());
	return tahasil;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Tahasil [name=" + name + "]";
    }

    private void writeObject(final java.io.ObjectOutputStream stream) throws IOException {
	stream.writeObject(name.toUpperCase());
    }

    private void readObject(final java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
	name = (String) stream.readObject();
    }
}
