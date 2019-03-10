package com.example.hanoitower;

public class MainHanoi {

	public static void main(String[] args) {
		
		HanoiResolver hanoi =new HanoiResolver();
		
		hanoi.resolve(3, 1, 2, 3);

	}

}
