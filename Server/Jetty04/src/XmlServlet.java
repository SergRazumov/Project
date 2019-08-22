import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class XmlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static DocumentBuilder docBuilder;
    
    static {
    	try {
		docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder(); // через класс фабрики создаем DocumentBuilder для создания Document

		} catch (ParserConfigurationException e) {
		}
    }
    
    private static Element createSimpleElement(Document doc, String tag, String text) {
    	Element element = doc.createElement(tag); // почему создается не через Node and NodeList
    	element.appendChild(doc.createTextNode(text));
    	// element.setNodeValue(text); почему нет так?
    	return element;
    }
    
    private static Document createCountryDoc(CountryInfo countryInfo) throws ParserConfigurationException {
		Document countryDoc = docBuilder.newDocument();
		Element countryElement = countryDoc.createElement("country");
		countryElement.appendChild(createSimpleElement(countryDoc, "name", countryInfo.getName()));
		countryElement.appendChild(createSimpleElement(countryDoc, "iso", countryInfo.getIso()));
		countryElement.appendChild(createSimpleElement(countryDoc, "english", countryInfo.getEnglishName()));
		countryElement.appendChild(createSimpleElement(countryDoc, "location", countryInfo.getContinent()));
		countryDoc.appendChild(countryElement);
    	return countryDoc;
    }

    @Override
    protected void doGet(
    		HttpServletRequest request,
    		HttpServletResponse response) {
    	
    	String path = request.getPathInfo();
    	response.setStatus(HttpServletResponse.SC_OK);
    	if (path.startsWith("/") && path.length() == 3) {
    		CountryInfo country = DataLoader.instance.getCountry(path.substring(1));
    		if (country != null) {
	    		response.setContentType("text/xml");
	    		response.setCharacterEncoding("UTF8");
	    		try {
	    			DOMSource domSource = new DOMSource(createCountryDoc(country)); // Выступает в качестве держателя для исходного дерева преобразования в форме дерева объектной модели документа (DOM).
					Transformer transformer = TransformerFactory.newInstance().newTransformer();
					transformer.transform(domSource, new StreamResult(response.getWriter())); // преобразование источник XML в текстовый результат
				} catch (IOException | TransformerFactoryConfigurationError | TransformerException | ParserConfigurationException e) {
					response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				}
    		} else {
    			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    		}
		} else {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    	}
    }
}
