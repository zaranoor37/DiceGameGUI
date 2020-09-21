/**
 * This class is my test game engine class.
 * The following class tests player, dice pair and die class and method as a whole.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-04-23
 * 
 */

package client;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class TestGameEngine {

	public static void main(String[] args) {
		
		GameEngine gameEngine = new GameEngineImpl ();
		
		//this tests the add player method
		Player player1 = new SimplePlayer ("1", "Ali Azhar", 600);
		Player player2 = new SimplePlayer ("2", "Sara Amjad", 700);
		Player player3 = new SimplePlayer ("3", "Phiskeen", 900);
		gameEngine.addPlayer(player1);
		gameEngine.addPlayer(player2);
		gameEngine.addPlayer(player3);
		
		//this tests the remove player method
		gameEngine.removePlayer(player2);
		
		//This tests adding the same id player as a player that already exists in the player collection
		Player player4 = new SimplePlayer ("3", "Mehreen Khan", 500);
		gameEngine.addPlayer(player4);
		
		//This tests the get all players method
		System.out.println(gameEngine.getAllPlayers() + "\n");
		
		//This tests the get player method
		System.out.println(gameEngine.getPlayer("1") + "\n");
		
		//This tests the place bet method for a player
		gameEngine.placeBet(player1, 300);
		System.out.println(gameEngine.getPlayer("1") + "\n");

	}

}
