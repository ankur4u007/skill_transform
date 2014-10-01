package webservices.services.dealservice;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import webservices.beans.getdeals.Deal;
import webservices.beans.getdeals.GetDealsRequest;
import webservices.beans.getdeals.GetDealsResponse;
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
    public @ResponsePayload GetDealsResponse getAccountDetails(@RequestPayload final GetDealsRequest request) {
	return processGetRequest(request);
    }

    @Override
    protected List<Deal> getResults(final GetDealsRequest request) throws DatatypeConfigurationException {
	final List<DealBO> dealBOList = dealService.getDealsByParameters(request.getFacilityId(),
		request.getDrawDownId(), request.getMaturityDate().toGregorianCalendar().getTime());
	return ResponseBuilder.builldResponseFromBOList(dealBOList);

    }

}