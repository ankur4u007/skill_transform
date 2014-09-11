package xmlParser.jaxbunmarshaller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.xml.bind.JAXBException;

import xmlParser.jaxbobjects.Deal;

public interface IXmlUnMarshallerService {

    public List<Deal> getObjectListFromXmlFile() throws JAXBException, URISyntaxException, IOException;
}
