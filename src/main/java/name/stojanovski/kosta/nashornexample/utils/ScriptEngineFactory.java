package name.stojanovski.kosta.nashornexample.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ScriptEngineFactory {

	private static final String JAVA_SCRIPT = "JavaScript";

	public static ScriptEngine createJavaScriptEngine() {
		return new ScriptEngineManager().getEngineByName(JAVA_SCRIPT);
	}
	
}
