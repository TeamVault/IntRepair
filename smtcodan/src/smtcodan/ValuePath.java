package smtcodan;

import java.util.ArrayDeque;

import smtcodan.interpreter.ActionLog.CfgNodeActions;

public class ValuePath {
	String value;
	ArrayDeque<CfgNodeActions> list;
	String node;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ArrayDeque<CfgNodeActions> getList() {
		return list;
	}

	public void setList(ArrayDeque<CfgNodeActions> list) {
		this.list = list;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public ValuePath(String value, String node, ArrayDeque<CfgNodeActions> list) {
		super();
		this.value = value;
		this.node = node;
		this.list = list;
	}

}