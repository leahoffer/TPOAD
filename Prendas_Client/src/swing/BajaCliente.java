package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import bd.BusinessDelegate;
import view.ClienteVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class BajaCliente {

	private JFrame frame;
	private JTextField textLegajo;
	private JTextField textNombre;
	private JTextField textCUIT;
	private JTextField textSaldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BajaCliente window = new BajaCliente();
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
	public BajaCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 538, 357);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBajaClientes = new JLabel("Baja Clientes");
		lblBajaClientes.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblBajaClientes.setBounds(10, 11, 179, 32);
		frame.getContentPane().add(lblBajaClientes);
		
		JLabel lblLegajo = new JLabel("Legajo");
		lblLegajo.setBounds(10, 54, 56, 20);
		frame.getContentPane().add(lblLegajo);
		
		textLegajo = new JTextField();
		textLegajo.setBounds(76, 54, 86, 20);
		frame.getContentPane().add(textLegajo);
		textLegajo.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteVO cvo = new ClienteVO();
				try
				{
					cvo = BusinessDelegate.getInstancia().mostrarCliente(Integer.parseInt(textLegajo.getText()));
					if (cvo!=null)
					{
						textNombre.setText(cvo.getNombreComercio());
						textCUIT.setText(cvo.getCuit());
						textSaldo.setText(String.valueOf(cvo.getCuenta().getSaldo()));
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No se encontró el cliente");
					}
				}
				catch (RemoteException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(20, 206, 89, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				try
				{
					ClienteVO cvo = new ClienteVO();
					cvo.setLegajo(Integer.parseInt(textLegajo.getText()));
					BusinessDelegate.getInstancia().eliminarCliente(cvo);
					JOptionPane.showMessageDialog(null, "Se eliminó el cliente");
				}
				catch (RemoteException e1)
				{
					e1.printStackTrace();
				}
			}
		});
		btnConfirmar.setBounds(20, 237, 89, 23);
		frame.getContentPane().add(btnConfirmar);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 86, 56, 20);
		frame.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(76, 85, 86, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblCuit = new JLabel("CUIT");
		lblCuit.setBounds(10, 117, 46, 14);
		frame.getContentPane().add(lblCuit);
		
		textCUIT = new JTextField();
		textCUIT.setBounds(76, 116, 86, 20);
		frame.getContentPane().add(textCUIT);
		textCUIT.setColumns(10);
		
		JLabel lblSaldo = new JLabel("Saldo");
		lblSaldo.setBounds(10, 150, 46, 14);
		frame.getContentPane().add(lblSaldo);
		
		textSaldo = new JTextField();
		textSaldo.setBounds(76, 147, 86, 20);
		frame.getContentPane().add(textSaldo);
		textSaldo.setColumns(10);
	}
}
