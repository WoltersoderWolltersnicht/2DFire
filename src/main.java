import java.awt.EventQueue;

import control.CMainWindow;

/**
*
*Program that makes a frame with a variable Fire in it:
*
* @Version 1.0
* @since 11/11/2020
* 
* @author Aaron Sanchez Wolters <aaaronwolters@gmail.com><aaronsanchez@estudiante.edib.es>
* 
*/

public class main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				new CMainWindow();

			}
		});
	}
	
}
