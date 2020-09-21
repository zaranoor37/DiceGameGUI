/**
 * This is the controller for placing a bet, from the menu.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;

import view.DiceGameSummaryPanel;
import view.DiceGameToolBar;
import view.PlaceBetDialogBox;


public class PlaceBetListener implements ActionListener{
	
	private GameEngine gameEngine;
	private DiceGameToolBar toolBar;
	private DiceGameSummaryPanel summaryPanel;

	public PlaceBetListener (GameEngine gameEngine, DiceGameToolBar toolBar, DiceGameSummaryPanel summaryPanel) {
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.summaryPanel = summaryPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		new PlaceBetDialogBox(gameEngine, toolBar, summaryPanel);
		
	}

}