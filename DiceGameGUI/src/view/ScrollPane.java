/**
 * This is the scrollpane class that shows up a scrollpane when a player is needed to be removed.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import java.util.Iterator;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;


import controller.ScrollPaneListener;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class ScrollPane {
	
	private Player p;
	private JScrollPane pane;
	private DefaultListModel <String> listModel;
	private JList <String> list;

	public ScrollPane (GameEngine gameEngine, DiceGameToolBar toolBar, DiceGameSummaryPanel summaryPanel)  {
		
		JFrame frame = new JFrame ();
		
		frame.setTitle("Select Player");
		frame.setSize(500,300);
		
		listModel = new DefaultListModel <String>();
		
		@SuppressWarnings("rawtypes")
		Iterator it = gameEngine.getAllPlayers().iterator();
		do {
			p = (Player) it.next();
			listModel.addElement(p.getPlayerId());
		} while (it.hasNext());
		
		list = new JList <String> (listModel);
		list.addMouseListener(new ScrollPaneListener(this, gameEngine, toolBar, summaryPanel));
		
		pane = new JScrollPane (list);
		
		frame.add(pane);
		frame.setVisible(true);
	}
	
	@SuppressWarnings("rawtypes")
	public JList getList () {
		return this.list;
	}
	
	public void removeP(String player) {
		listModel.removeElement(player);
	}

}
