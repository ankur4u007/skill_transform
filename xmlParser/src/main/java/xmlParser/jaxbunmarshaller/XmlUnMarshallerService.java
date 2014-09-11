package xmlParser.jaxbunmarshaller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import xmlParser.jaxbobjects.Deal;
import xmlParser.jaxbobjects.Deals;

@Component("XmlUnMarshallerService")
public class XmlUnMarshallerService implements IXmlUnMarshallerService {

    @Value("${xml.file.name}")
    private String fileName;
    @Value("${xml.file.classPathlocation}")
    private String fileLocation;

    public List<Deal> getObjectListFromXmlFile() throws JAXBException, URISyntaxException, IOException {

	final List<Deal> listToReturn = new ArrayList<Deal>();
	final JAXBContext jaxbContext = JAXBContext.newInstance(Deals.class);
	final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	final String filePath = fileLocation + fileName;
	final BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(filePath)));
	// We had written this file in marshalling example
	final Deals deals = (Deals) jaxbUnmarshaller.unmarshal(bis);
	bis.close();
	if (deals != null) {
	    for (final Deal deal : deals.getDeal()) {
		listToReturn.add(deal);
	    }
	}
	return listToReturn;
    }
}
