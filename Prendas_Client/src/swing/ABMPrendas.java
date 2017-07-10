package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMPrendas {

	private JFrame frmAbmPrendas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMPrendas window = new ABMPrendas();
					window.frmAbmPrendas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ABMPrendas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbmPrendas = new JFrame();
		frmAbmPrendas.setTitle("ABM Prendas");
		frmAbmPrendas.setBounds(100, 100, 450, 300);
		frmAbmPrendas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAbmPrendas.getContentPane().setLayout(null);
		
		JLabel lblAbmPrendas = new JLabel("ABM Prendas");
		lblAbmPrendas.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAbmPrendas.setBounds(131, 11, 172, 24);
		frmAbmPrendas.getContentPane().add(lblAbmPrendas);
		
		JButton btnNewButton = new JButton("Crear Prenda");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearPrenda.NuevaPrenda();
			}
		});
		btnNewButton.setBounds(131, 46, 172, 23);
		frmAbmPrendas.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAbmPrendas.dispose();
			}
		});
		btnNewButton_1.setBounds(131, 227, 172, 23);
		frmAbmPrendas.getContentPane().add(btnNewButton_1);
	}

}
