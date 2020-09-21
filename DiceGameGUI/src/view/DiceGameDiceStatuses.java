/**
 * This is the view for the status on the south of the frame.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import java.awt.Color;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class DiceGameDiceStatuses extends JPanel {
	
	private JLabel status1;
	private String id;
	
	public DiceGameDiceStatuses(GameEngine gameEngine) {
		
		setLayout(new GridLayout(1, 2));
		
		Border border = BorderFactory.createLineBorder(Color.gray, 1);
		
		status1 = new JLabel();
		status1.setText("Please add a player to start");
		JLabel status2 = new JLabel("Dice Game GUI APP", SwingConstants.CENTER);
		
		status1.setBorder(border);
		status2.setBorder(border);
		
		status1.setHorizontalAlignment(SwingConstants.CENTER);
		
		add(status1);
		add(status2);
	}
	
	public void updateLabel (Object id) {
		status1.setText("Settings enabled for Player ID:" + " " + id);
	}
	
	public void setLabel (String updates) {
		status1.setText(updates);
	}
	
	public void setID (Object id) {
		this.id = (String) id;
	}
	
	public String getID () {
		return this.id;
	}

}
