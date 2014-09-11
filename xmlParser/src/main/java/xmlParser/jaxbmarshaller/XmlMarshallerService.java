package xmlParser.jaxbmarshaller;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import xmlParser.bo.DealBO;
import xmlParser.jaxbobjects.Deal;

@Component("xmlMarshallerService")
public class XmlMarshallerService {

    @Value("${xml.file.name}")
    private String fileName;
    @Value("${xml.file.location}")
    private String fileLocation;

    public void createXmlFile(final List<DealBO> boListToCreate) throws JAXBException, URISyntaxException {
	if (boListToCreate != null) {
	    final JAXBContext jaxbContext = JAXBContext.newInstance(Deal.class);
	    final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	    // Marshal the employees list in console
	    jaxbMarshaller.marshal(boListToCreate, System.out);

	    final URL url = this.getClass().getResource(fileLocation + "/" + fileName + ".xml");

	    final File file = new File(url.toURI());
	    // Marshal the employees list in file
	    jaxbMarshaller.marshal(boListToCreate, file);
	}
    }
}
