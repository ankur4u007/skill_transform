/**
 *
 */
package cloning;

import cloning.pojos.Country;
import cloning.pojos.District;
import cloning.pojos.State;
import cloning.pojos.Tahasil;

/**
 * @author CHANDRAYAN
 *
 */
public class PojoFactory {

    private PojoFactory() {

    }

    public static Country getMapOfCountry() {
	return new Country("India", new State("Delhi", new District("punjabi bagh", new Tahasil("shivaji park"))));
    }
}
