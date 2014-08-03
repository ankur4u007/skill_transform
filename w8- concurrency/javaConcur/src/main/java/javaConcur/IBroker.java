/**
 *
 */
package javaConcur;

/**
 * @author CHANDRAYAN
 *
 */
public interface IBroker {

    StockUnits getStocksOfComapny(String comapny);

    Integer getQuantity();

}
