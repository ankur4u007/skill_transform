package webservices.services.dealservice;

import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import webservices.beans.getdeals.Deal;
import webservices.beans.getdeals.GetDealsRequest;
import webservices.beans.getdeals.GetDealsResponse;

import com.google.common.base.Preconditions;

public abstract class AbstractServiceEndPoint {

    public static final String ERROR = "ERROR";

    protected void checkGetRequest(final GetDealsRequest request) {
	Preconditions.checkNotNull(request.getFacilityId(), "FacilityId cant be null");
	Preconditions.checkNotNull(request.getDrawDownId(), "DrawDownId cant be null");
	Preconditions.checkNotNull(request.getMaturityDate(), "MaturityDate cant be null");
    }

    protected GetDealsResponse processGetRequest(final GetDealsRequest request) {
	final GetDealsResponse response = new GetDealsResponse();
	try {
	    checkGetRequest(request);
	    response.getDeal().addAll(getResults(request));
	} catch (final Exception ae) {
	    response.setStatus(ERROR);
	    response.setErrorMessage(ae.getMessage());
	}
	return response;
    }

    protected abstract List<Deal> getResults(final GetDealsRequest request) throws DatatypeConfigurationException;
}
