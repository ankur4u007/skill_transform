/**
 *
 */
package dealprocessing.service.deal;

import java.util.List;

import dealprocessing.bo.DealBO;

/**
 * @author CHANDRAYAN
 *
 */
public interface IDealService {

    void createDeals(List<DealBO> dealToCreate);

    DealBO getDealByFacilityId(int facilityId);

    DealBO getDealByDrawdownId(int drawdownId);

    List<DealBO> getAllDeals();

}
