/**
 * This is the dialog box class that shows different confirmation dialog box.
 * 
 * @author Zara Noor (s3804936)
 * @since 2020-06-19
 * 
 */

package view;

import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class SettingsDialogBox {
	
	private JPanel pane = new JPanel ();
	
	public void removeConfirm () {

		pane.setLayout(new GridLayout(0,2,2,2));
		
		JOptionPane.showMessageDialog(null, "Player Removed!");
		pane.setVisible(true);
	}
	
	public void resetBetConfirm () {
		
		pane.setLayout(new GridLayout(0,2,2,2));
		
		JOptionPane.showMessageDialog(null, "Player bet has been resetted!");
		pane.setVisible(true);
	}
	
	public void houseRoll () {
        pane.setLayout(new GridLayout(0,2,2,2));
		
		JOptionPane.showMessageDialog(null, "The House is now ready to roll");
		pane.setVisible(true);
	}
	
}
