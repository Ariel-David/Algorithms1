package Monty_Hall_problem;

/**
 * This class presents random simulations of the Monty Hall game,
 * using three doors for each strategy and shows the results in such a way 
 * as to make it easy to compare the effects of each strategy.
 * It shows the effects of a strategy of the contestant always keeping his first guess 
 * so it can be contrasted with the strategy of the contestant always switching his guess.
 * A YouTube video: https://www.youtube.com/watch?v=4Lb-6rxZxx0
 */

import java.util.Random;

public class Monty {
	public static void main(String[] args){
		int switchWins = 0;
		int stayWins = 0;
		Random gen = new Random();
		int ROUNDS = 32768;
		for(int plays = 0;plays < ROUNDS;plays++ ){
			int[] doors = {0,0,0};//0 is a goat, 1 is a car
			doors[gen.nextInt(3)] = 1;//put a winner in a random door
			int choice = gen.nextInt(3); //pick a door, any door
			int shown; //the shown door
			do{
				shown = gen.nextInt(3);
				//don't show the winner or the choice
			}while(doors[shown] == 1 || shown == choice);

			stayWins += doors[choice];//if you won by staying, count it

			//the switched (last remaining) door is (3 - choice - shown), because 0+1+2=3
			switchWins += doors[3 - choice - shown];
		}
		System.out.println("Switching wins " + switchWins + " times.");
		System.out.println("Staying wins " + stayWins + " times.");
	}
}
