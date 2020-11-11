package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VMainWindow extends JFrame {
	
	public JPanel panelControl;
	public JSlider slider;
	public JButton btnRedFire;
	public JButton btnBlueFire;
	public JButton btnRandomFire;
	
	/**
	 * Create the frame.
	 */
	public VMainWindow() {
		setSize(833,675);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
			
		panelControl = new JPanel();
		panelControl.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelControl.setBounds(10, 533, 800, 92);
		getContentPane().add(panelControl);
		panelControl.setLayout(null);
		
		slider = new JSlider();
		slider.setValue(500);
		slider.setMaximum(1000);
		slider.setBounds(10, 11, 785, 26);
		panelControl.add(slider);
		
		btnRedFire = new JButton("Red Fire");
		btnRedFire.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRedFire.setBounds(10, 48, 230, 33);
		panelControl.add(btnRedFire);
		
		btnBlueFire = new JButton("Blue Fire");
		btnBlueFire.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBlueFire.setBounds(284, 48, 230, 33);
		panelControl.add(btnBlueFire);
		
		btnRandomFire = new JButton("Random Fire");
		btnRandomFire.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRandomFire.setBounds(560, 48, 230, 33);
		panelControl.add(btnRandomFire);
		
				
	}   
}
