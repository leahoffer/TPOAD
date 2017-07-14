package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import businessdelegate.BusinessDelegate;
import vos.ItemPedidoPVO;
import vos.PedidoPrendaVO;

import javax.swing.JCheckBox;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class ValidarPedido {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ValidarPedido window = new ValidarPedido();
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
	public ValidarPedido() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 502, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DefaultListModel<PedidoPrendaVO> model = new DefaultListModel<PedidoPrendaVO>();
		List<PedidoPrendaVO> pedidosAValidar = new ArrayList<PedidoPrendaVO>();
		try {
			pedidosAValidar = BusinessDelegate.getInstancia().mostrarPedidosAValidar();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(PedidoPrendaVO ppvo : pedidosAValidar)
			model.addElement(ppvo);
		
		JList<PedidoPrendaVO> list = new JList<PedidoPrendaVO>();
		list.setBounds(77, 41, 321, 130);
		frame.getContentPane().add(list);
		list.setModel(model);
		
		JLabel lblValidacinDePedidos = new JLabel("Validaci\u00F3n de Pedidos");
		lblValidacinDePedidos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblValidacinDePedidos.setBounds(169, 11, 171, 19);
		frame.getContentPane().add(lblValidacinDePedidos);
		
		JButton btnValidarPedido = new JButton("Validar Pedido");
		btnValidarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					BusinessDelegate.getInstancia().validarPedido(list.getSelectedValue());
					System.out.println("Pedido validado negri.");
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnValidarPedido.setBounds(156, 182, 171, 23);
		frame.getContentPane().add(btnValidarPedido);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(156, 216, 171, 23);
		frame.getContentPane().add(btnSalir);
	}
}
