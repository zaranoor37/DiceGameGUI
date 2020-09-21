/**
 * This is the view for the toolbar of the dice game.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import controller.RollListener;
import controller.SelectPlayerListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class DiceGameToolBar extends JToolBar  {
	
	@SuppressWarnings("unused")
	private GameEngine gameEngine;
	private JComboBox <String> list;
	@SuppressWarnings("unused")
	private String selected;
	private JButton rollButton;
	
	public DiceGameToolBar (GameEngine gameEngine, DiceGameFrame frame ,DiceGameDiceStatuses status, DiceGamePanel dicePanel, DiceGameSummaryPanel summaryPanel ) {
		
		this.gameEngine = gameEngine;
		rollButton = new JButton ("Roll");
		rollButton.setEnabled(false);
		list = new JComboBox <String>();
		add(rollButton);
		AddPlayer(gameEngine);
		rollButton.addActionListener(new RollListener(gameEngine, frame ,dicePanel, this, summaryPanel));
		list.addItemListener(new SelectPlayerListener (frame, gameEngine, status, this));
	}
	
	public void AddPlayer (GameEngine gameEngine) {

		for (Player p : gameEngine.getAllPlayers()) {
			list.addItem(p.getPlayerId());
		}
		add(list);
	
	}
	
	public void refreshContent (GameEngine gameEngine) {
		list.removeAllItems();
		AddPlayer(gameEngine);
	}
	
	public JComboBox <String> getList(){
		
		return this.list;
	}
	
	public void setSelected (String select) {
		this.selected = select;
	}
	
	public String getSelectedPlayer (String selectedPlayer) {
		return selectedPlayer;
	}
	
	public String getSelected () {
		 return this.list.getSelectedItem().toString();
	}
	
	public void enableRoll (Boolean set) {
		this.rollButton.setEnabled(set);
	}
}
