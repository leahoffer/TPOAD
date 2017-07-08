package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.SwingConstants;

import bd.BusinessDelegate;
import ennumeration.IVA;
import view.ClienteVO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;

public class ABMClientes {

	private JFrame frame;
	private JTextField txt_comercio;
	private JTextField txt_direccion;
	private JTextField txt_telefono;
	private JTextField txt_cuit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMClientes window = new ABMClientes();
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
	public ABMClientes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 551, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txt_comercio = new JTextField();
		txt_comercio.setBounds(125, 52, 168, 20);
		frame.getContentPane().add(txt_comercio);
		txt_comercio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Comercio");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(32, 53, 83, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDireccion.setBounds(32, 79, 83, 19);
		frame.getContentPane().add(lblDireccion);
		
		txt_direccion = new JTextField();
		txt_direccion.setColumns(10);
		txt_direccion.setBounds(125, 78, 168, 20);
		frame.getContentPane().add(txt_direccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefono.setBounds(32, 105, 83, 19);
		frame.getContentPane().add(lblTelefono);
		
		txt_telefono = new JTextField();
		txt_telefono.setColumns(10);
		txt_telefono.setBounds(125, 104, 168, 20);
		frame.getContentPane().add(txt_telefono);
		
		JLabel lblCuit = new JLabel("CUIT");
		lblCuit.setHorizontalAlignment(SwingConstants.LEFT);
		lblCuit.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCuit.setBounds(32, 131, 83, 19);
		frame.getContentPane().add(lblCuit);
		
		txt_cuit = new JTextField();
		txt_cuit.setColumns(10);
		txt_cuit.setBounds(125, 130, 168, 20);
		frame.getContentPane().add(txt_cuit);
		
		JLabel lblIva = new JLabel("IVA");
		lblIva.setHorizontalAlignment(SwingConstants.LEFT);
		lblIva.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblIva.setBounds(32, 156, 83, 19);
		frame.getContentPane().add(lblIva);
		
		JComboBox cbox_iva = new JComboBox();
		cbox_iva.setModel(new DefaultComboBoxModel(new String[] {"Responsable Inscripto", "Monotributista", "Exento"}));
		cbox_iva.setBounds(125, 155, 168, 20);
		frame.getContentPane().add(cbox_iva);
		
		JLabel lblAbmClientes = new JLabel("Alta Clientes");
		lblAbmClientes.setHorizontalAlignment(SwingConstants.LEFT);
		lblAbmClientes.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblAbmClientes.setBounds(32, 11, 261, 30);
		frame.getContentPane().add(lblAbmClientes);
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(374, 186, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JLabel lblLimite = new JLabel("Limite inicial");
		lblLimite.setHorizontalAlignment(SwingConstants.LEFT);
		lblLimite.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLimite.setBounds(306, 155, 83, 19);
		frame.getContentPane().add(lblLimite);
		
		JSpinner sp_limite = new JSpinner();
		sp_limite.setBounds(399, 157, 64, 18);
		frame.getContentPane().add(sp_limite);
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ClienteVO c= new ClienteVO();
				c.setNombreComercio(txt_comercio.getText());
				c.setDireccion(txt_direccion.getText());
				c.setTelefono(txt_telefono.getText());
				if (cbox_iva.getSelectedItem().toString().equals("Responsable Inscripto"))
					c.setIva(IVA.ResponsableInscripto);
				else if (cbox_iva.getSelectedItem().toString().equals("Monotributista"))
					c.setIva(IVA.Monotributista);
				else
					c.setIva(IVA.Exento);
				try {
					BusinessDelegate.getInstancia().nuevoCliente(c, Float.parseFloat(sp_limite.getValue().toString()));
					JOptionPane.showMessageDialog(null, "Se cargó el cliente");
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
