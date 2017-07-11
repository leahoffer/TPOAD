package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import vos.DetalleAreaVO;
import vos.PrendaGenericaVO;
import vos.PrendaVO;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AgregarDetalleArea {

	private JFrame frame;
	private JTextField txtDuracion;

	/**
	 * Launch the application.
	 */
	public static void NuevoAgregarDAVentana(PrendaGenericaVO pvo, List<DetalleAreaVO> detalles) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgregarDetalleArea window = new AgregarDetalleArea(pvo, detalles);
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
	public AgregarDetalleArea(PrendaGenericaVO pvo, List<DetalleAreaVO> detalles) {
		initialize(pvo, detalles);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(PrendaGenericaVO pvo, List<DetalleAreaVO> detalles) {
			
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(106, 114, 154, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("Marcado");
		comboBox.addItem("Corte");
		comboBox.addItem("Habilitado");
		comboBox.addItem("Costura");
		comboBox.addItem("Estampado");
		comboBox.addItem("Acabado");
		comboBox.addItem("Planchado");
		comboBox.addItem("Empacado");
		
		JLabel lblArea = new JLabel("Area:");
		lblArea.setBounds(10, 117, 46, 14);
		frame.getContentPane().add(lblArea);
		
		JLabel lblDuracion = new JLabel("Duraci\u00F3n (hs):");
		lblDuracion.setBounds(10, 148, 86, 14);
		frame.getContentPane().add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(106, 145, 86, 20);
		frame.getContentPane().add(txtDuracion);
		txtDuracion.setColumns(10);
		
		JLabel lblAgregarDetallesDe = new JLabel("Agregar Detalles de \u00C1rea de Producci\u00F3n");
		lblAgregarDetallesDe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAgregarDetallesDe.setBounds(69, 11, 338, 26);
		frame.getContentPane().add(lblAgregarDetallesDe);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetalleAreaVO davo = new DetalleAreaVO();
				davo.setArea((String) comboBox.getSelectedItem());
				davo.setDuracion(Float.parseFloat(txtDuracion.getText()));
				detalles.add(davo);
			}
		});
		btnAgregar.setBounds(10, 233, 86, 23);
		frame.getContentPane().add(btnAgregar);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				
			}
		});
		btnFinalizar.setBounds(106, 233, 89, 23);
		frame.getContentPane().add(btnFinalizar);
		
		JLabel lblTitulo = new JLabel("Prenda: " + pvo.getDescripcion());
		lblTitulo.setBounds(10, 89, 205, 14);
		frame.getContentPane().add(lblTitulo);
	}
}
