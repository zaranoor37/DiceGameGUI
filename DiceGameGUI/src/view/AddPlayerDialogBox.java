/**
 * This is the view for adding a player. It shows up a dialog box to enter the player details.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import java.awt.GridLayout;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class AddPlayerDialogBox {
	
	private String id;
	private String name; 
	private String points;
	private int parsedPoint;
	
	private JPanel pane;
	private JTextField FieldID;
	private JTextField FieldName;
	private JTextField FieldPoints;

	
	public AddPlayerDialogBox (GameEngine gameEngine, DiceGameToolBar toolBar, DiceGameSummaryPanel summaryPanel) {
		
		JFrame frame = new JFrame ();
		
		pane = new JPanel ();
		pane.setLayout(new GridLayout(0,2,2,2));
		try {
		FieldID = new JTextField (5);
		FieldName = new JTextField (5);
		FieldPoints = new JTextField (5);
		
		pane.add(new JLabel ("Enter Player ID"));
		pane.add(FieldID);
		
		pane.add(new JLabel ("Enter Player Name"));
		pane.add(FieldName);
		
		pane.add(new JLabel ("Enter Player Points"));
		pane.add(FieldPoints);
		
		int option = JOptionPane.showConfirmDialog(frame, pane, "Enter player information", JOptionPane.YES_NO_OPTION);
		
		id = FieldID.getText();
		name = FieldName.getText();
		points = FieldPoints.getText();
		
		if ((FieldID.getText().isEmpty() == false && FieldName.getText().isEmpty() == false && 
				FieldPoints.getText().isEmpty() == false) && (option == JOptionPane.YES_OPTION)) {
				parsedPoint = Integer.parseInt(points);
			    Player newPlayer = new SimplePlayer (id, name, parsedPoint);
			    gameEngine.addPlayer(newPlayer);
			    toolBar.refreshContent(gameEngine);
			    summaryPanel.Add(gameEngine);
				
				JOptionPane.showMessageDialog(frame, "Player Added");
				
		} else if (option == JOptionPane.NO_OPTION || FieldID.getText().isEmpty() == true 
				|| FieldName.getText().isEmpty() == true || FieldPoints.getText().isEmpty() == true){
			
			JOptionPane.showMessageDialog(frame, "Data fields empty/entry cancelled, try again", "Error Message", 1);
		}
		
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(frame, "Inavlid Data. Player not added", "Error Message", 1);
		}
		
	}
	
}
