package com.techlabs.strategy;

public class DoSubstraction implements IStrategy {

	@Override
	public int doOperation(int number_1, int number_2) {
		return number_1-number_2;
	}

}
