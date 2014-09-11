package xmlParser.jaxbmarshaller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import xmlParser.jaxbobjects.Deals;

@Component("xmlMarshallerService")
public class XmlMarshallerService implements IXmlMarshallerService {

    @Value("${xml.file.name}")
    private String fileName;
    @Value("${xml.file.classPathlocation}")
    private String fileLocation;

    public void createXmlFile(final Deals deals) throws JAXBException, URISyntaxException, IOException {
	if (deals != null) {
	    final JAXBContext jaxbContext = JAXBContext.newInstance(Deals.class);
	    final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    // Marshal the employees list in console
	    final String filePath = fileLocation + fileName;
	    final BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
	    // Marshal the employees list in file
	    jaxbMarshaller.marshal(deals, bos);
	    bos.flush();
	    bos.close();
	}
    }
}
