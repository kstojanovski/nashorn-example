package name.stojanovski.kosta.nashornexample

import name.stojanovski.kosta.nashornexample.utils.FileUtils
import name.stojanovski.kosta.nashornexample.utils.Lookup
import spock.lang.Shared

class LookupJavaSpock extends spock.lang.Specification implements IConstants {

	@Shared def DATA_XML_URL = FileUtils.getFileAsUrl(DATA_XML);

	def "check if the java lookup method gives the correct data" (String id, String value, String lookup) {
		expect:
		Lookup.goForIt(DATA_XML_URL, id , value) == lookup

		where:
		id             | value|| lookup
		"identifier_3" | "50" || "identifier_31"
		"identifier_1" | "20" || "identifier_10"
		"identifier_0" | "66" || "identifier_02"
		"identifier_2" | "23" || "identifier_20"
	}

}