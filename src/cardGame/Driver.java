package cardGame;

public class Driver {
	public static void main(String[] args) {
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		@Override
		    public void run() {
		    Interface.createAndShowGUI();
		}//run
		}); // while
}
}
