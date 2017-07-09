package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import businessdelegate.BusinessDelegate;
import vos.ClienteVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class EliminarCliente {

	private JFrame frame;
	private JTextField txtLegajo;
	private JTextField txtRS;
	private ClienteVO cvo;

	/**
	 * Launch the application.
	 */
	public static void BajaCliente() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminarCliente window = new EliminarCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EliminarCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEliminarCliente = new JLabel("Eliminar Cliente");
		lblEliminarCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEliminarCliente.setBounds(131, 11, 173, 25);
		frame.getContentPane().add(lblEliminarCliente);
		
		JLabel lblLegajo = new JLabel("Legajo:");
		lblLegajo.setBounds(10, 68, 76, 14);
		frame.getContentPane().add(lblLegajo);
		
		txtLegajo = new JTextField();
		txtLegajo.setToolTipText("");
		txtLegajo.setBounds(96, 62, 86, 20);
		frame.getContentPane().add(txtLegajo);
		txtLegajo.setColumns(10);
		
		JLabel lblRazonSocial = new JLabel("Razon Social:");
		lblRazonSocial.setBounds(10, 99, 76, 14);
		frame.getContentPane().add(lblRazonSocial);
		
		txtRS = new JTextField();
		txtRS.setEditable(false);
		txtRS.setBounds(96, 93, 86, 20);
		frame.getContentPane().add(txtRS);
		txtRS.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					cvo = BusinessDelegate.getInstancia().buscarClienteVO(Integer.parseInt(txtLegajo.getText()));
					txtRS.setText(cvo.getNombreComercio());
				}
				catch (RemoteException re)
				{
					JOptionPane.showMessageDialog(null, "Error al buscar Cliente", "Error en buscar", JOptionPane.ERROR_MESSAGE);
					re.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(10, 154, 103, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					BusinessDelegate.getInstancia().eliminarCliente(cvo);
					JOptionPane.showMessageDialog(null, "El cliente fue eliminado", "Cliente eliminado", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				}
				catch (RemoteException re)
				{
					JOptionPane.showMessageDialog(null, "Error al eliminar Cliente", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
					frame.dispose();
				}
			}
		});
		btnConfirmar.setBounds(123, 154, 103, 23);
		frame.getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(236, 154, 103, 23);
		frame.getContentPane().add(btnCancelar);
	}

}
