/**
 * This class is my test simple player class.
 * The following class tests player, dice pair and die class and method as a whole.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-04-23
 * 
 */

package client;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.Player;
import model.DicePairImpl;
import model.DieImpl;
import model.SimplePlayer;

public class TestSimplePlayer {

	public static void main(String[] args) {
		
		//This shows a general simple player to string output.
		Player player1 = new SimplePlayer ("1", "Zara Noor", 500);
		DicePair dp1 = new DicePairImpl();
		player1.setResult(dp1);
		System.out.println(player1.toString() + "\n");
		
		//This shows the set bet method in action
		Player player2 = new SimplePlayer ("2", "Cindy William", 1000);
		System.out.println(player2.toString());
		player2.setBet(100);
		System.out.println(player2.toString() + "\n");
		
		//This shows the reset bet method 
		Player player3 = new SimplePlayer ("3", "Naura Advani", 700);
		player3.setBet(500);
		System.out.println(player3.toString());
		player3.resetBet();
		System.out.println(player3.toString() + "\n");
		
		//This shows the to string output when an illegal bet done. It refuses the bet.
		Player player4 = new SimplePlayer ("4", "Zoya Aziz", 400);
		player4.setBet(500);
		System.out.println(player4.toString() + "\n");
		

		Die die1 = new DieImpl (1, 3, 6);
		Die die2 = new DieImpl (2, 3, 6);
		
		//This shows the die equal method in the die class.
		System.out.println(die1.equals(die2) + "\n");
		
		//This shows the output of the object equal method in the die class.
		System.out.println(die1.equals(die2) + "\n");
		
		DicePair dpOne = new DicePairImpl ();
		DicePair dpTwo = new DicePairImpl ();
		System.out.println(dpOne.toString());
		System.out.println(dpTwo.toString() + "\n");
		
		//This shows the output of the equals method in dice pair class.
		System.out.println(dpOne.equals(dpTwo) + "\n");
		
		//This shows the output of the compare to method in the dice pair class.
		System.out.println(dpOne.compareTo(dpTwo));
		
		
//		invalid number for die
//		Die invalidDie = new DieImpl (1,7,6);
//		System.out.println(invalidDie.toString());
			
	}

}
