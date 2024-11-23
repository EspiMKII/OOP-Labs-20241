/* Ex 6.1 */

import javax.swing.JOptionPane;

public class ex_6_1_ChoosingOption {
	public static void main(String[] args) {
//		int option = JOptionPane.showConfirmDialog(null, 
//					"Do you want to change to the first class ticket?");
//		overloaded showConfirmDialog example:
		int option = JOptionPane.showConfirmDialog(null,
					"Do you want to change to the first class ticket?",
					"First Class Ticket Confirmation",
					JOptionPane.YES_NO_OPTION);
		JOptionPane.showMessageDialog(null, "You've chosen: "
						+ (option==JOptionPane.YES_OPTION?"Yes":"No"));
		System.exit(0);
	}
}