/**
 * This is the scroll pane controller, that opens up when removing a player from the menu.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.DiceGameSummaryPanel;
import view.DiceGameToolBar;
import view.ScrollPane;
import view.SettingsDialogBox;

public class ScrollPaneListener extends MouseAdapter {
	
	private ScrollPane scrollPane;
	private GameEngine gameEngine;
	private DiceGameToolBar toolBar;
	private DiceGameSummaryPanel summaryPanel;
	private SettingsDialogBox settingsDialogBox; 

	public ScrollPaneListener (ScrollPane scrollPane, GameEngine gameEngine, DiceGameToolBar toolBar, DiceGameSummaryPanel summaryPanel) {
		this.scrollPane = scrollPane;
		this.gameEngine = gameEngine;
		this.toolBar = toolBar;
		this.summaryPanel = summaryPanel;
		settingsDialogBox = new SettingsDialogBox ();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		Player p = gameEngine.getPlayer(scrollPane.getList().getSelectedValue().toString());
		gameEngine.removePlayer(p);
		scrollPane.removeP(p.getPlayerId());
		toolBar.refreshContent(gameEngine);
		summaryPanel.Add(gameEngine);
		settingsDialogBox.removeConfirm();
	}	
	
}
