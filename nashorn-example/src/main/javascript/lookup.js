var lookup = function(dataXml, id, value) {
	var returnValue = "";
	try { 
		var Double = Java.type("java.lang.Double")
		,valueDouble = Double.parseDouble(value)
		,SAXBuilder = Java.type("org.jdom2.input.SAXBuilder")
		,saxBuilder = new SAXBuilder()
		,document = saxBuilder.build(dataXml)
		,XPathFactory = Java.type("org.jdom2.xpath.XPathFactory")
		,xpathFactory = XPathFactory.instance()
		,expr = xpathFactory.compile('/data/item[@id="'+id+'"]/value')
		,xPathSearchedNodes = expr.evaluate(document);
		
		for (i = 0; i < xPathSearchedNodes.size(); i++) {
			var content = xPathSearchedNodes.get(i), min = content.getAttributeValue("min"), max = content.getAttributeValue("max"),
			minDouble = min ? Double.parseDouble(min) : Double.NaN, maxDouble = max ? Double.parseDouble(max) : Double.NaN;
			if ((!Double.isNaN(minDouble) && !Double.isNaN(maxDouble) && minDouble <= valueDouble && maxDouble >= valueDouble)
				||	(Double.isNaN(maxDouble) && minDouble <= valueDouble)
				||	(Double.isNaN(minDouble) && maxDouble >= valueDouble)) {
				returnValue = content.getValue(); 
			}
		}
	} catch (exception) {
		print(exception);
	}
	return returnValue;
}	

var add = function(a, b) {
  return a + b;
}
	 
var square = function(a) {
  return a * a;
}