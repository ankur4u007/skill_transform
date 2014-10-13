package webservices.services.dealservice;

import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.apache.log4j.Logger;

import webservices.beans.createdeals.CreateDealsRequest;
import webservices.beans.createdeals.CreateDealsResponse;
import webservices.beans.createdeals.ResponseList;
import webservices.beans.getdeals.Deal;
import webservices.beans.getdeals.GetDealsRequest;
import webservices.beans.getdeals.GetDealsResponse;

import com.google.common.base.Preconditions;

public abstract class AbstractServiceEndPoint {

    public static final String ERROR = "ERROR";
    public static final String SUCCESS = "SUCCESS";
    private static final Logger logger = Logger.getLogger(AbstractServiceEndPoint.class);

    protected void checkGetRequest(final GetDealsRequest request) {
	Preconditions.checkNotNull(request, "Request cant be null");
    }

    protected GetDealsResponse processGetRequest(final GetDealsRequest request) {
	final GetDealsResponse response = new GetDealsResponse();
	try {
	    checkGetRequest(request);
	    response.getDeal().addAll(getResults(request));
	    response.setStatus(SUCCESS);
	} catch (final Exception ae) {
	    logger.error(ae.getMessage(), ae);
	    response.setStatus(ERROR);
	    response.setErrorMessage(ae.getMessage());
	}
	return response;
    }

    protected abstract List<Deal> getResults(final GetDealsRequest request) throws DatatypeConfigurationException;

    protected void checkCreateRequest(final CreateDealsRequest request) {
	Preconditions.checkNotNull(request, "Insert Request cant be null");
    }

    protected CreateDealsResponse processCreateRequest(final CreateDealsRequest request) {
	final CreateDealsResponse response = new CreateDealsResponse();
	try {
	    checkCreateRequest(request);
	    for (final webservices.beans.createdeals.Deal deal : request.getDeal()) {
		try {
		    createDeals(deal);
		} catch (final Exception ae) {
		    final ResponseList responseList = new ResponseList();
		    responseList.setErrorMessage(ae.getMessage());
		    responseList.setErrorDeal(deal);
		    response.getResponseList().add(responseList);
		}
	    }
	    if (response.getResponseList().isEmpty()) {
		response.setStatus(SUCCESS);
	    } else {
		response.setStatus(ERROR);
	    }
	} catch (final Exception ae) {
	    logger.error(ae.getMessage(), ae);
	    response.setStatus(ERROR);
	}
	return response;
    }

    protected abstract void createDeals(final webservices.beans.createdeals.Deal deal);
}
