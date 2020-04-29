package com.java.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.clases.Usuario;
import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;
import com.interfaz.ClienteGeoPosUy;

public class FrameCargarUsuario implements ActionListener {

	public static void main(String[] args) {

	}
	
	/** Frame de la ventana */
	private JFrame frame;

	/** Atributos de labels */
	private JLabel labelUsername;

	/** Atributos de TexField */
	private JTextField textUsername;
	
	public JTextField getTextCodigo() {
		return textUsername;
	}
	public JTextField getTextDescripcion() {
		return textUsername;
	}

	public void setTextUsername(JTextField textUsername) {
		this.textUsername = textUsername;
	}

		
	/** Atributos de Botones */
	private JButton buttonConfirmar;
	private JButton buttonCancelar;

	public FrameCargarUsuario(JFrame framePadre) {
		
		this.labelUsername = new JLabel("(*) Nombre de usuario:");
		
		this.textUsername = new JTextField(30);

		JButton buttonConfirmar = new JButton("Confirmar");
		buttonConfirmar.addActionListener(this);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(this);

		this.buttonConfirmar = buttonConfirmar;
		this.buttonCancelar = buttonCancelar;

		this.initializeFrame(framePadre);
	}
	
	private void initializeFrame(JFrame framePadre) {

		JFrame frame = new JFrame("Modificar Usuario");
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(framePadre);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel buscarUsuarioPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		buscarUsuarioPanel.add(this.labelUsername, constraints);
		
		
		constraints.gridx = 1;
		buscarUsuarioPanel.add(this.textUsername, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 5;
		constraints.anchor = GridBagConstraints.CENTER;
		buscarUsuarioPanel.add(buttonConfirmar, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 6;
		constraints.anchor = GridBagConstraints.CENTER;
		buscarUsuarioPanel.add(buttonCancelar, constraints);

		buscarUsuarioPanel
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del usuario"));

		frame.add(buscarUsuarioPanel);

		frame.pack();
		frame.setVisible(true);

		this.frame = frame;

	}
	
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

		String fieldUsername = this.textUsername.getText();

		// Si alguno es vacío, mostramos una ventana de mensaje
		if (fieldUsername.equals("")) {
			JOptionPane.showMessageDialog(frame, "Debe completar todos los datos marcados con (*).", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);

			return; }
		
		// Controlo el maximo de caracteres
		if (fieldUsername.length() > 15) {
			JOptionPane.showMessageDialog(frame, "El nombre de usuario puede contener máximo 15 caracteres", "Datos inválidos!",
					JOptionPane.WARNING_MESSAGE);
		}
		
		
		Usuario usuarioAModificar = null;
		try {
			usuarioAModificar = ClienteGeoPosUy.buscarUsuario(fieldUsername);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		if(usuarioAModificar == null) {
			JOptionPane.showMessageDialog(frame, "No existe un usuario con ese username",
					"Fenómeno existente!", JOptionPane.WARNING_MESSAGE);

			return;			
		}else {
			new FrameModificarUsuario(frame, usuarioAModificar);			
		}
			//Si todo va bien modifico
		
		/*boolean almacenado = false;
		try {
			almacenado = ClienteGeoPosUy.actualizarFenomeno(fieldCodigo, fieldNombre, fieldDescripcion, fieldTelefono);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (almacenado) {
			JOptionPane.showMessageDialog(frame, "El fenómeno ha sido modificado con éxito.",
					"Fenómeno Modificado!", JOptionPane.INFORMATION_MESSAGE);
			
			// cerramos la ventanta
			this.frame.dispose();

			
		}
		else{
			JOptionPane.showMessageDialog(frame, "Hubo un error al almacenar. Intente nuevamente más tarde",
					"Error al registrar!", JOptionPane.ERROR_MESSAGE);
		}*/

}
	private void accionCancelar() {
		// si se cancela, se eliminar la ventana
		this.frame.dispose();

	}
}
