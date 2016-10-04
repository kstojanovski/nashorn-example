package name.stojanovski.kosta.nashornexample;

import java.net.URL;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.junit.Assert;
import org.junit.Test;

import name.stojanovski.kosta.nashornexample.IConstants;
import name.stojanovski.kosta.nashornexample.utils.FileUtils;
import name.stojanovski.kosta.nashornexample.utils.Lookup;
import name.stojanovski.kosta.nashornexample.utils.NumberUtils;
import name.stojanovski.kosta.nashornexample.utils.ScriptEngineFactory;

public class NashhornExampleTest implements IConstants {

	private static final URL DATA_XML_URL = FileUtils.getFileAsUrl(DATA_XML);

	@Test
	public void testLookup() {
		Assert.assertEquals("identifier_31", Lookup.goForIt(DATA_XML_URL, "identifier_3", "50"));
		Assert.assertEquals("identifier_10", Lookup.goForIt(DATA_XML_URL, "identifier_1", "20"));
		Assert.assertEquals("identifier_02", Lookup.goForIt(DATA_XML_URL, "identifier_0", "66"));
		Assert.assertEquals("identifier_20", Lookup.goForIt(DATA_XML_URL, "identifier_2", "23"));
	}
	
	@Test
	public void testNumberUtils() {
		int DELTA = 0;
		Assert.assertEquals(20, NumberUtils.getDouble("20"), DELTA);
		Assert.assertEquals(Double.NaN, NumberUtils.getDouble("asdasd"), DELTA);
		Assert.assertEquals(Double.NaN, NumberUtils.getDouble(""), DELTA);
		Assert.assertEquals(Double.NaN, NumberUtils.getDouble(null), DELTA);
		Assert.assertEquals(23.3453, NumberUtils.getDouble("23.3453"), DELTA);
	}
	
	@Test
	public void testlookup() throws ScriptException, NoSuchMethodException {
		ScriptEngine scriptEngine = ScriptEngineFactory.createJavaScriptEngine();
		Invocable inv = (Invocable) scriptEngine;	
		scriptEngine.eval(FileUtils.getFileAsReader("lookup.js"));
		
		Assert.assertEquals("identifier_31", inv.invokeFunction("lookup", DATA_XML_URL, "identifier_3", "50"));
		Assert.assertEquals("identifier_10", inv.invokeFunction("lookup", DATA_XML_URL, "identifier_1", "20"));
		Assert.assertEquals("identifier_02", inv.invokeFunction("lookup", DATA_XML_URL, "identifier_0", "66"));
		Assert.assertEquals("identifier_20", inv.invokeFunction("lookup", DATA_XML_URL, "identifier_2", "23"));
	}
}
