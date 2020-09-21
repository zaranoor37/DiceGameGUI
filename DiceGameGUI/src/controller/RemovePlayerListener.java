/**
 * This is the controller for removing a player from the menu.
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
import view.ScrollPane;
import view.SettingsDialogBox;

@SuppressWarnings("unused")
public class RemovePlayerListener implements ActionListener {
	
	private GameEngine gameEngine;
	private DiceGameToolBar toolBar;
	private ScrollPane scrollPane;
	private DiceGameSummaryPanel summaryPanel;

	public RemovePlayerListener (GameEngine gameEngine, DiceGameToolBar toolBar, DiceGameSummaryPanel summaryPanel) {
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.summaryPanel = summaryPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		scrollPane = new ScrollPane (gameEngine, toolBar, summaryPanel);
	}

}
