/**
 *
 */
package xmlParser.service.deal;

import java.util.Date;
import java.util.List;

import xmlParser.bo.DealBO;
import xmlParser.jaxbobjects.Deal;

/**
 * @author CHANDRAYAN
 *
 */
public interface IDealService {

    void createDeals(List<Deal> dealToCreate);

    void createDealsByBO(final DealBO dealBO);

    void createDealsByBOList(List<DealBO> dealListToCreate);

    DealBO getDealByFacilityId(int facilityId);

    DealBO getDealByDrawdownId(int drawdownId);

    List<DealBO> getAllDeals();

    List<DealBO> getDealsByMaturityDate(Date maturityDate);

    List<DealBO> getDealsByParameters(final Integer facilityId, final Integer drawDownId, final Date maturityDate);
}
