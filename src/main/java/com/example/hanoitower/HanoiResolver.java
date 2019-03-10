package com.example.hanoitower;

public class HanoiResolver {

	public void resolve(int numDisk, int tower1, int tower2, int tower3) {

		if (numDisk == 1) {
			System.out.println("Movemos de torre: " + tower1 + " a " + tower3);
		} else {

			resolve(numDisk - 1, tower1, tower3, tower2);
			System.out.println("Movemos de torre: " + tower1 + " a " + tower3);
			resolve(numDisk - 1, tower2, tower1, tower3);

		}
	}

}
