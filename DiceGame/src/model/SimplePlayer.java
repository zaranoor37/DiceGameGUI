/**
 * This class is implemented from the Player interface. 
 * It contains the SimplePlayer constructor as well as getters, setters, reset, and the to string method.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-04-23
 * 
 */

package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player {
	
	//creation of the player attributes
	private String playerId;
	private String playerName;
	private int initialPoints;
	private int bet;
	
	//creating a dice pair object that will be associated with the player
	private DicePair dicePair = new DicePairImpl ();
	
	//creation of the simple player constructor
	public SimplePlayer(String playerId, String playerName, int initialPoints) {
		
		//initializing variables
		this.playerId = playerId;
		this.playerName = playerName;
		this.initialPoints = initialPoints;
	}
 
	@Override
	public String getPlayerName() {
		
		return this.playerName;
	}
	
	@Override
	public void setPlayerName(String playerName) {
		
		this.playerName = playerName;
		
	}

	@Override
	public int getPoints() {
		
		return this.initialPoints;
	}

	@Override
	public void setPoints(int points) {
		
		this.initialPoints = points;
		
	}

	@Override
	public String getPlayerId() {
		
		return this.playerId;
	}

	@Override
	public boolean setBet(int bet) {

		if (bet == 0) {
			resetBet();
		} else if (bet > 0 && this.initialPoints >= bet) {
			this.bet = bet;
			return true;
		}
		return false;
	}

	@Override
	public int getBet() {
		
		return this.bet;
	}

	@Override
	public void resetBet() {
		
		this.bet = 0;
		
	}

	@Override
	public DicePair getResult() {
		
		return this.dicePair;
	}

	@Override
	public void setResult(DicePair rollResult) {
		
		this.dicePair = rollResult;
		
	}
	
	public String toString () {
		
		return ("Player:  id:" + this.playerId + " , name = " + this.playerName + ", bet = " + this.bet 
				+ ", points =" + this.initialPoints + ", RESULTS.." + dicePair.toString());
	}


}
