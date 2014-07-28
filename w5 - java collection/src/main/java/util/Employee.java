/**
 *
 */
package util;

/**
 * @author CHANDRAYAN
 *
 */
public class Employee implements Comparable<Employee> {

    private String firstName;
    private String lastName;
    private Long id;
    private String skill;
    private String location;

    /**
     * @return the firstName
     */
    public final String getFirstName() {
	return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public final void setFirstName(final String firstName) {
	this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public final String getLastName() {
	return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public final void setLastName(final String lastName) {
	this.lastName = lastName;
    }

    /**
     * @return the id
     */
    public final Long getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public final void setId(final Long id) {
	this.id = id;
    }

    /**
     * @return the skill
     */
    public final String getSkill() {
	return skill;
    }

    /**
     * @param skill
     *            the skill to set
     */
    public final void setSkill(final String skill) {
	this.skill = skill;
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

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
	result = prime * result + ((location == null) ? 0 : location.hashCode());
	result = prime * result + ((skill == null) ? 0 : skill.hashCode());
	return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final Employee other = (Employee) obj;
	if (firstName == null) {
	    if (other.firstName != null) {
		return false;
	    }
	} else if (!firstName.equals(other.firstName)) {
	    return false;
	}
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	if (lastName == null) {
	    if (other.lastName != null) {
		return false;
	    }
	} else if (!lastName.equals(other.lastName)) {
	    return false;
	}
	if (location == null) {
	    if (other.location != null) {
		return false;
	    }
	} else if (!location.equals(other.location)) {
	    return false;
	}
	if (skill == null) {
	    if (other.skill != null) {
		return false;
	    }
	} else if (!skill.equals(other.skill)) {
	    return false;
	}
	return true;
    }

    /**
     * @param firstName
     * @param lastName
     * @param id
     * @param skill
     * @param location
     */
    public Employee(final String firstName, final String lastName, final Long id, final String skill,
	    final String location) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.id = id;
	this.skill = skill;
	this.location = location;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", id=" + id + ", skill=" + skill
		+ ", location=" + location + "]";
    }

    public int compareTo(final Employee o) {
	final int res = firstName.compareToIgnoreCase(o.getFirstName());
	if (res == 0) {
	    return id < o.getId() ? -1 : 1;
	} else {
	    return res;
	}
    }

    public String toCSV() {
	return firstName + "," + lastName + "," + id + "," + skill + "," + location + "\r";
    }
}
