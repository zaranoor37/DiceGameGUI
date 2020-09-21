/**
 * This is the dice panel of the gui game, that shows all the dice and also their rolls.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class DiceGamePanel extends JPanel {
	
	@SuppressWarnings("unused")
	private GameEngine gameEngine;
	private int die1Value;
	private int die2Value;
	private JLabel Ldie1 = new JLabel();
	private JLabel Ldie2 = new JLabel();

	public DiceGamePanel (GameEngine gameEngine) {
		this.gameEngine = gameEngine;

		add(Ldie1);
		add(Ldie2);
		
		images(6, Ldie1);
		images(5, Ldie2);

	}
	
	public void images (int no, JLabel Ldie) {
		switch (no) {
		
		case 1:

		ImageIcon die1 = new ImageIcon ("images/1.png");
		Ldie.setIcon(new ImageIcon (die1.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT)));
		break;
		
		case 2:

		ImageIcon die2 = new ImageIcon ("images/2.png");
		Ldie.setIcon(new ImageIcon (die2.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT)));
		break;
		
		case 3:

		ImageIcon die3 = new ImageIcon ("images/3.png");
		Ldie.setIcon(new ImageIcon (die3.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT)));
		break;
		
		case 4:

		ImageIcon die4 = new ImageIcon ("images/4.png");
		Ldie.setIcon(new ImageIcon (die4.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT)));
		break;
		
		case 5:

		ImageIcon die5 = new ImageIcon ("images/5.png");
		Ldie.setIcon(new ImageIcon (die5.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT)));
		break;
		
		case 6:

		ImageIcon die6 = new ImageIcon ("images/6.png");
		Ldie.setIcon(new ImageIcon (die6.getImage().getScaledInstance(150, 130, Image.SCALE_DEFAULT)));
		break;
	
		}
	}
	
	public void setDie1Value (int die1) {
		die1Value = die1;
	}
	
	public void setDie2Value (int die2) {
		die2Value = die2;
	}
	
	//This method contains two threads, representing the roll of two dices that roll together at the same time.
	public void diceUpdate(int initialDelay1, int finalDelay1, int delayIncrement1, int initialDelay2, int finalDelay2, int delayIncrement2) 
	{
	
		new Thread() {
			
			@Override
		    public void run() {
				for (int i = initialDelay1; i <= finalDelay1; i+=delayIncrement1) {

				     

							images(die1Value, Ldie1);
//							try {
//								Thread.sleep(initialDelay1);
//							} catch (InterruptedException e) {
//								e.toString();					
//						    }
						    
				}	

				    try {
						Thread.sleep(initialDelay1);
					} catch (InterruptedException e) {
						e.toString();					
				    }
			}
		 }.start();

		 new Thread() {
				
				@Override
			    public void run() {
					for (int i = initialDelay2; i <= finalDelay2; i+=delayIncrement2) {
							
								images(die2Value, Ldie2);
//								try {
//									Thread.sleep(initialDelay2);
//								} catch (InterruptedException e) {
//									e.toString();
//								}
								
					}
					
					try {
						Thread.sleep(initialDelay2);
					} catch (InterruptedException e) {
						e.toString();
					}
				}
				
			 }.start();
	}

}


