/**
 * This is the controller for adding a player
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.AddPlayerDialogBox;
import view.DiceGameSummaryPanel;
import view.DiceGameToolBar;

public class AddPlayerListener implements ActionListener {
	
	private DiceGameToolBar toolBar;
	private GameEngine gameEngine;
	private DiceGameSummaryPanel summaryPanel;
	
	public AddPlayerListener (GameEngine gameEngine,DiceGameToolBar toolBar,DiceGameSummaryPanel summaryPanel) {
		
		this.toolBar = toolBar;
		this.gameEngine = gameEngine;
		this.summaryPanel = summaryPanel;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		new AddPlayerDialogBox(gameEngine, toolBar, summaryPanel);
		
	}
		
}