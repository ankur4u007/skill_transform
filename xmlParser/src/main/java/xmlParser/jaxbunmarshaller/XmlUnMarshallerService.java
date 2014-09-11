package xmlParser.jaxbunmarshaller;

import java.io.File;
import java.net.URISyntaxException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import xmlParser.jaxbobjects.Deal;

@Component("XmlUnMarshallerService")
public class XmlUnMarshallerService {

    @Value("${xml.file.name}")
    private String fileName;
    @Value("${xml.file.location}")
    private String fileLocation;

    public List<Deal> getObjectListFromXmlFile() throws JAXBException, URISyntaxException {

	final List<Deal> listToReturn = null;
	final JAXBContext jaxbContext = JAXBContext.newInstance(Deal.class);
	final Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

	// We had written this file in marshalling example
	final Deal deals = (Deal) jaxbUnmarshaller.unmarshal(new File("c:/temp/employees.xml"));
	if (deals != null) {
	    for (final Deal deal : deals) {
		listToReturn.add(deal);
	    }
	}
	return listToReturn;
    }
}
