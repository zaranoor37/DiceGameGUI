/**
 * This is the view that shows the menu bar, up in the frame.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.AddPlayerListener;
import controller.ExitListener;
import controller.PlaceBetListener;
import controller.RemovePlayerListener;
import controller.ResetBetListener;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class DiceGameMenu extends JMenuBar{
	
	private JMenu settings;
	private JMenuItem AddPlayer;
	private JMenuItem RemovePlayer;
	private JMenuItem PlaceBet;
	private JMenuItem ResetBet;
	private JMenuItem Exit;
	
	public DiceGameMenu (GameEngine gameEngine , DiceGameToolBar toolBar, DiceGameSummaryPanel summaryPanel) {
		
		settings = new JMenu ("Settings");
		
		AddPlayer = new JMenuItem ("Add player");
		RemovePlayer = new JMenuItem ("Remove player");
	    PlaceBet = new JMenuItem ("Place Bet");
		ResetBet = new JMenuItem ("Reset Bet");
		Exit = new JMenuItem ("Exit");
		
		settings.add(AddPlayer);
		settings.add(RemovePlayer);
		settings.add(PlaceBet);
		settings.add(ResetBet);
		settings.add(Exit);
		
		AddPlayer.addActionListener(new AddPlayerListener(gameEngine, toolBar, summaryPanel));
		RemovePlayer.addActionListener (new RemovePlayerListener(gameEngine, toolBar, summaryPanel));
		PlaceBet.addActionListener(new PlaceBetListener(gameEngine, toolBar, summaryPanel));
		ResetBet.addActionListener(new ResetBetListener(gameEngine, toolBar, summaryPanel));
		Exit.addActionListener(new ExitListener(gameEngine));
		
		this.add(settings);
		
	}
	
	public JMenuItem getPlaceBet () {
		return this.PlaceBet;
	}
	
	public JMenuItem getResetBet () {
		return this.ResetBet;
	}
	
	public void SetEnableButtons (boolean enable) {
		this.PlaceBet.setEnabled(enable);
		this.ResetBet.setEnabled(enable);
	}

}
