/**
 * This is the controller for exiting the game, from the menu.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;

public class ExitListener implements ActionListener {
	
	@SuppressWarnings("unused")
	private GameEngine gameEngine;
	
	public ExitListener (GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}

}
