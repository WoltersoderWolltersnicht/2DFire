package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VMainWindow extends JFrame {
	
	public JPanel panelDraw;
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
		
		panelDraw = new VDrawPanel();
		panelDraw.setBounds(0, 0, 810, 522);
		getContentPane().add(panelDraw);
		
		panelControl = new JPanel();
		panelControl.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelControl.setBounds(10, 533, 800, 48);
		getContentPane().add(panelControl);
		panelControl.setLayout(null);
		
		slider = new JSlider();
		slider.setValue(500);
		slider.setMaximum(1500);
		slider.setBounds(10, 11, 785, 26);
		panelControl.add(slider);
		
		btnRedFire = new JButton("Red");
		btnRedFire.setBounds(20, 592, 238, 33);
		getContentPane().add(btnRedFire);
		
		btnBlueFire = new JButton("Blue");
		btnBlueFire.setBounds(296, 592, 238, 33);
		getContentPane().add(btnBlueFire);
		
		JButton btnRandomFire = new JButton("Random");
		btnRandomFire.setBounds(569, 592, 238, 33);
		getContentPane().add(btnRandomFire);
		
				
	}   
}
