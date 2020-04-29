package com.java.swing;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.beans.UbicacionesBeanRemote;
import com.beans.UsuarioBean;
import com.beans.UsuarioBeanRemote;
import com.clases.codigueras.CodDepartamento;
import com.clases.codigueras.CodLocalidad;
import com.clases.codigueras.CodRol;
import com.clases.codigueras.CodZona;
import com.clases.relaciones.RelUbicacion;
import com.interfaz.ClienteGeoPosUy;

import enums.Estados;
import enums.TiposDocumento;
import enums.TiposUsuario;

public class FrameAltaUsuario implements ActionListener {
	
	/** Frame de la ventana */
	private JFrame frame;

	/** Atributos de labels */
	private JLabel labelUsername;
	private JLabel labelNombre;
	private JLabel labelApellido;
	private JLabel labelTipoDoc;
	private JLabel labelDoc;
	private JLabel labelDireccion;
	private JLabel labelDepto;
	private JLabel labelLocalidad;
	private JLabel labelZona;
	private JLabel labelRol;
	private JLabel labelCorreo;
	private JLabel labelPassword;
	private JLabel labelEstado;

	/** Atributos de TexField */
	private JTextField textUsername;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDoc;
	private JTextField textDireccion;
	private JTextField textPassword;
	private JTextField textCorreo;
	
	/*Atributos de Combobox*/
	private JComboBox<TiposDocumento> comboTipoDoc;
	private JComboBox<String> comboDepto;
	private JComboBox<String> comboLocalidad;
	private JComboBox<String> comboZona;
	private JComboBox<TiposUsuario> comboRol;	
	private JComboBox<Estados> comboEstado;	
	
	/** Atributos de Botones */
	private JButton buttonRegistrar;
	private JButton buttonCancelar;

	public FrameAltaUsuario(JFrame framePadre) {

		this.labelApellido = new JLabel("Apellido:");
		this.labelNombre = new JLabel("Nombre:");
		this.labelTipoDoc = new JLabel("Tipo de documento:");
		this.labelDoc = new JLabel("Documento:");
		this.labelDireccion = new JLabel("Dirección:");
		this.labelUsername = new JLabel("Username:");
		this.labelDepto = new JLabel("Departamento:");
		this.labelLocalidad = new JLabel("Localidad:");
		this.labelZona = new JLabel("Zona:");
		this.labelRol = new JLabel("Rol:");
		this.labelPassword = new JLabel("Contraseña:");
		this.labelCorreo = new JLabel("Correo:");
		this.labelEstado = new JLabel("Estado:");
		
		this.textDoc = new JTextField(30);
		this.textNombre = new JTextField(30);
		this.textApellido = new JTextField(30);
		this.textDireccion = new JTextField(30);
		this.textUsername = new JTextField(30);
		this.textPassword = new JTextField(30);
		this.textCorreo = new JTextField(30);
		
		
		
		JButton buttonRegistrar = new JButton("Registrar Usuario");
		buttonRegistrar.addActionListener(this);

		JButton buttonCancelar = new JButton("Cancelar registro");
		buttonCancelar.addActionListener(this);

		this.buttonRegistrar = buttonRegistrar;
		this.buttonCancelar = buttonCancelar;

		this.initializeFrame(framePadre);
	}

