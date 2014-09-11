package xmlParser.jaxbmarshaller;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.xml.bind.JAXBException;

import xmlParser.jaxbobjects.Deals;

public interface IXmlMarshallerService {

    public void createXmlFile(final Deals deals) throws JAXBException, URISyntaxException, IOException;
}
