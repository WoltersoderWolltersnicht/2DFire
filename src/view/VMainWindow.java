package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JSlider;


public class VMainWindow extends JFrame {
	
	public JPanel panelDraw;
	public JPanel panelControl;
	public JSlider slider;
	
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
		panelControl.setBounds(10, 533, 800, 92);
		getContentPane().add(panelControl);
		panelControl.setLayout(null);
		
		slider = new JSlider();
		slider.setValue(500);
		slider.
		slider.setMaximum(1000);
		slider.setBounds(10, 11, 785, 26);
		panelControl.add(slider);
		
				
	}   
}
