package webservices.services.dealservice;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import webservices.beans.createdeals.CreateDealsRequest;
import webservices.beans.createdeals.CreateDealsResponse;
import webservices.beans.getdeals.Deal;
import webservices.beans.getdeals.GetDealsRequest;
import webservices.beans.getdeals.GetDealsResponse;
import webservices.bobuilder.DealBoBuilder;
import webservices.responsebuilder.ResponseBuilder;
import xmlParser.bo.DealBO;
import xmlParser.service.deal.IDealService;

/**
 * The Class DealService.
 */
@Endpoint
public class DealServiceEndPoint extends AbstractServiceEndPoint {
    private static final String TARGET_NAMESPACE_GET = "http://webservices/beans/getDeals";
    private static final String TARGET_NAMESPACE_CREATE = "http://webservices/beans/createDeals";

    @Resource(name = "dealservice")
    private IDealService dealService;

    /**
     *
     * @param request
     * @return
     */
    @PayloadRoot(localPart = "GetDealsRequest", namespace = TARGET_NAMESPACE_GET)
    public @ResponsePayload GetDealsResponse getDealDetails(@RequestPayload final GetDealsRequest request) {
	return processGetRequest(request);
    }

    @Override
    protected List<Deal> getResults(final GetDealsRequest request) throws DatatypeConfigurationException {
	final Date date = request.getMaturityDate() == null ? null : request.getMaturityDate().toGregorianCalendar()
		.getTime();
	final List<DealBO> dealBOList = dealService.getDealsByParameters(request.getFacilityId(),
		request.getDrawDownId(), date);
	return ResponseBuilder.builldResponseFromBOList(dealBOList);

    }

    /**
     *
     * @param request
     * @return
     */
    @PayloadRoot(localPart = "CreateDealsRequest", namespace = TARGET_NAMESPACE_CREATE)
    public @ResponsePayload CreateDealsResponse createDealDetails(@RequestPayload final CreateDealsRequest request) {
	return processCreateRequest(request);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = false)
    protected void createDeals(final webservices.beans.createdeals.Deal deal) {
	dealService.createDealsByBO(DealBoBuilder.buildDealBOFromDomainObject(deal));
    }

}