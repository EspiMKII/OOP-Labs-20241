package hust.soict.dsai.aims.screen;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import hust.soict.dsai.aims.cart.Cart;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Cart cart;
	private ControllerScreen controllerscreen;
	
	public CartScreen(Cart cart, ControllerScreen c) {
		super();
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setPreferredSize(new Dimension(1024, 768));
		this.setTitle("Cart");
		this.setVisible(true);
		pack();
		
		Platform.runLater(new Runnable(){
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().
							getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart, c);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
