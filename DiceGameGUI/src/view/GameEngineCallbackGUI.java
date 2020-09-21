/**
 * This is the callback class that is added to the callback collection. It updates the view.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.Die;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback{
	
	private DiceGameFrame frame;
	private final int  initialDelay1 = 100;
	private final int finalDelay1 = 1000;
	private final int delayIncrement1 = 100;
	private final int initialDelay2 = 50;
	private final int finalDelay2 = 500;
	private final int delayIncrement2 = 50;
	
	public GameEngineCallbackGUI (DiceGameFrame frame) {
		this.frame = frame;
	}

	@Override
	public void playerDieUpdate(Player player, Die die, GameEngine gameEngine) {
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				
				if (die.getNumber() == 1) {
					frame.getDicePanel().setDie1Value(die.getValue());
				} else if (die.getNumber() == 2) {
					frame.getDicePanel().setDie2Value(die.getValue());
				}
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					e.toString();
//				}
		 frame.getDicePanel().diceUpdate(initialDelay1,finalDelay1,delayIncrement1,initialDelay2,finalDelay2,delayIncrement2);
				
		    }
		 });
	}

	@Override
	public void houseDieUpdate(Die die, GameEngine gameEngine) {
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				if (die.getNumber() == 1) {
					frame.getDicePanel().setDie1Value(die.getValue());
				} else if (die.getNumber() == 2) {
					frame.getDicePanel().setDie2Value(die.getValue());
				}
//				try {
//					Thread.sleep(200);
//				} catch (InterruptedException e) {
//					e.toString();
//				}
		frame.getDicePanel().diceUpdate(initialDelay1,finalDelay1,delayIncrement1,initialDelay2,finalDelay2,delayIncrement2);

		    }
		 });
	}

	@Override
	public void playerResult(Player player, DicePair result, GameEngine gameEngine) {
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {
				
				String pResults = (player.getPlayerName() + " *RESULT* " + result.toString());
				frame.getStatusBar().setLabel(pResults);
		    }
		 });
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run() {

				String hResults = ("House *RESULT*: " + result.toString());
				frame.getStatusBar().setLabel(hResults);
		    }
		 });
	}

}
