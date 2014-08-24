/**
 *
 */
package javaConcur.broker;

import javaConcur.domainObj.StockUnits;

/**
 * @author CHANDRAYAN
 *
 */
public interface IBroker {

    StockUnits getStocksOfComapny(String comapny);

    Integer getQuantity();

}
