package swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import businessdelegate.BusinessDelegate;
import vos.DetalleAreaVO;
import vos.InsumoVO;
import vos.ItemRecetaVO;
import vos.PrendaGenericaVO;
import vos.PrendaVO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class CrearPrenda {

	private JFrame frmCrearPrenda;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTextField txtCantTalle;
	private JTextField txtCantColor;
	private JTextField txtGanancia;
	private JTextField txtCantInsumo;
	private JTextField txtDesperdicio;
	private JTextField txtDuracion;

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
		
		List<InsumoVO> insumos = new ArrayList<InsumoVO>();
		try {
			insumos = BusinessDelegate.getInstancia().mostrarInsumos();
		} catch (RemoteException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		List<ItemRecetaVO> receta = new ArrayList<ItemRecetaVO>();
		List<DetalleAreaVO> areas = new ArrayList<DetalleAreaVO>();
		
		JLabel lblCrearPrenda = new JLabel("Crear Prenda");
		lblCrearPrenda.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCrearPrenda.setBounds(200, 11, 143, 25);
		frmCrearPrenda.getContentPane().add(lblCrearPrenda);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setBounds(10, 63, 153, 14);
		frmCrearPrenda.getContentPane().add(lblCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setBounds(10, 88, 153, 14);
		frmCrearPrenda.getContentPane().add(lblDescripcion);
		
		JLabel lblCantTalle = new JLabel("Cantidad a Producir (Talle):");
		lblCantTalle.setBounds(10, 113, 173, 14);
		frmCrearPrenda.getContentPane().add(lblCantTalle);
		
		JLabel lblCantColor = new JLabel("Cantidad a Producir (Color):");
		lblCantColor.setBounds(10, 138, 173, 14);
		frmCrearPrenda.getContentPane().add(lblCantColor);
		
		JLabel lblColores = new JLabel("Colores:");
		lblColores.setBounds(10, 184, 86, 14);
		frmCrearPrenda.getContentPane().add(lblColores);
		
		JCheckBox chckbxNegro = new JCheckBox("Negro");
		chckbxNegro.setBounds(10, 205, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxNegro);
		
		JCheckBox chckbxBlanco = new JCheckBox("Blanco");
		chckbxBlanco.setBounds(10, 231, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxBlanco);
		
		JCheckBox chckbxRojo = new JCheckBox("Rojo");
		chckbxRojo.setBounds(10, 261, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxRojo);
		
		JCheckBox chckbxVerde = new JCheckBox("Verde");
		chckbxVerde.setBounds(10, 287, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxVerde);
		
		JCheckBox chckbxAzul = new JCheckBox("Azul");
		chckbxAzul.setBounds(10, 313, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxAzul);
		
		JCheckBox chckbxEstampado = new JCheckBox("Estampado");
		chckbxEstampado.setBounds(10, 339, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxEstampado);
		
		JLabel lblTalles = new JLabel("Talles");
		lblTalles.setBounds(117, 184, 46, 14);
		frmCrearPrenda.getContentPane().add(lblTalles);
		
		JCheckBox chckbxXS = new JCheckBox("XS");
		chckbxXS.setBounds(117, 205, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxXS);
		
		JCheckBox chckbxS = new JCheckBox("S");
		chckbxS.setBounds(117, 235, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxS);
		
		JCheckBox chckbxM = new JCheckBox("M");
		chckbxM.setBounds(117, 261, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxM);
		
		JCheckBox chckbxL = new JCheckBox("L");
		chckbxL.setBounds(117, 287, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxL);
		
		JCheckBox chckbxXl = new JCheckBox("XL");
		chckbxXl.setBounds(117, 313, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxXl);
		
		JCheckBox chckbxXxl = new JCheckBox("XXL");
		chckbxXxl.setBounds(117, 339, 97, 23);
		frmCrearPrenda.getContentPane().add(chckbxXxl);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(193, 57, 86, 20);
		frmCrearPrenda.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(193, 82, 86, 20);
		frmCrearPrenda.getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtCantTalle = new JTextField();
		txtCantTalle.setBounds(193, 107, 86, 20);
		frmCrearPrenda.getContentPane().add(txtCantTalle);
		txtCantTalle.setColumns(10);
		
		txtCantColor = new JTextField();
		txtCantColor.setBounds(193, 132, 86, 20);
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
							pvo.setAreas(areas);
							/*for(ItemRecetaVO irvo : receta)
							{
								if(irvo.getInsumo().getNombre().contains("Tela"))
								{
									if(talle == "S")
										irvo.setCantidad((float) (irvo.getCantidad()*1.1));
									if(talle == "M")
										irvo.setCantidad((float) (irvo.getCantidad()*1.15));
									if(talle == "L")
										irvo.setCantidad((float) (irvo.getCantidad()*1.2));
									if(talle == "XL")
										irvo.setCantidad((float) (irvo.getCantidad()*1.25));
									if(talle == "XXL")
										irvo.setCantidad((float) (irvo.getCantidad()*1.3));
								}
								pvo.agregarItem(irvo);
							}*/
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
		
		JLabel lblGanancia = new JLabel("Ganancia:");
		lblGanancia.setBounds(10, 163, 153, 14);
		frmCrearPrenda.getContentPane().add(lblGanancia);
		
		txtGanancia = new JTextField();
		txtGanancia.setBounds(193, 157, 86, 20);
		frmCrearPrenda.getContentPane().add(txtGanancia);
		txtGanancia.setColumns(10);
		
		JLabel lblInsumos = new JLabel("Insumos:");
		lblInsumos.setBounds(220, 184, 64, 14);
		frmCrearPrenda.getContentPane().add(lblInsumos);
		
		
		JComboBox<InsumoVO> cbInsumos = new JComboBox<InsumoVO>();
		cbInsumos.setBounds(220, 207, 196, 20);
		frmCrearPrenda.getContentPane().add(cbInsumos);
		for(InsumoVO ivo : insumos)
			cbInsumos.addItem(ivo);
		
		JLabel lblCantidadInsumo = new JLabel("Cantidad");
		lblCantidadInsumo.setBounds(238, 240, 74, 14);
		frmCrearPrenda.getContentPane().add(lblCantidadInsumo);
		
		txtCantInsumo = new JTextField();
		txtCantInsumo.setBounds(322, 237, 86, 20);
		frmCrearPrenda.getContentPane().add(txtCantInsumo);
		txtCantInsumo.setColumns(10);
		
		JLabel lblDesperdicio = new JLabel("Desperdicio");
		lblDesperdicio.setBounds(238, 266, 74, 14);
		frmCrearPrenda.getContentPane().add(lblDesperdicio);
		
		txtDesperdicio = new JTextField();
		txtDesperdicio.setBounds(322, 263, 86, 20);
		frmCrearPrenda.getContentPane().add(txtDesperdicio);
		txtDesperdicio.setColumns(10);
		
		JButton btnAgregarInsumo = new JButton("Agregar Insumo");
		btnAgregarInsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ItemRecetaVO iro = new ItemRecetaVO();
				iro.setCantidad(Float.parseFloat(txtCantInsumo.getText()));
				iro.setDesperdicio(Float.parseFloat(txtDesperdicio.getText()));
				iro.setInsumo((InsumoVO) cbInsumos.getSelectedItem());
			}
		});
		btnAgregarInsumo.setBounds(238, 288, 166, 23);
		frmCrearPrenda.getContentPane().add(btnAgregarInsumo);
		
		JLabel lblAreas = new JLabel("Areas:");
		lblAreas.setBounds(220, 323, 46, 14);
		frmCrearPrenda.getContentPane().add(lblAreas);
		
		JComboBox cbAreas = new JComboBox();
		cbAreas.setBounds(220, 348, 196, 20);
		frmCrearPrenda.getContentPane().add(cbAreas);
		cbAreas.addItem("Marcado");
		cbAreas.addItem("Corte");
		cbAreas.addItem("Habilidado");
		cbAreas.addItem("Costura");
		cbAreas.addItem("Estampado");
		cbAreas.addItem("Acabado");
		cbAreas.addItem("Planchado");
		cbAreas.addItem("Empacado");
		
		JLabel lblDuracion = new JLabel("Duraci\u00F3n");
		lblDuracion.setBounds(238, 379, 74, 14);
		frmCrearPrenda.getContentPane().add(lblDuracion);
		
		txtDuracion = new JTextField();
		txtDuracion.setBounds(322, 376, 86, 20);
		frmCrearPrenda.getContentPane().add(txtDuracion);
		txtDuracion.setColumns(10);
		
		JButton btnAgregarArea = new JButton("Agregar Area");
		btnAgregarArea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DetalleAreaVO davo = new DetalleAreaVO();
				davo.setArea((String) cbAreas.getSelectedItem());
				davo.setDuracion(Float.parseFloat(txtDuracion.getText()));
			}
		});
		btnAgregarArea.setBounds(238, 408, 166, 23);
		frmCrearPrenda.getContentPane().add(btnAgregarArea);
		
		JButton btnVerItems = new JButton("Ver Items");
		btnVerItems.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnVerItems.setBounds(238, 450, 166, 23);
		frmCrearPrenda.getContentPane().add(btnVerItems);
	}
}
