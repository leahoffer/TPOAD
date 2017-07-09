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

public class CrearCliente {

	private JFrame frame;
	private JTextField txtLegajo;
	private JTextField txtRS;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtCUIT;
	private JTextField txtLimiteCredito;
	private JTextField txtConsignacion;

	/**
	 * Launch the application.
	 */
	public static void NuevoCliente() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCliente window = new CrearCliente();
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
	public CrearCliente() {
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
		
		JLabel lblCrearCliente = new JLabel("Crear Cliente");
		lblCrearCliente.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCrearCliente.setBounds(145, 11, 144, 25);
		frame.getContentPane().add(lblCrearCliente);
		
		JLabel lblLegajo = new JLabel("Legajo:");
		lblLegajo.setBounds(10, 59, 79, 14);
		frame.getContentPane().add(lblLegajo);
		
		JLabel lblRazonSocial = new JLabel("Raz\u00F3n Social:");
		lblRazonSocial.setBounds(10, 84, 79, 14);
		frame.getContentPane().add(lblRazonSocial);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setBounds(10, 109, 79, 14);
		frame.getContentPane().add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono:");
		lblTelefono.setBounds(10, 134, 79, 14);
		frame.getContentPane().add(lblTelefono);
		
		JLabel lblCuit = new JLabel("CUIT:");
		lblCuit.setBounds(10, 159, 79, 14);
		frame.getContentPane().add(lblCuit);
		
		JLabel lblLimiteCredito = new JLabel("L\u00EDmite Cr\u00E9dito:");
		lblLimiteCredito.setBounds(10, 184, 79, 14);
		frame.getContentPane().add(lblLimiteCredito);
		
		JLabel lblConsignacion = new JLabel("Consignaci\u00F3n:");
		lblConsignacion.setBounds(10, 209, 79, 14);
		frame.getContentPane().add(lblConsignacion);
		
		txtLegajo = new JTextField();
		txtLegajo.setBounds(99, 56, 86, 20);
		frame.getContentPane().add(txtLegajo);
		txtLegajo.setColumns(10);
		
		txtRS = new JTextField();
		txtRS.setBounds(99, 81, 86, 20);
		frame.getContentPane().add(txtRS);
		txtRS.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(99, 106, 86, 20);
		frame.getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(99, 131, 86, 20);
		frame.getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCUIT = new JTextField();
		txtCUIT.setBounds(99, 156, 86, 20);
		frame.getContentPane().add(txtCUIT);
		txtCUIT.setColumns(10);
		
		txtLimiteCredito = new JTextField();
		txtLimiteCredito.setBounds(99, 181, 86, 20);
		frame.getContentPane().add(txtLimiteCredito);
		txtLimiteCredito.setColumns(10);
		
		txtConsignacion = new JTextField();
		txtConsignacion.setBounds(99, 206, 86, 20);
		frame.getContentPane().add(txtConsignacion);
		txtConsignacion.setColumns(10);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClienteVO cvo = new ClienteVO();
				cvo.setConsignacion(Float.parseFloat(txtConsignacion.getText()));
				cvo.setCuit(txtCUIT.getText());
				cvo.setDireccion(txtDireccion.getText());
				cvo.setLegajo(Integer.parseInt(txtLegajo.getText()));
				cvo.setLimite(Float.parseFloat(txtLimiteCredito.getText()));
				cvo.setNombreComercio(txtRS.getText());
				cvo.setTelefono(txtTelefono.getText());
				try {
					BusinessDelegate.getInstancia().nuevoCliente(cvo);
					JOptionPane.showMessageDialog(null, "Cliente creado satisfactoriamente", "Cliente creado", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
				} catch (RemoteException e1) {
					JOptionPane.showMessageDialog(null, "Error al crear Cliente", "Error", JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
			}
		});
		btnConfirmar.setBounds(209, 227, 108, 23);
		frame.getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(327, 227, 97, 23);
		frame.getContentPane().add(btnCancelar);
	}

}
