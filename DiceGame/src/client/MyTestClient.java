/**
 * This class is my test client class.
 * The following class is similar to the simple test client and tests different functionalities of the dice game.
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
import validate.Validator;
import view.GameEngineCallbackImpl;

public class MyTestClient {

	public static void main(String[] args) {
		
		pass();
		System.out.println("");
		fail();
		
	}

	//this method shows the passed version of the dice game. It has 3 players.
	public static void pass () {
		
		final GameEngine gameEngine = new GameEngineImpl();

		Validator.validate(false);

		Player[] players = new Player[] { new SimplePlayer("10", "Aziz", 900), 
				new SimplePlayer( "20", "Safia", 500),
				new SimplePlayer ("30", "Zeshan", 800)};

		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());

	     for (Player player : players)
		     gameEngine.addPlayer(player);

		 for (Player player : gameEngine.getAllPlayers())
		 
		 {    
		    gameEngine.placeBet(player, 200);
		    gameEngine.rollPlayer(player, 100, 1000, 100, 50, 500, 50);
		 }

		 gameEngine.rollHouse(100, 1000, 200, 50, 500, 25);
	
	}
	
	//this method shows the failed version of the dice game. Where the illegal argument exception shows up due to an 
	//invalid input.
	public static void fail () {
		
		final GameEngine gameEngine = new GameEngineImpl();

		Validator.validate(false);

		Player[] players = new Player[] { new SimplePlayer("10", "Abdul", 900), 
				new SimplePlayer( "20", "Safia", 500)};

		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());

	     for (Player player : players)
		     gameEngine.addPlayer(player);

		 for (Player player : gameEngine.getAllPlayers())
		 
		 {    
		    gameEngine.placeBet(player, 200);
		    gameEngine.rollPlayer(player, 100, 50, 100, 50, 500, 50);
		 }

		 gameEngine.rollHouse(100, 1000, 200, 50, 500, 25);
		
	}
	
}