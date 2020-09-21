/**
 * This class is implemented from the game engine interface. 
 * It contains the player collection, game engine callback collection and all the required methods for the game.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-04-23
 * 
 */

package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine{
	
	
	public GameEngineImpl () {
	
	}
	
	//creation of a dice pair object for the house.
	private DicePair dpHouse = new DicePairImpl ();
	
	//creation of players and game engine callback collection using array list
	//Collection <Player> players = new ArrayList <Player>();
	ArrayList <Player> players = new ArrayList <Player>();
	ArrayList <GameEngineCallback> games = new ArrayList <GameEngineCallback>();

	@Override
	public void rollPlayer(Player player, int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2,
			int finalDelay2, int delayIncrement2) {
		if (delayIncrement1 < 0 || delayIncrement2 < 0 || initialDelay1 < 0 || initialDelay2 < 0 || finalDelay1 < 0 || 
			finalDelay2 < 0 || finalDelay1 < initialDelay1 || finalDelay2 < initialDelay2 || 
			(delayIncrement1 > (finalDelay1 - initialDelay1))|| (delayIncrement2 > (finalDelay2 - initialDelay2))) {
			 throw new IllegalArgumentException();
		}
		
		for (int i = initialDelay1; i <= finalDelay1; i+=delayIncrement1) {
			for (int j = 0; j < games.size(); j++) {
				games.get(j).playerDieUpdate(player, player.getResult().getDie1(), this);
			}
		}
		
		for (int i = initialDelay2; i <= finalDelay2; i+=delayIncrement2) {
			for (int j = 0; j < games.size(); j++) {
				games.get(j).playerDieUpdate(player, player.getResult().getDie2(), this);
			}
		}
		
		for (int j = 0; j < games.size(); j++) {
			games.get(j).playerResult(player, player.getResult(), this);
		}
    }

	@Override
	public void rollHouse(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2,
			int delayIncrement2) {
		
		if (delayIncrement1 < 0 || delayIncrement2 < 0 || initialDelay1 < 0 || initialDelay2 < 0 || finalDelay1 < 0 || 
				finalDelay2 < 0 || finalDelay1 < initialDelay1 || finalDelay2 < initialDelay2 || 
				(delayIncrement1 > (finalDelay1 - initialDelay1))|| (delayIncrement2 > (finalDelay2 - initialDelay2))) {
				    throw new IllegalArgumentException();
			}
		
		
		for (int i = initialDelay1; i <= finalDelay1; i+= delayIncrement1) {
			for (int j = 0; j < games.size(); j++) {
				games.get(j).houseDieUpdate(dpHouse.getDie1(), this);
			} 
		}
		
		for (int i = initialDelay2; i <= finalDelay2; i+= delayIncrement1) {
			for (int j = 0; j < games.size(); j++) {
				games.get(j).houseDieUpdate(dpHouse.getDie2(), this);
			}
		}
		
		for (int i = 0; i < players.size(); i++) {
			applyWinLoss(players.get(i), dpHouse);
		}
		
		for (int j = 0; j < games.size(); j++) {
			games.get(j).houseResult(dpHouse, this);
		}
		
		for (int i = 0; i < players.size(); i++) {
			players.get(i).resetBet();
		}
		
	}

	@Override
	public void applyWinLoss(Player player, DicePair houseResult) {
		
		if (player != null) {
			if (player.getResult().getTotal() > houseResult.getTotal()) {
				player.setPoints(player.getPoints() + player.getBet());
			} else if (player.getResult().getTotal() < houseResult.getTotal()) {
				player.setPoints(player.getPoints() - player.getBet());
			} else if (player.getResult().getTotal() == houseResult.getTotal()) {
				player.setPoints(player.getPoints());
			}
		}
		
	}

	@Override
	public void addPlayer(Player player) {
		boolean check = false;
		for(int i=0; i < players.size(); i++) {
			if (players.get(i) != null && players.get(i).getPlayerId().equals(player.getPlayerId())) {
				players.remove(i);
				players.add(player);
				check = true;
			} 
		} if (check == false)
		players.add(player);
	
	}

	@Override
	public Player getPlayer(String id) {
		Player player = null;
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).getPlayerId() == id) {
				player = players.get(i);
			}
		}
		
		return player;
	}

	@Override
	public boolean removePlayer(Player player) {
		
		if (players.contains(player)){
			players.remove(player);
			return true;
		} else 
		return false;
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		
		return player.setBet(bet);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		
		games.add(gameEngineCallback);
		
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		
		if (games.contains(gameEngineCallback)){
			games.remove(gameEngineCallback);
			return true;
		} else 
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		
		//return players;
		return Collections.unmodifiableCollection(players);
	
	}
	
}
