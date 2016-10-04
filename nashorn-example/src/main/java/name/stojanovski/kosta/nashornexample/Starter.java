package name.stojanovski.kosta.nashornexample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

import name.stojanovski.kosta.nashornexample.model.Container;
import name.stojanovski.kosta.nashornexample.utils.ContainerCreator;
import name.stojanovski.kosta.nashornexample.utils.FileUtils;
import name.stojanovski.kosta.nashornexample.utils.ScriptEngineFactory;

public class Starter implements IConstants {

	public static void main(String[] args) {
		Map<String, Container> containers = ContainerCreator.getContainers();
		ScriptEngine scriptEngine = ScriptEngineFactory.createJavaScriptEngine();
		
		System.out.println("Starter.main()");
		ContainerCreator.printContainers();
		
		Bindings bindings = new SimpleBindings();
		bindings.put("containers", containers);
		bindings.put("dataXml", FileUtils.getFileAsUrl(DATA_XML));
		scriptEngine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
		
		startProcessing(scriptEngine, new ArrayList<String>(Arrays.asList("processings_simple.js")));
		ContainerCreator.deleteLookup();
		startProcessing(scriptEngine, new ArrayList<String>(Arrays.asList("lookup.js", "processings_lookup_js.js")));
		ContainerCreator.deleteLookup();
		startProcessing(scriptEngine, new ArrayList<String>(Arrays.asList("processings_lookup_java.js")));
	}

	private static void startProcessing(ScriptEngine scriptEngine, List<String> processingFilenames) {
		System.out.println("Starter.startProcessing()");
		try {
			for (String processingFileame : processingFilenames) {
				scriptEngine.eval(FileUtils.getFileAsReader(processingFileame));
			}
			ContainerCreator.printContainers();
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
