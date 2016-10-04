package name.stojanovski.kosta.nashornexample

import javax.script.Invocable
import javax.script.ScriptEngine

import name.stojanovski.kosta.nashornexample.utils.FileUtils
import name.stojanovski.kosta.nashornexample.utils.ScriptEngineFactory
import spock.lang.Shared
import spock.lang.Unroll

class LookupJavascriptSpock extends spock.lang.Specification implements IConstants {

	@Shared def LOOKUP_JS = "lookup.js"
	@Shared def scriptEngine = ScriptEngineFactory.createJavaScriptEngine()
	@Shared def FUNC_NAME = "lookup";
	@Shared def DATA_XML_URL = FileUtils.getFileAsUrl(DATA_XML);
	@Shared def LOOKUP_JS_READER = FileUtils.getFileAsReader(LOOKUP_JS)
	
	def setupSpec() {
		scriptEngine.eval(LOOKUP_JS_READER)	
	}
		
	@Unroll
	def "check if the javascript lookup function gives the correct data - when, then, where"() {
		when:
		def lookup = scriptEngine.invokeFunction(FUNC_NAME, DATA_XML_URL, id, value)
		
		then:
		lookup == expected

		where:
		id             | value || expected
		"identifier_3" | "50"  || "identifier_31"
		"identifier_1" | "20"  || "identifier_10"
		"identifier_0" | "66"  || "identifier_02"
		"identifier_2" | "23"  || "identifier_20"
	}
	
	@Unroll
	def "check if the javascript lookup function gives the correct data - expect, where" () {
		expect:
		scriptEngine.invokeFunction(FUNC_NAME, DATA_XML_URL, id, value) == lookup

		where:
		id             | value || lookup
		"identifier_3" | "50"  || "identifier_31"
		"identifier_1" | "20"  || "identifier_10"
		"identifier_0" | "66"  || "identifier_02"
		"identifier_2" | "23"  || "identifier_20"
	}

}