	private void initializeFrame(JFrame framePadre) {

		JFrame frame = new JFrame("Nuevo Usuario");
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(framePadre);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel nuevoUsuarioPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		nuevoUsuarioPanel.add(this.labelUsername, constraints);
		
		constraints.gridx = 1;
		nuevoUsuarioPanel.add(this.textUsername, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		nuevoUsuarioPanel.add(this.labelPassword, constraints);
		
		constraints.gridx = 1;
		nuevoUsuarioPanel.add(this.textPassword, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		nuevoUsuarioPanel.add(this.labelNombre, constraints);

		constraints.gridx = 1;
		nuevoUsuarioPanel.add(this.textNombre, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		nuevoUsuarioPanel.add(this.labelApellido, constraints);

		constraints.gridx = 1;
		nuevoUsuarioPanel.add(this.textApellido, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		nuevoUsuarioPanel.add(this.labelTipoDoc, constraints);
		try {
			
			constraints.gridx = 1;
			constraints.gridy = 4;
			this.comboTipoDoc = cargarComboTipoDoc();
			nuevoUsuarioPanel.add(this.comboTipoDoc, constraints);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		constraints.gridx = 0;
		constraints.gridy = 5;
		nuevoUsuarioPanel.add(this.labelDoc, constraints);

		constraints.gridx = 1;
		nuevoUsuarioPanel.add(this.textDoc, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 6;
		nuevoUsuarioPanel.add(this.labelDireccion, constraints);

		constraints.gridx = 1;
		nuevoUsuarioPanel.add(this.textDireccion, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 7;
		nuevoUsuarioPanel.add(this.labelCorreo, constraints);
		
		constraints.gridx = 1;
		nuevoUsuarioPanel.add(this.textCorreo, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 8;
		nuevoUsuarioPanel.add(this.labelZona, constraints);
		
		
		try {
			
			constraints.gridx = 1;
			constraints.gridy = 8;
			this.comboZona = cargarComboZonas();
			nuevoUsuarioPanel.add(this.comboZona, constraints);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		constraints.gridx = 0;
		constraints.gridy = 9;
		nuevoUsuarioPanel.add(this.labelLocalidad, constraints);
		
		try {
			
			constraints.gridx = 1;
			constraints.gridy = 9;
			this.comboLocalidad = cargarComboLocalidad();
			nuevoUsuarioPanel.add(this.comboLocalidad, constraints);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		constraints.gridx = 0;
		constraints.gridy = 10;
		nuevoUsuarioPanel.add(this.labelDepto, constraints);
		
		try {
			
			constraints.gridx = 1;
			constraints.gridy = 10;
			this.comboDepto = cargarComboDepartamento();
			nuevoUsuarioPanel.add(this.comboDepto, constraints);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		constraints.gridx = 0;
		constraints.gridy = 11;
		nuevoUsuarioPanel.add(this.labelRol, constraints);
		
		try {
			
			constraints.gridx = 1;
			constraints.gridy = 11;
			this.comboRol = cargarComboRol();
			nuevoUsuarioPanel.add(this.comboRol, constraints);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		constraints.gridx = 0;
		constraints.gridy = 12;
		nuevoUsuarioPanel.add(this.labelEstado, constraints);
		
		try {
			
			constraints.gridx = 1;
			constraints.gridy = 12;
			this.comboEstado = cargarComboEstados();
			nuevoUsuarioPanel.add(this.comboEstado, constraints);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		constraints.gridx = 0;
		constraints.gridy = 13;
		constraints.gridwidth = 5;
		constraints.anchor = GridBagConstraints.CENTER;
		nuevoUsuarioPanel.add(buttonRegistrar, constraints);

		constraints.gridx = 0;
		constraints.gridy = 13;
		constraints.gridwidth = 6;
		constraints.anchor = GridBagConstraints.CENTER;
		nuevoUsuarioPanel.add(buttonCancelar, constraints);

		nuevoUsuarioPanel
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del usuario"));

		frame.add(nuevoUsuarioPanel);

		frame.pack();
		frame.setVisible(true);

		this.frame = frame;

	}

	/**
	 * Como implementos Action Listener, quiere decir que soy escuchado de
	 * eventos. Este método es quien se ejecutan cuando tocan un boton .
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		/* Debo primero conocer que botón fue clickeado */

		if (e.getSource() == this.buttonCancelar) {
			this.accionCancelar();
		} else {
			this.accionIngresar();
		}	
	}

	private void accionIngresar() {

		// Si es ingresar se validan datos!

		String fieldNombre = this.textNombre.getText();
		String fieldApellido = this.textApellido.getText();
		String fieldPassword = this.textPassword.getText();
		String fieldDoc = this.textDoc.getText();
		String fieldDireccion = this.textDireccion.getText();
		String fieldUsername = this.textUsername.getText();
		String fieldCorreo = this.textCorreo.getText();
		TiposDocumento tipoDoc = (TiposDocumento) comboTipoDoc.getSelectedItem();
		String depto =  (String) comboDepto.getSelectedItem();
		String zona =  (String) comboZona.getSelectedItem();
		String localidad =  (String) comboLocalidad.getSelectedItem();
		TiposUsuario rolUsuario =  (TiposUsuario) comboRol.getSelectedItem();
		Estados estado =  (Estados) comboEstado.getSelectedItem();
		

		// Si alguno es vacío, mostramos una ventana de mensaje
		if (fieldNombre.equals("") || fieldApellido.equals("") || fieldDoc.equals("") || fieldDireccion.equals("") || fieldUsername.equals("") || fieldPassword.equals("")		 || tipoDoc.equals("") || depto.equals("") || zona.equals("") || localidad.equals("") || rolUsuario.equals("") || estado.equals("")) {
			JOptionPane.showMessageDialog(frame, "Debe completar todos los datos solicitados.", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);

			return; }
		
		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		
		Matcher matcher = pattern.matcher(fieldCorreo);
		
	
		if (!matcher.matches()) {
			JOptionPane.showMessageDialog(frame, "El formato del correo no es correcto", "Datos inválidos!",
					JOptionPane.WARNING_MESSAGE);

			return;
		}
		
		try {
			
			//boolean existeUsuario = ClienteGeoPosUy.existeUsuario(fieldUsername); //validacion que ya estaba en backend
			
			//Creo una ubicacion por el error que no pudimos solucionar aun
			long longId = new Long(0);
			long longIdUbi = new Long(1);
			
			RelUbicacion ubicacion = new RelUbicacion(longIdUbi, longId,"asd",longId);
			CodRol rol = new CodRol();
			
			//if(!existeUsuario) {
			int correctamente = ClienteGeoPosUy.registrarUsuario(longId, fieldUsername, fieldNombre, fieldApellido, fieldDireccion, fieldPassword, fieldDoc , estado.getCodigo(), rolUsuario.getCodigo(), tipoDoc.getCodigo(), fieldCorreo, ubicacion);
			if(correctamente == 0) {
				JOptionPane.showMessageDialog(frame, "Usuario registrado correctamente", "Registro completado!",
						JOptionPane.WARNING_MESSAGE);
			}
				//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//llamo al bean remote para mandarle los parametros

		
		
		}

	

		// Validamos si el formato del mail es valido

	/*public boolean existeUsuario(String username) {
		boolean existe = false;
		try{
			existe = ClienteGeoPosUy.existeUsuario(username);
		} catch (Exception e){
			JOptionPane.showMessageDialog(frame, "Error de conexión con el servidor. Intente más tarde.",
					"Error de conexión!", JOptionPane.WARNING_MESSAGE);
		}
		
		if (existe) {
			JOptionPane.showMessageDialog(frame, "Ya existe un usuario con ese username",
					"Usuario existente!", JOptionPane.WARNING_MESSAGE);
		}
		return existe;		
	}*/
		


		/*// Valiamos ahora, que no exista un cliente con dicha CI
		boolean existe = ControladorClientes.existeCliente(fieldCi);

		if (existe) {
			JOptionPane.showMessageDialog(frame, "El cliente con dicha CI ya se ecuentra registrado.",
					"Cliente Existente!", JOptionPane.WARNING_MESSAGE);

			return;
		}*/

		// Si estamos aquí,..quiere decir que no hay errores. Almacenamos el
		// cliente y volvemos al menu
		/*boolean almacenado = ControladorClientes.ingresarNuevoCliente(fieldNombre, fieldApellido, fieldCi);

		if (almacenado) {
			JOptionPane.showMessageDialog(frame, "El cliente ha sido registrado con éxito.",
					"Cliente Registrado!", JOptionPane.INFORMATION_MESSAGE);
			
			// cerramos la ventanta
			this.frame.dispose();

			
		}
		else{
			JOptionPane.showMessageDialog(frame, "Hubo un error al almacenar. Intente nuevamente más tarde",
					"Error al registrar!", JOptionPane.ERROR_MESSAGE);
		}

	}*/

	private void accionCancelar() {
		// si se cancela, se eliminar la ventana
		this.frame.dispose();

	}

	private JComboBox<String> cargarComboZonas() throws Exception {
		
		List<CodZona> zonas = new ArrayList<CodZona>();
		
		try {
			zonas = ClienteGeoPosUy.obtenerZonas();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		JComboBox<String> combo = new JComboBox<>();

		for (CodZona zona : zonas) {
			combo.addItem(zona.getDescCodZona());
		}

		return combo;
	}
	
	private JComboBox<String> cargarComboLocalidad() throws Exception {
		
		List<CodLocalidad> localidades = new ArrayList<CodLocalidad>();
		
		try {
			localidades = ClienteGeoPosUy.obtenerLocalidades();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		JComboBox<String> combo = new JComboBox<>();

		for (CodLocalidad localidad : localidades) {
			combo.addItem(localidad.getDescCodLocalidad());
		}

		return combo;
	}
	
	private JComboBox<String> cargarComboDepartamento() throws Exception {
		
		List<CodDepartamento> deptos = new ArrayList<CodDepartamento>();
		
		try {
			deptos = ClienteGeoPosUy.obtenerDepartamentos();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		JComboBox<String> combo = new JComboBox<>();

		for (CodDepartamento depto : deptos) {
			combo.addItem(depto.getDescCodDepartamento());
		}

		return combo;
	}
	
	private JComboBox<TiposUsuario> cargarComboRol() throws Exception {
		
		List<TiposUsuario> tipos = Arrays.asList(TiposUsuario.values());

		JComboBox<TiposUsuario> combo = new JComboBox<>();

		for (TiposUsuario tipo : tipos) {
			combo.addItem(tipo);
		}

		return combo;
	}
	
	private JComboBox<TiposDocumento> cargarComboTipoDoc() throws Exception {
		
		List<TiposDocumento> tipos = Arrays.asList(TiposDocumento.values());

		JComboBox<TiposDocumento> combo = new JComboBox<>();

		for (TiposDocumento tipo : tipos) {
			combo.addItem(tipo);
		}

		return combo;
	}
	
	private JComboBox<Estados> cargarComboEstados() throws Exception {
		
		List<Estados> estados = Arrays.asList(Estados.values());

		JComboBox<Estados> combo = new JComboBox<>();

		for (Estados estado : estados) {
			combo.addItem(estado);
		}

		return combo;
	}

	/*
	 JButton botonRegistrar = new JButton("Registrar");
	    botonRegistrar.setFont (new Font("Dialog",Font.BOLD,12));
	    
	    JButton botonCancelarRegistro = new JButton("Cancelar");
	    botonCancelarRegistro.setFont (new Font("Dialog",Font.BOLD,12));
	    
	    JPanel panelSurRegistro = new JPanel(new GridLayout(1,2,10,0));
	    panelSurRegistro.add (botonRegistrar);
	    panelSurRegistro.add (botonCancelarRegistro);
	

	    
	    JLabel labelUsernameRegistro = new JLabel();
	    labelUsernameRegistro.setText ("Username:");
	    labelUsernameRegistro.setBackground (new Color(255,255,204));
	    
	    JLabel labelPasswordRegistro = new JLabel();
	    labelPasswordRegistro.setText ("Password:");
	    labelPasswordRegistro.setBackground (new Color(255,255,204));
	    
	    JLabel labelNombreRegistro = new JLabel();
	    labelNombreRegistro.setText ("Nombre:");
	    labelNombreRegistro.setBackground (new Color(255,255,204));
	    
	    JLabel labelApellidoRegistro = new JLabel();
	    labelApellidoRegistro.setText ("Apellido:");
	    labelApellidoRegistro.setBackground (new Color(255,255,204));
	    
	    JLabel labelDireccionRegistro = new JLabel();
	    labelDireccionRegistro.setText ("Direccion:");
	    labelDireccionRegistro.setBackground (new Color(255,255,204));
	    
	    
	    JPanel panelOesteRegistro = new JPanel(new GridLayout(5,1,5,5));
	    panelOesteRegistro.setBorder(new EmptyBorder(10,10,10,10));
	    panelOesteRegistro.add(labelUsernameRegistro);
	    panelOesteRegistro.add(labelPasswordRegistro);
	    panelOesteRegistro.add(labelNombreRegistro);
	    panelOesteRegistro.add(labelApellidoRegistro);
	    panelOesteRegistro.add(labelDireccionRegistro);
	    
	    
	    
	   
	    JPanel panelCentroRegistro = new JPanel(new GridLayout(5,1,5,50));	   
	    panelCentroRegistro.setBorder(new EmptyBorder(50,10,10,50));
	    panelCentroRegistro.add (textFieldUsernameRegistro);
	    panelCentroRegistro.add (textFieldPasswordRegistro);
	    panelCentroRegistro.add (textFieldNombreRegistro);
	    panelCentroRegistro.add (textFieldApellidoRegistro);
	    panelCentroRegistro.add (textFieldDireccionRegistro);
	    
	    JFrame ventanaRegistro = new JFrame ("Registro de usuario");
	    ventanaRegistro.setSize(800,800);
	    ventanaRegistro.add (panelOesteRegistro, BorderLayout.WEST);
	    ventanaRegistro.add (panelCentroRegistro, BorderLayout.CENTER);
	    ventanaRegistro.add (panelSurRegistro, BorderLayout.SOUTH);
	    ventanaRegistro.setVisible(false);*/
	
	    

	    
	    
	    

}
