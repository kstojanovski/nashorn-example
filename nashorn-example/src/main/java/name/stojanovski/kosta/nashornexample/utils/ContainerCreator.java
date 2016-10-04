package name.stojanovski.kosta.nashornexample.utils;

import java.util.LinkedHashMap;
import java.util.Map;

import name.stojanovski.kosta.nashornexample.IConstants;
import name.stojanovski.kosta.nashornexample.model.Container;

public class ContainerCreator implements IConstants {

	private static Map<String, Container> contaienrs = new LinkedHashMap<String, Container>();

	static {
		for (int i = 0; i < 4; i++) {
			String id = "identifier_" + i;
			contaienrs.put(id, new Container(id, i, id, ((i + 2) * 10)));
		}
	}

	public static Map<String, Container> getContainers() {
		return contaienrs;
	}

	public static void main(String[] args) {
		printContainers();
	}

	public static void printContainers() {
		for (String id : contaienrs.keySet()) {
			System.out.println(contaienrs.get(id).printProperties());
		}
	}
	
	public static void deleteLookup() {
		for (String id : contaienrs.keySet()) {
			contaienrs.get(id).setLookup(EMPTY_STRING);
		}
	}	
}
