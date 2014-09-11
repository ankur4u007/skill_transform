/**
 *
 */
package xmlParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xmlParser.bo.DealBO;
import xmlParser.bo.DrawDownBO;
import xmlParser.bo.FacilityBO;
import xmlParser.bofactory.BOFactory;
import xmlParser.jaxbObjfactory.JaxbObjFactory;
import xmlParser.jaxbmarshaller.IXmlMarshallerService;
import xmlParser.jaxbobjects.Deal;
import xmlParser.jaxbobjects.Deals;
import xmlParser.jaxbunmarshaller.IXmlUnMarshallerService;
import xmlParser.service.deal.IDealService;

/**
 * @author CHANDRAYAN
 *
 */
public class Main {

    /**
     * @param args
     * @throws DatatypeConfigurationException
     * @throws URISyntaxException
     * @throws JAXBException
     * @throws IOException
     * @throws ParseException
     */
    public static void main(final String[] args) throws DatatypeConfigurationException, JAXBException,
    URISyntaxException, IOException, ParseException {
	final ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
	final IDealService dealService = context.getBean(IDealService.class);
	final IXmlMarshallerService XmlMarshallerService = context.getBean(IXmlMarshallerService.class);
	final IXmlUnMarshallerService XmlUnMarshallerService = context.getBean(IXmlUnMarshallerService.class);

	final Deals dealsToCreate = JaxbObjFactory.createDummyDeals(10);
	// create a xml file with 10 records
	XmlMarshallerService.createXmlFile(dealsToCreate);
	// read from the created sml file
	final List<Deal> dealList = XmlUnMarshallerService.getObjectListFromXmlFile();
	// creating deals
	dealService.createDeals(dealList);

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
		if (drawDownList != null && drawDownList.size() > 0) {
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

	// creating deal for matutrity 16-sep-2013
	final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	final Date matDate = formatter.parse("2013-09-06");
	List<DealBO> resultList = dealService.getDealsByMaturityDate(matDate);
	System.out.println("Deal Found by DATE :" + matDate.toString() + " , " + resultList);
	// finding deals by maturity date 16-sep-2013
	final List<DealBO> boList = BOFactory.createDealBOList(1);
	boList.get(0).setMaturityDate(matDate);
	dealService.createDealsByBOList(boList);
	resultList = dealService.getDealsByMaturityDate(matDate);
	System.out.println("Deal Found by DATE :" + matDate.toString() + " , " + resultList);
    }
}
