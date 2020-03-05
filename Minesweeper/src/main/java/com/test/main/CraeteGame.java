package com.test.main;

public class CraeteGame {
	private static CreateFrame frame;
	
	public static void newGame() {
		frame = new CreateFrame(9,9,10);
	}
}
