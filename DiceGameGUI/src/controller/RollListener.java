/**
 * This is the controller for rolling the dices, this starts the game. It is triggered by the roll button in toolbar.
 * This button only enables for a player after the bet is set.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DiceGameFrame;
import view.DiceGamePanel;
import view.DiceGameSummaryPanel;
import view.DiceGameToolBar;
import view.SettingsDialogBox;

public class RollListener implements ActionListener {
	
	private GameEngine gameEngine;
	private DiceGameToolBar toolBar;
	private DiceGameSummaryPanel summaryPanel;
	private DiceGameFrame frame; 
	private SettingsDialogBox settingsDialogBox;
	
	private final int  initialDelay1 = 100;
	private final int finalDelay1 = 1000;
	private final int delayIncrement1 = 100;
	private final int initialDelay2 = 50;
	private final int finalDelay2 = 500;
	private final int delayIncrement2 = 50;
	
	public RollListener (GameEngine gameEngine, DiceGameFrame frame ,DiceGamePanel dicePanel, DiceGameToolBar toolBar, DiceGameSummaryPanel summaryPanel) {
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.summaryPanel = summaryPanel;
		this.frame = frame;
		settingsDialogBox = new SettingsDialogBox ();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Roll();
	}
	
	//this method contains a thread for house and player rolls.
	public void Roll() {
		new Thread() {
			
			@Override
			public void run() {
				String id = toolBar.getSelected();
				
				Player p = gameEngine.getPlayer(id);

					if (p.getBet() > 0) {

						frame.getMenu().SetEnableButtons(false);
						
						gameEngine.rollPlayer(p, initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
						frame.getViewModel().setPlayerToRolled(p);
						toolBar.enableRoll(false);
				    }
				
					if (gameEngine.getAllPlayers().size() == frame.getViewModel().getAllRolledPlayers().size()){
						for (Player pl : gameEngine.getAllPlayers()) {
							frame.getViewModel().addPoints(pl.getPoints());
						}
							
				    settingsDialogBox.houseRoll();
				    gameEngine.rollHouse(initialDelay1, finalDelay1, delayIncrement1, initialDelay2, finalDelay2, delayIncrement2);
				    
				    summaryPanel.refreshAfterRoll(gameEngine);
				    
			        frame.getMenu().SetEnableButtons(true);
			        frame.getViewModel().removeAllRolledPlayers();
				    }
		       }	
		}.start();
	}
}
