package name.stojanovski.kosta.nashornexample.utils;

import java.util.Objects;

public class NumberUtils {

	public static double getDouble(String attribute) {
		double doubleValue = Double.NaN;
		if (Objects.nonNull(attribute) && !attribute.isEmpty()) {
			try {
				doubleValue = Double.parseDouble(attribute);
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
		}
		return doubleValue;
	}
}
