/**
 * This is the summary panel class that shows the summary panel on the right of the frame.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class DiceGameSummaryPanel extends JPanel {

	private DefaultTableModel summaryInfo = new DefaultTableModel();
    private JTable summaryTable = new JTable(summaryInfo);
    private JScrollPane scrollPane;
    private DiceGameFrame frame;
	
	public DiceGameSummaryPanel (GameEngine gameEngine, DiceGameFrame frame) {
		
		this.frame = frame;
		scrollPane = new JScrollPane(summaryTable);
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(1), "Summary Panel", TitledBorder.CENTER, TitledBorder.TOP));
		
		summaryInfo.addColumn("ID");
		summaryInfo.addColumn("Name");
		summaryInfo.addColumn("Points");
		summaryInfo.addColumn("Bet");
		summaryInfo.addColumn("Status");
		
		this.add(scrollPane, BorderLayout.CENTER);
		Add(gameEngine);
		this.setVisible(true);
	}
	
	public void Add (GameEngine gameEngine) {

		summaryInfo.getDataVector().removeAllElements();

		for (Player addPlayer : gameEngine.getAllPlayers()) {
			summaryInfo.addRow(new Object [] {addPlayer.getPlayerId(),addPlayer.getPlayerName(),addPlayer.getPoints(),
			addPlayer.getBet()});
		}	
	}
	
	public void refreshAfterRoll (GameEngine gameEngine) {
		String status = null;
		
		summaryInfo.getDataVector().removeAllElements();
		
		for (Player addPlayer : gameEngine.getAllPlayers()) {
			for (int i = 0; i < frame.getViewModel().getAllPoints().size(); i++) {
					
					if (addPlayer.getPoints() > frame.getViewModel().getAllPoints().get(i)) {
						status = "Won";
					} else if (addPlayer.getPoints() < frame.getViewModel().getAllPoints().get(i)){
						status = "Lost";
					} else if (addPlayer.getPoints() == frame.getViewModel().getAllPoints().get(i)) {
						status = "Tie";
					}
			}
			summaryInfo.addRow(new Object [] {addPlayer.getPlayerId(),addPlayer.getPlayerName(),addPlayer.getPoints(),
			addPlayer.getBet(), status});
	    }
	}
}
