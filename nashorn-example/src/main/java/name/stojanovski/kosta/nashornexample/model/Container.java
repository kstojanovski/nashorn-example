package name.stojanovski.kosta.nashornexample.model;

import name.stojanovski.kosta.nashornexample.IConstants;

public class Container implements IConstants {

	private String id;
	private int order;
	private String name;
	private double value;
	private String lookup;

	public Container(String id, int order, String name, double value) {
		super();
		this.id = id;
		this.order = order;
		this.name = name;
		this.value = value;
		this.lookup = EMPTY_STRING;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getLookup() {
		return lookup;
	}

	public void setLookup(String lookup) {
		this.lookup = lookup;
	}

	public String printProperties() {
		return new StringBuilder().append(id).append(DELIMITER).append(order).append(DELIMITER).append(name)
				.append(DELIMITER).append(value).append(DELIMITER).append(lookup).append(DELIMITER).toString();
	}
}
