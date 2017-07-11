package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import businessdelegate.BusinessDelegate;
import vos.InsumoVO;
import vos.ItemRecetaVO;
import vos.PrendaGenericaVO;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class AgregarInsumos {

	private JFrame frame;
	private JTextField textField_cant;
	private JTextField textField_desperdicio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarInsumos window = new AgregarInsumos();
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
	public AgregarInsumos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		

		List<InsumoVO> insumos = new ArrayList<InsumoVO>();
		List<PrendaGenericaVO> prendasg= new ArrayList<PrendaGenericaVO>();
		try {
			
			insumos = BusinessDelegate.getInstancia().mostrarInsumos();
			prendasg= BusinessDelegate.getInstancia().mostrarPrendas();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		frame = new JFrame();
		frame.setBounds(100, 100, 264, 245);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField_cant = new JTextField();
		textField_cant.setBounds(109, 71, 121, 20);
		frame.getContentPane().add(textField_cant);
		textField_cant.setColumns(10);
		
		JComboBox<InsumoVO> cbInsumos = new JComboBox<InsumoVO>();
		cbInsumos.setBounds(109, 40, 121, 20);
		frame.getContentPane().add(cbInsumos);
		for(InsumoVO ivo : insumos)
			cbInsumos.addItem(ivo);
		
		JComboBox<PrendaGenericaVO> cb_prendas = new JComboBox<PrendaGenericaVO>();
		cb_prendas.setBounds(109, 11, 121, 20);
		frame.getContentPane().add(cb_prendas);
		for(PrendaGenericaVO pvo: prendasg)
		{
			cb_prendas.addItem(pvo);
		}
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					ItemRecetaVO iro = new ItemRecetaVO();
					iro.setCantidad(Float.parseFloat(textField_cant.getText()));
					iro.setDesperdicio(Float.parseFloat(textField_desperdicio.getText()));
					iro.setInsumo((InsumoVO) cbInsumos.getSelectedItem());
					BusinessDelegate.getInstancia().agregarItemReceta(iro, (PrendaGenericaVO) cb_prendas.getSelectedItem());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAgregar.setBounds(141, 133, 89, 23);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnFinalizar.setBounds(141, 162, 89, 23);
		frame.getContentPane().add(btnFinalizar);
		
		textField_desperdicio = new JTextField();
		textField_desperdicio.setColumns(10);
		textField_desperdicio.setBounds(109, 102, 121, 20);
		frame.getContentPane().add(textField_desperdicio);
		
		JLabel lblPrenda = new JLabel("Prenda");
		lblPrenda.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrenda.setBounds(10, 13, 72, 14);
		frame.getContentPane().add(lblPrenda);
		
		JLabel lblInsumo = new JLabel("Insumo");
		lblInsumo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInsumo.setBounds(10, 42, 72, 14);
		frame.getContentPane().add(lblInsumo);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(10, 73, 72, 14);
		frame.getContentPane().add(lblCantidad);
		
		JLabel lblDesperdicio = new JLabel("Desperdicio");
		lblDesperdicio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesperdicio.setBounds(10, 104, 72, 14);
		frame.getContentPane().add(lblDesperdicio);
		
		
		
	
		
	}
}
