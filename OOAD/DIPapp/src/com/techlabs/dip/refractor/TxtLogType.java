package com.techlabs.dip.refractor;

public class TxtLogType implements ILogType {
	public void log(String time, String message) {
		System.err.print("There is an Error at ");
		System.out.print(time + " " + message);

	}
}
