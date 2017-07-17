package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;

import businessdelegate.BusinessDelegate;
import vos.PedidoInsumoVO;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CompletarPedidoInsumo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CompletarPedidoInsumo window = new CompletarPedidoInsumo();
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
	public CompletarPedidoInsumo() {
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
		
		JLabel lblCompletarPedidoDe = new JLabel("Completar Pedido De Insumos");
		lblCompletarPedidoDe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCompletarPedidoDe.setBounds(89, 11, 240, 19);
		frame.getContentPane().add(lblCompletarPedidoDe);
		
		DefaultListModel<PedidoInsumoVO> model = new DefaultListModel<PedidoInsumoVO>();
		List<PedidoInsumoVO> pedidosACompletar = new ArrayList<PedidoInsumoVO>();
		try {
			pedidosACompletar = BusinessDelegate.getInstancia().traerTodosLosPedidosI();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(PedidoInsumoVO pivo : pedidosACompletar)
		{
			model.addElement(pivo);
			System.out.println(pivo.toString());
		}
		JList<PedidoInsumoVO> list = new JList<PedidoInsumoVO>();
		list.setBounds(89, 66, 240, 124);
		frame.getContentPane().add(list);
		
		JButton btnCompletarPedido = new JButton("Completar Pedido");
		btnCompletarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PedidoInsumoVO pivo = list.getSelectedValue();
				try {
					BusinessDelegate.getInstancia().completarPedidoInsumo(pivo);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnCompletarPedido.setBounds(89, 201, 240, 23);
		frame.getContentPane().add(btnCompletarPedido);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnSalir.setBounds(89, 227, 240, 23);
		frame.getContentPane().add(btnSalir);
	}
}
