package com.java.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.naming.NamingException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.exceptions.NoSeRealizoOperacionException;
import com.exceptions.ProblemasNivelSQLException;
import com.interfaz.ClienteGeoPosUy;

public class FrameModificarFenomeno implements ActionListener {

	public static void main(String[] args) {

	}
	
	/** Frame de la ventana */
	private JFrame frame;

	/** Atributos de labels */
	private JLabel labelDescripcion;
	private JLabel labelNombre;
	private JLabel labelTelefono;
	private JLabel labelCodigo;

	/** Atributos de TexField */
	private JTextField textDescripcion;
	private JTextField textCodigo;
	
	public JTextField getTextCodigo() {
		return textCodigo;
	}
	public JTextField getTextDescripcion() {
		return textDescripcion;
	}

	public void setTextDescripcion(JTextField textDescripcion) {
		this.textDescripcion = textDescripcion;
	}

	public JTextField getTextNombre() {
		return textNombre;
	}

	public void setTextNombre(JTextField textNombre) {
		this.textNombre = textNombre;
	}

	public JTextField getTextTelefono() {
		return textTelefono;
	}

	public void setTextTelefono(JTextField textTelefono) {
		this.textTelefono = textTelefono;
	}

	private JTextField textNombre;
	private JTextField textTelefono;
		
	/** Atributos de Botones */
	private JButton buttonConfirmar;
	private JButton buttonCancelar;
	
	String fieldCodigo;

	public FrameModificarFenomeno(JFrame framePadre, String fieldCodigo) {

		this.labelDescripcion = new JLabel("(*) Descripci�n:");
		this.labelNombre = new JLabel("(*) Nombre:");
		this.labelTelefono = new JLabel("(*) Tel�fono:");
		this.labelCodigo = new JLabel("(*) C�digo:");
		
		this.textDescripcion = new JTextField(30);
		this.textNombre = new JTextField(30);
		this.textTelefono = new JTextField(30);
		this.textCodigo = new JTextField(30);

		JButton buttonConfirmar = new JButton("Confirmar");
		buttonConfirmar.addActionListener(this);

		JButton buttonCancelar = new JButton("Cancelar");
		buttonCancelar.addActionListener(this);

		this.buttonConfirmar = buttonConfirmar;
		this.buttonCancelar = buttonCancelar;

		this.initializeFrame(framePadre);
		
		this.fieldCodigo = fieldCodigo;
	}
	
	private void initializeFrame(JFrame framePadre) {

		JFrame frame = new JFrame("Modificar Fen�meno");
		frame.setSize(600, 400);
		frame.setResizable(false);
		frame.setLocationRelativeTo(framePadre);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel buscarFenomenoPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		buscarFenomenoPanel.add(this.labelCodigo, constraints);
		
		constraints.gridx = 1;
		textCodigo.setEditable(false);
		buscarFenomenoPanel.add(this.textCodigo, constraints);
		
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		buscarFenomenoPanel.add(this.labelNombre, constraints);
		
		
		constraints.gridx = 1;
		buscarFenomenoPanel.add(this.textNombre, constraints);

		constraints.gridx = 0;
		constraints.gridy = 2;
		buscarFenomenoPanel.add(this.labelDescripcion, constraints);

		constraints.gridx = 1;
		buscarFenomenoPanel.add(this.textDescripcion, constraints);

		constraints.gridx = 0;
		constraints.gridy = 3;
		buscarFenomenoPanel.add(this.labelTelefono, constraints);

		constraints.gridx = 1;
		buscarFenomenoPanel.add(this.textTelefono, constraints);

		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 5;
		constraints.anchor = GridBagConstraints.CENTER;
		buscarFenomenoPanel.add(buttonConfirmar, constraints);

		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 6;
		constraints.anchor = GridBagConstraints.CENTER;
		buscarFenomenoPanel.add(buttonCancelar, constraints);

		buscarFenomenoPanel
				.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Datos del fen�meno"));

		frame.add(buscarFenomenoPanel);

		frame.pack();
		frame.setVisible(true);

		this.frame = frame;

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		/* Debo primero conocer que bot�n fue clickeado */

		if (e.getSource() == this.buttonCancelar) {
			this.accionCancelar();
		} else {
			try {
				this.accionIngresar();
			} catch (NamingException e1) {
				e1.printStackTrace();
			} catch (NoSeRealizoOperacionException e1) {
				e1.printStackTrace();
			} catch (ProblemasNivelSQLException e1) {
				e1.printStackTrace();
			}
		}

	}
	
	private void accionIngresar() throws NamingException, NoSeRealizoOperacionException, ProblemasNivelSQLException {

		// Si es ingresar se validan datos!

		String fieldNombre = this.textNombre.getText();
		String fieldDescripcion = this.textDescripcion.getText();
		String fieldTelefono = this.textTelefono.getText();

		// Si alguno es vac�o, mostramos una ventana de mensaje
		if (fieldNombre.equals("") || fieldDescripcion.equals("") || fieldTelefono.equals("")) {
			JOptionPane.showMessageDialog(frame, "Debe completar todos los datos marcados con (*).", "Datos incompletos!",
					JOptionPane.WARNING_MESSAGE);

			return; }
		
		// Controlo el maximo de caracteres
		if (fieldNombre.length() > 30) {
			JOptionPane.showMessageDialog(frame, "El nombre puede contener m�ximo 30 caracteres", "Datos inv�lidos!",
					JOptionPane.WARNING_MESSAGE);
		} else if (fieldDescripcion.length() > 100) {
			JOptionPane.showMessageDialog(frame, "La descripci�n puede contener m�ximo 100 caracteres", "Datos inv�lidos!",
					JOptionPane.WARNING_MESSAGE);
		} else if (fieldTelefono.length() > 20) {
			JOptionPane.showMessageDialog(frame, "El tel�fono puede contener m�ximo 20 caracteres", "Datos inv�lidos!",
					JOptionPane.WARNING_MESSAGE);
		}
		
		//Controlo que el fenomeno no exista ya
		
		boolean existe;
		
		try{
			existe = ClienteGeoPosUy.ExisteFenomeno(fieldNombre);
		} catch (Exception e){
			JOptionPane.showMessageDialog(frame, "Error de conexi�n con el servidor. Intente m�s tarde.",
					"Error de conexi�n!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		if (existe) {
			JOptionPane.showMessageDialog(frame, "Ya existe un fen�meno con ese nombre",
					"Fen�meno existente!", JOptionPane.WARNING_MESSAGE);

			return;
		}
		
		try {
			if (ClienteGeoPosUy.ExisteObservacion(fieldCodigo)) {
				JOptionPane.showMessageDialog(frame, "El fen�meno no se puede modificar, tiene observaciones asociadas",
						"Error!", JOptionPane.WARNING_MESSAGE);

				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			//Si todo va bien modifico

		boolean almacenado = false;
		
		try {
			almacenado = ClienteGeoPosUy.modificarFenomeno(fieldCodigo,fieldNombre, fieldDescripcion, fieldTelefono);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		if (almacenado) {
			JOptionPane.showMessageDialog(frame, "El fen�meno ha sido modificado con �xito.",
					"Fen�meno Modificado!", JOptionPane.INFORMATION_MESSAGE);
			
			// cerramos la ventanta
			this.frame.dispose();

			
		}
		else{
			JOptionPane.showMessageDialog(frame, "Hubo un error al almacenar. Intente nuevamente m�s tarde",
					"Error al registrar!", JOptionPane.ERROR_MESSAGE);
		}

}
	private void accionCancelar() {
		// si se cancela, se eliminar la ventana
		this.frame.dispose();

	}
}
