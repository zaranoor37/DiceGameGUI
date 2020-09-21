/**
 * This is the place bet dialog box view class that opens up when a player wants to place a bet from the menu.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class PlaceBetDialogBox {
	
	
	public PlaceBetDialogBox (GameEngine gameEngine, DiceGameToolBar toolBar, DiceGameSummaryPanel summaryPanel) {
		
		JPanel pane = new JPanel ();
		pane.setLayout(new GridLayout(0,2,2,2));
		try {
		JTextField FieldBet = new JTextField (5);
		
		pane.add(new JLabel ("Enter amount of bet to place:"));
		pane.add(FieldBet);

		int option = JOptionPane.showConfirmDialog(null, pane, "Enter player information", JOptionPane.YES_NO_OPTION);
		String bet = FieldBet.getText();
		
		int parsedBet = Integer.parseInt(bet);
		
		Player p = gameEngine.getPlayer(toolBar.getSelected());
		
		if (FieldBet.getText().isEmpty() == false && (option == JOptionPane.YES_OPTION)) {
			boolean state = gameEngine.placeBet(p, parsedBet);
			summaryPanel.Add(gameEngine);
			if (state == true){
				JOptionPane.showMessageDialog(null, "Player bet has been placed!");
				toolBar.enableRoll(true);	
		    } else if (FieldBet.getText().isEmpty() == true || option == JOptionPane.NO_OPTION || state == false) {
			JOptionPane.showMessageDialog(null, "Player bet not placed.");
		    }
		}
		}catch (NumberFormatException e) {
			
			JOptionPane.showMessageDialog(null, "Incorrect details added, try again.");
		}
	}
		
}
