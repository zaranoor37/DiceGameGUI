/**
 * This is the frame class that shows the entire frame as a whole.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import model.interfaces.GameEngine;


@SuppressWarnings("serial")
public class DiceGameFrame extends JFrame{

	private DiceGameToolBar toolBar;
	private DiceGameDiceStatuses status;
	private DiceGamePanel dicePanel;
	private DiceGameSummaryPanel summaryPanel;
	private DiceGameMenu menu;
	private ViewModel vm;
	
	public DiceGameFrame (GameEngine gameEngine) {
		
		super ("Dice Game GUI");
		vm = new ViewModel ();
		status = new DiceGameDiceStatuses(gameEngine);
		summaryPanel = new DiceGameSummaryPanel(gameEngine, this);
		dicePanel = new DiceGamePanel (gameEngine);
		toolBar = new DiceGameToolBar (gameEngine, this, status, dicePanel, summaryPanel);
		menu = new DiceGameMenu (gameEngine, toolBar, summaryPanel);
		
		dicePanel.setPreferredSize(new Dimension(100,600));
		summaryPanel.setPreferredSize(new Dimension(200,600));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		setJMenuBar(menu);
		
		this.add(toolBar, BorderLayout.NORTH);
		this.add(dicePanel, BorderLayout.CENTER);
		this.add(summaryPanel, BorderLayout.EAST);
		this.add(status, BorderLayout.SOUTH);
		this.setResizable(true);
		this.pack();
        this.setLocationRelativeTo(null);
		setBounds(100,100,640,480);
		setVisible(true);
		
	}
	
	public DiceGameDiceStatuses getStatusBar () {
		return this.status;
	}
	
	public DiceGamePanel getDicePanel () {
		return this.dicePanel;
	}

	public  ViewModel getViewModel () {
		return this.vm;
	}
	
	public DiceGameMenu getMenu () {
		return this.menu;
	}
	
}
