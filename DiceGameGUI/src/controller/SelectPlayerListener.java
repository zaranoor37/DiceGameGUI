/**
 * This is the controller for selecting a player from the toolbar.
 * When a player is selected, it shows up in the status and the menu also ENABLES for that specific player selected.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DiceGameDiceStatuses;
import view.DiceGameFrame;
import view.DiceGameToolBar;


public class SelectPlayerListener implements ItemListener{
	
	private DiceGameDiceStatuses status;
	private GameEngine gameEngine;
	private DiceGameToolBar toolBar;
	private DiceGameFrame frame;
	
	public SelectPlayerListener (DiceGameFrame frame, GameEngine gameEngine, DiceGameDiceStatuses status, DiceGameToolBar toolBar) {
		this.status = status;
		this.gameEngine = gameEngine;
		this.frame = frame;
		this.toolBar = toolBar;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		 if (e.getStateChange() == ItemEvent.SELECTED) {
	          Object item = e.getItem();
	          toolBar.setSelected((String) item);
		      status.updateLabel(item);
		      status.setID(item);
		      Player p = gameEngine.getPlayer((String) item);
		     
		      if (frame.getViewModel().playerHasRolled(p.getPlayerId()) == true) {
	    		  toolBar.enableRoll(false);
	    		  
	          } else if (frame.getViewModel().playerHasRolled(p.getPlayerId()) == false && p.getBet() > 0 && e.getItem() == p.getPlayerId()) {
	    		  toolBar.enableRoll(true);
	    		 
	          }
	     }  
    }
	
}
