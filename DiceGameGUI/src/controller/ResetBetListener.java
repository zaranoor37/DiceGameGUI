/**
 * This is the controller for resetting a bet for a player, from the menu.
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
import view.DiceGameSummaryPanel;
import view.DiceGameToolBar;
import view.SettingsDialogBox;

public class ResetBetListener implements ActionListener{

	private GameEngine gameEngine;
	private SettingsDialogBox settingsDialogBox;
	private DiceGameToolBar toolBar;
	private DiceGameSummaryPanel summaryPanel;
	
	public ResetBetListener (GameEngine gameEngine, DiceGameToolBar toolBar, DiceGameSummaryPanel summaryPanel) {
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.summaryPanel = summaryPanel;
		settingsDialogBox = new SettingsDialogBox ();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		resetBet();
		summaryPanel.Add(gameEngine);
		settingsDialogBox.resetBetConfirm();
	}
	
	public void resetBet () {
		Player player = gameEngine.getPlayer(toolBar.getSelected());
		player.resetBet();
	}

}
