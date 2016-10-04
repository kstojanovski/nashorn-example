package name.stojanovski.kosta.nashornexample

import org.junit.Assert;

import name.stojanovski.kosta.nashornexample.utils.FileUtils
import name.stojanovski.kosta.nashornexample.utils.Lookup
import name.stojanovski.kosta.nashornexample.utils.NumberUtils;
import spock.lang.Shared

class NumberUtilsSpock extends spock.lang.Specification implements IConstants {

	@Shared def DATA_XML_URL = FileUtils.getFileAsUrl(DATA_XML);

	def "check if number utils gives the correct data" (String value, double doubleValue) {
		expect:
		NumberUtils.getDouble(value) == doubleValue

		where:
		value     || doubleValue
		"20"      || 20
		"asdasd"  || Double.NaN
		""        || Double.NaN
		null      || Double.NaN
		"23.3453" || 23.3453
	}
}