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
public class Country implements Serializable, Cloneable {
    /**
     *
     */
    private static final long serialVersionUID = 5487408961491103545L;
    private String name;
    private State state;

    /**
     * @param name
     * @param state
     */
    public Country(final String name, final State state) {
	super();
	this.name = name;
	this.state = state;
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
     * @return the state
     */
    public final State getState() {
	return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public final void setState(final State state) {
	this.state = state;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
	final Country country = (Country) super.clone();
	country.setName(country.getName().toUpperCase());
	return country;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Country [name=" + name + ", state=" + state + "]";
    }

    private void writeObject(final java.io.ObjectOutputStream stream) throws IOException {
	stream.writeObject(name.toUpperCase());
	stream.writeObject(state);
    }

    private void readObject(final java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
	name = (String) stream.readObject();
	state = (State) stream.readObject();
    }
}
