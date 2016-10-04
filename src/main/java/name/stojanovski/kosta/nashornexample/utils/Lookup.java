package name.stojanovski.kosta.nashornexample.utils;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import name.stojanovski.kosta.nashornexample.IConstants;

public class Lookup implements IConstants {

	public static String goForIt(URL dataXml, String id, String value) {
		String lookup = EMPTY_STRING;
		Double valueDouble = Double.parseDouble(value);
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document document = saxBuilder.build(dataXml);
			XPathFactory xpathFactory = XPathFactory.instance();
			XPathExpression<Object> xPathExpression = xpathFactory.compile("/data/item[@id=\"" + id + "\"]/value");
			List<Object> xPathSearchedNodes = xPathExpression.evaluate(document);
			for (int i = 0; i < xPathSearchedNodes.size(); i++) {
				Element valueElement = (Element)xPathSearchedNodes.get(i);
				String min = valueElement.getAttributeValue("min");
				String max = valueElement.getAttributeValue("max");
				double minDouble = NumberUtils.getDouble(min);
				double maxDouble = NumberUtils.getDouble(max);
				if ((!Double.isNaN(minDouble) && !Double.isNaN(maxDouble) && minDouble <= valueDouble
						&& maxDouble >= valueDouble) 
						|| (Double.isNaN(maxDouble) && minDouble <= valueDouble)
						|| (Double.isNaN(minDouble) && maxDouble >= valueDouble)) {
					lookup = valueElement.getTextTrim();
				}
			}
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lookup;
	}

}
