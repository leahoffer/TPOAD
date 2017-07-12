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
	public static void NuevoAgregarInsumoVentana(List<ItemRecetaVO> receta) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarInsumos window = new AgregarInsumos(receta);
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
	public AgregarInsumos(List<ItemRecetaVO> receta) {
		initialize(receta);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(List<ItemRecetaVO> receta) {
		
		List<String> insumosMostrados = new ArrayList<String>();
		
		List<InsumoVO> insumos = new ArrayList<InsumoVO>();
		try {
			insumos = BusinessDelegate.getInstancia().mostrarInsumos();
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
		
		JComboBox<String> cbInsumos = new JComboBox<String>();
		cbInsumos.setBounds(109, 40, 121, 20);
		frame.getContentPane().add(cbInsumos);
		for(InsumoVO ivo : insumos)
		{
			if(!insumosMostrados.contains(ivo.getNombre()))
				insumosMostrados.add(ivo.getNombre());
		}
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<InsumoVO> insumos = new ArrayList<InsumoVO>();
				try {
					insumos = BusinessDelegate.getInstancia().mostrarInsumos();
				} catch (RemoteException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				for(InsumoVO ivo : insumos)
				{
					if(ivo.getNombre().equals(cbInsumos.getSelectedItem()))
					{
						ItemRecetaVO irvo = new ItemRecetaVO();
						irvo.setCantidad(Float.parseFloat(textField_cant.getText()));
						irvo.setDesperdicio(Float.parseFloat(textField_desperdicio.getText()));
						irvo.setInsumo(ivo);
						receta.add(irvo);
					}
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
