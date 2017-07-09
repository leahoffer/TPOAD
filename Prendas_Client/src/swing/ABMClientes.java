package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ABMClientes {

	private JFrame frmAbmClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMClientes window = new ABMClientes();
					window.frmAbmClientes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ABMClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAbmClientes = new JFrame();
		frmAbmClientes.setTitle("ABM Clientes");
		frmAbmClientes.setBounds(100, 100, 416, 260);
		frmAbmClientes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAbmClientes.getContentPane().setLayout(null);
		
		JLabel lblAbmClientes = new JLabel("ABM Clientes");
		lblAbmClientes.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblAbmClientes.setBounds(111, 11, 171, 31);
		frmAbmClientes.getContentPane().add(lblAbmClientes);
		
		JButton btnCrearCliente = new JButton("Crear Cliente");
		btnCrearCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CrearCliente.NuevoCliente();
			}
		});
		btnCrearCliente.setBounds(111, 53, 171, 23);
		frmAbmClientes.getContentPane().add(btnCrearCliente);
		
		JButton btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.setBounds(111, 87, 171, 23);
		frmAbmClientes.getContentPane().add(btnEliminarCliente);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmAbmClientes.dispose();
			}
		});
		btnNewButton.setBounds(111, 187, 171, 23);
		frmAbmClientes.getContentPane().add(btnNewButton);
	}
}
