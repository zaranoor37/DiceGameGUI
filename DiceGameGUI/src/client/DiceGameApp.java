/**
 * This is the main driver class of the GUI game.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package client;

import javax.swing.SwingUtilities;
import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.DiceGameFrame;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

public class DiceGameApp {
	
	public static void main(String[] args){
		final GameEngine gameEngine = new GameEngineImpl();
	
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				final DiceGameFrame frame = new DiceGameFrame(gameEngine);
				
				gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(frame));
				
			}
		});
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	}

}
