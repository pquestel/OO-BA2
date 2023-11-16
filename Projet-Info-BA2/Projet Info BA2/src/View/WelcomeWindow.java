package View;
import javax.swing.JFrame;

public class WelcomeWindow  extends JFrame{

		/*constructeur*/
		public WelcomeWindow(){
			super("Into the Pyramids");
			this.setSize(300, 300);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}
}
