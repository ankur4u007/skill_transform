/**
 *
 */
package serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import serializable.pojo.Address;
import serializable.pojo.Customer;

/**
 * @author CHANDRAYAN
 *
 */
public class Main {

    /**
     * @param args
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     */
    public static void main(final String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
	// TODO Auto-generated method stub
	final File serializedFileBeforeChange1 = new File("src/main/resources/Customer1.ser");
	serializedFileBeforeChange1.setReadOnly();
	final File serializedFileBeforeChange2 = new File("src/main/resources/Customer2.ser");
	serializedFileBeforeChange2.setReadOnly();
	final File serializedFileAfterChange1 = new File("src/main/resources/Customer1_after_change.ser");
	final File serializedFileAfterChange2 = new File("src/main/resources/Customer2_after_change.ser");
	final Address addr11 = new Address("houseNo11", "location11");
	final Address addr12 = new Address("houseNo12", "location12");
	final Address addr21 = new Address("houseNo21", "location21");
	final Customer c1 = new Customer("Customer1", Arrays.asList(addr11, addr12), 1, "Customer1 Details");
	final Customer c2 = new Customer("Customer2", Arrays.asList(addr21), 2, "Customer2 Details");

	System.out.println("Serializing " + c1.getName() + " : " + c1);
	final ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(serializedFileAfterChange1));
	oos1.writeObject(c1);
	oos1.close();
	System.out.println("Serializing " + c2.getName() + " : " + c2);
	final ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(serializedFileAfterChange2));
	oos2.writeObject(c2);
	oos2.close();
	System.out.println("Now De-Serializing after Change");
	final ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream(serializedFileAfterChange1));
	final Customer cread1 = (Customer) ois1.readObject();
	ois1.close();
	System.out.println("De-Serializing " + cread1.getName() + " : " + cread1);
	final ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(serializedFileAfterChange2));
	final Customer cread2 = (Customer) ois2.readObject();
	ois2.close();
	System.out.println("De-Serializing " + cread2.getName() + " : " + cread2);

	System.out.println("Now De-Serializing Before Change");
	final ObjectInputStream ois1before = new ObjectInputStream(new FileInputStream(serializedFileBeforeChange1));
	final Customer cread1Before = (Customer) ois1before.readObject();
	ois1before.close();
	System.out.println("De-Serializing " + cread1Before.getName() + " : " + cread1Before);
	final ObjectInputStream ois2before = new ObjectInputStream(new FileInputStream(serializedFileBeforeChange2));
	final Customer cread2Before = (Customer) ois2before.readObject();
	ois2before.close();
	System.out.println("De-Serializing " + cread2Before.getName() + " : " + cread2Before);

    }
}
