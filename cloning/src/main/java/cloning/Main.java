/**
 *
 */
package cloning;

import org.apache.commons.lang.SerializationUtils;

import cloning.pojos.Country;

/**
 * @author CHANDRAYAN
 *
 */
public class Main {

    public static void main(final String[] param) throws CloneNotSupportedException {

	final Country countryOriginal = PojoFactory.getMapOfCountry();
	final Country countryShallowCloned = (Country) countryOriginal.clone();
	final Country countryDeepCloned = (Country) SerializationUtils.clone(countryOriginal);
	System.out.println();
	System.out.println("countryOriginal -> " + countryOriginal);
	System.out.println("countryShallowCloned -> " + countryShallowCloned);
	System.out.println("countryDeepCloned -> " + countryDeepCloned);
	System.out.println();
	countryOriginal.setName("China");
	countryOriginal.getState().setName("New Delhi");
	System.out.println("changing name to country name to " + countryOriginal.getName() + " and state name to "
		+ countryOriginal.getState().getName());
	System.out.println();
	System.out.println("Shallow copy results:");
	System.out.println("countryOriginal -> " + countryOriginal);
	System.out.println("countryShallowCloned -> " + countryShallowCloned);
	System.out.println();
	System.out.println("Deep copy results:");
	System.out.println("countryOriginal -> " + countryOriginal);
	System.out.println("countryDeepCloned -> " + countryDeepCloned);
    }
}
