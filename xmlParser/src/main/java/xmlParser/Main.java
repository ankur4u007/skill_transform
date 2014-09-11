/**
 *
 */
package xmlParser;

import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xmlParser.bo.DealBO;
import xmlParser.bo.DrawDownBO;
import xmlParser.bo.FacilityBO;
import xmlParser.service.deal.IDealService;

/**
 * @author CHANDRAYAN
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(final String[] args) {
	final ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
	final IDealService dealService = context.getBean(IDealService.class);
	final List<DealBO> dealBOListToCreate = BOFactory.createDealBOList(2);
	// creating deals
	dealService.createDeals(dealBOListToCreate);

	final List<DealBO> dealBOList = dealService.getAllDeals();
	for (final DealBO deals : dealBOList) {
	    System.out.println(deals);
	}

	// find by facility and drawdown ids
	if (dealBOList != null) {
	    final DealBO dealBo = dealBOList.get(new Random().nextInt((dealBOList.size() - 1)));
	    final List<FacilityBO> facilityBoList = dealBo.getFacilityBOList();
	    if (facilityBoList != null) {
		final FacilityBO facilityBO = facilityBoList.get(new Random().nextInt(facilityBoList.size() - 1));
		final int facilityId = facilityBO.getId();
		final DealBO dealBORetrievedFromFacilityId = dealService.getDealByFacilityId(facilityId);
		final List<DrawDownBO> drawDownList = facilityBO.getDrawDownBOList();
		if (drawDownList != null) {
		    final DrawDownBO drawDownBO = drawDownList.get(new Random().nextInt(drawDownList.size() - 1));
		    final int drawDownId = drawDownBO.getId();
		    final DealBO dealBORetrievedFromDrawDownId = dealService.getDealByDrawdownId(drawDownId);
		    if (dealBORetrievedFromDrawDownId.getId().equals(dealBo.getId())) {
			System.out.println("Deal Found by DrawDownId :" + drawDownId + " , "
				+ dealBORetrievedFromDrawDownId);
		    }
		}
		if (dealBORetrievedFromFacilityId.getId().equals(dealBo.getId())) {
		    System.out.println("Deal Found by facilityId :" + facilityId + " , "
			    + dealBORetrievedFromFacilityId);
		}
	    }
	}
    }
}
