/**
 * This is the view model class that stores information of player and his work.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import java.util.ArrayList;
import model.interfaces.Player;

public class ViewModel {
	
	private ArrayList <Player> rolledPlayers = new ArrayList <Player>();
	private ArrayList <Integer> initialPoints = new ArrayList <Integer>();
	
	public ViewModel () {
		
	}
	
	public void addPoints (int point) {
		initialPoints.add(point);
	}
	
	public ArrayList<Integer> getAllPoints () {
		return this.initialPoints;
	}
	
	public void setPlayerToRolled (Player p) {
		rolledPlayers.add(p);
	}
	
	public ArrayList <Player> getAllRolledPlayers (){
		return this.rolledPlayers;
	}
	
	public boolean playerHasRolled(String id) {

		for (int i = 0; i < rolledPlayers.size(); i++) {
			if (rolledPlayers.get(i).getPlayerId() == id) {
				 return true;
		    }
		}
		return false;
	}
	
	
	public void removeAllRolledPlayers () {
		this.rolledPlayers.removeAll(rolledPlayers);
	}
	
}
