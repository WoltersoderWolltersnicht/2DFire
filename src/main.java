import java.awt.EventQueue;

import control.CMainWindow;

public class main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				new CMainWindow();

			}
		});
	}
	
}
