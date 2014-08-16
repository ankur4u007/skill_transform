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
public class State implements Serializable, Cloneable {
    /**
     *
     */
    private static final long serialVersionUID = -6797305440816969568L;
    private String name;
    private District dsitrict;

    /**
     * @param name
     * @param dsitrict
     */
    public State(final String name, final District dsitrict) {
	super();
	this.name = name;
	this.dsitrict = dsitrict;
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
     * @return the dsitrict
     */
    public final District getDsitrict() {
	return dsitrict;
    }

    /**
     * @param dsitrict
     *            the dsitrict to set
     */
    public final void setDsitrict(final District dsitrict) {
	this.dsitrict = dsitrict;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#clone()
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
	final State state = (State) super.clone();
	state.setName(state.getName().toUpperCase());
	return state;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "State [name=" + name + ", dsitrict=" + dsitrict + "]";
    }

    private void writeObject(final java.io.ObjectOutputStream stream) throws IOException {
	stream.writeObject(name.toUpperCase());
	stream.writeObject(dsitrict);
    }

    private void readObject(final java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
	name = (String) stream.readObject();
	dsitrict = (District) stream.readObject();
    }
}
