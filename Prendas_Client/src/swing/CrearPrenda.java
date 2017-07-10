package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import businessdelegate.BusinessDelegate;
import vos.PrendaGenericaVO;
import vos.PrendaVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class CrearPrenda {

	private JFrame frmCrearPrenda;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtCantTalle;
	private JTextField txtCantColor;

	/**
	 * Launch the application.
	 */
	public static void NuevaPrenda() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearPrenda window = new CrearPrenda();
					window.frmCrearPrenda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrearPrenda() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrearPrenda = new JFrame();
		frmCrearPrenda.setTitle("Crear Prenda");
		frmCrearPrenda.setBounds(100, 100, 534, 517);
		frmCrearPrenda.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCrearPrenda.getContentPane().setLayout(null);
		
		JLabel lblCrearPrenda = new JLabel("Crear Prenda");
		lblCrearPrenda.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCrearPrenda.setBounds(200, 11, 143, 25);
		frmCrearPrenda.getContentPane().add(lblCrearPrenda);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(10, 63, 137, 14);
		frmCrearPrenda.getContentPane().add(lblCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setBounds(10, 88, 137, 14);
		frmCrearPrenda.getContentPane().add(lblDescripcion);
		
		JLabel lblCantTalle = new JLabel("Cantidad a Producir (Talle):");
		lblCantTalle.setBounds(10, 113, 137, 14);
		frmCrearPrenda.getContentPane().add(lblCantTalle);
		
		JLabel lblCantColor = new JLabel("Cantidad a Producir (Color):");
		lblCantColor.setBounds(10, 138, 137, 14);
		frmCrearPrenda.getContentPane().add(lblCantColor);
		
		JLabel lblColores = new JLabel("Colores:");
		lblColores.setBounds(10, 178, 86, 14);
		frmCrearPrenda.getContentPane().add(lblColores);
		
		JCheckBox chckbxNegro = new JCheckBox("Negro");
		chckbxNegro.setBounds(10, 199, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxNegro);
		
		JCheckBox chckbxBlanco = new JCheckBox("Blanco");
		chckbxBlanco.setBounds(10, 225, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxBlanco);
		
		JCheckBox chckbxRojo = new JCheckBox("Rojo");
		chckbxRojo.setBounds(10, 255, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxRojo);
		
		JCheckBox chckbxVerde = new JCheckBox("Verde");
		chckbxVerde.setBounds(10, 281, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxVerde);
		
		JCheckBox chckbxAzul = new JCheckBox("Azul");
		chckbxAzul.setBounds(10, 307, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxAzul);
		
		JCheckBox chckbxEstampado = new JCheckBox("Estampado");
		chckbxEstampado.setBounds(10, 333, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxEstampado);
		
		JLabel lblTalles = new JLabel("Talles");
		lblTalles.setBounds(117, 178, 46, 14);
		frmCrearPrenda.getContentPane().add(lblTalles);
		
		JCheckBox chckbxXS = new JCheckBox("XS");
		chckbxXS.setBounds(117, 199, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxXS);
		
		JCheckBox chckbxS = new JCheckBox("S");
		chckbxS.setBounds(117, 229, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxS);
		
		JCheckBox chckbxM = new JCheckBox("M");
		chckbxM.setBounds(117, 255, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxM);
		
		JCheckBox chckbxL = new JCheckBox("L");
		chckbxL.setBounds(117, 281, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxL);
		
		JCheckBox chckbxXl = new JCheckBox("XL");
		chckbxXl.setBounds(117, 307, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxXl);
		
		JCheckBox chckbxXxl = new JCheckBox("XXL");
		chckbxXxl.setBounds(117, 333, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxXxl);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(157, 60, 86, 20);
		frmCrearPrenda.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(157, 85, 86, 20);
		frmCrearPrenda.getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtCantTalle = new JTextField();
		txtCantTalle.setBounds(157, 110, 86, 20);
		frmCrearPrenda.getContentPane().add(txtCantTalle);
		txtCantTalle.setColumns(10);
		
		txtCantColor = new JTextField();
		txtCantColor.setBounds(157, 135, 86, 20);
		frmCrearPrenda.getContentPane().add(txtCantColor);
		txtCantColor.setColumns(10);
		
		JButton btnCrearPrenda = new JButton("Crear Prenda");
		btnCrearPrenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrendaGenericaVO pgvo = new PrendaGenericaVO();
				List<String> colores = new ArrayList<String>();
				List<String> talles = new ArrayList<String>();
				if (chckbxNegro.isSelected())
					colores.add("Negro");
				if(chckbxBlanco.isSelected())
					colores.add("Blanco");
				if(chckbxRojo.isSelected())
					colores.add("Rojo");
				if(chckbxVerde.isSelected())
					colores.add("Verde");
				if(chckbxAzul.isSelected())
					colores.add("Azul");
				if(chckbxEstampado.isSelected())
					colores.add("Estampado");
				if(chckbxXS.isSelected())
					talles.add("XS");
				if(chckbxS.isSelected())
					talles.add("S");
				if(chckbxM.isSelected())
					talles.add("M");
				if(chckbxL.isSelected())
					talles.add("L");
				if(chckbxXl.isSelected())
					talles.add("XL");
				if(chckbxXxl.isSelected())
					talles.add("XXL");
				pgvo.setCodigo(txtCodigo.getText());
				pgvo.setDescripcion(txtDescripcion.getText());
				pgvo.setCantColor(Integer.parseInt(txtCantColor.getText()));
				pgvo.setCantTalle(Integer.parseInt(txtCantTalle.getText()));
				pgvo.setColores(colores);
				pgvo.setTalles(talles);
				
				if(!talles.isEmpty() && !colores.isEmpty())
				{
					for(String talle : talles)
					{
						for(String color : colores)
						{
							PrendaVO pvo = new PrendaVO();
							pvo.setColor(color);
							pvo.setEnProduccion(true);
							pvo.setPrenda(pgvo);
							pvo.setTalle(talle);
							try {
								BusinessDelegate.getInstancia().nuevaPrenda(pvo);
								System.out.println("Se creó la prenda " + pgvo.getDescripcion() + " " + talle + " " + color);
							} catch (RemoteException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					JOptionPane.showMessageDialog(null, "Se crearon todas las prendas", "Creación exitosa", JOptionPane.INFORMATION_MESSAGE);
					frmCrearPrenda.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No se escogió ningun talle o color", "Error talle o color", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCrearPrenda.setBounds(10, 416, 116, 23);
		frmCrearPrenda.getContentPane().add(btnCrearPrenda);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmCrearPrenda.dispose();
			}
		});
		btnCancelar.setBounds(10, 450, 116, 23);
		frmCrearPrenda.getContentPane().add(btnCancelar);
	}
}
