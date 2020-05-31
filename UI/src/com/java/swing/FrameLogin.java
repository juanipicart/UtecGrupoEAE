package com.java.swing;

import java.awt.Color;
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

import com.clases.Usuario;
import com.interfaz.ClienteGeoPosUy;

public class FrameLogin {
	
	private static JFrame Jframe;
	
	private static JLabel labelUsername;
	private static JLabel labelPassword;
	
	private static JTextField textUsername;
	private static JTextField textPassword;

	private JButton buttonIngresar;
	
	public static void main(String[] args) throws NamingException {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
		
		
			
	}
	
	private static void createAndShowGUI() {

	
	JFrame frame = new JFrame("GeoPosUY");
	
	frame.setSize(200, 200);
	frame.setResizable(false);
    frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setBackground(Color.BLUE);

	
	initializeFrame(frame);
	}
	

	
	
	private static void initializeFrame(JFrame frame) {


		labelUsername = new JLabel("Usuario:");
		labelPassword = new JLabel("Contraseña:");
		
		textUsername = new JTextField(30);
		textPassword = new JTextField(30);
		
		JButton buttonIngresar = new JButton("Ingresar");
		buttonIngresar.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                
	            	accionIngresar();
	            	
	            }
	        });

		JPanel loginPanel = new JPanel(new GridBagLayout());

		GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		constraints.gridx = 0;
		constraints.gridy = 0;		
		loginPanel.add(labelUsername,constraints);
		
		constraints.gridx = 1;
		loginPanel.add(textUsername, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		loginPanel.add(labelPassword, constraints);
		
		constraints.gridx = 1;
		loginPanel.add(textPassword, constraints);
		
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 5;
		constraints.anchor = GridBagConstraints.CENTER;
		loginPanel.add(buttonIngresar, constraints);
		
		loginPanel
		.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Ingreso al sistema"));
		// Display the window.
		
		frame.add(loginPanel);

		frame.pack();
		frame.setVisible(true);
		
		Jframe = frame;
	}

	
	private static void accionIngresar() {
		String username = textUsername.getText();
		String password = textPassword.getText();
		
		boolean loginExitoso = false;
		try {
			loginExitoso = ClienteGeoPosUy.validarLogin(username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(loginExitoso);
		if(loginExitoso) {
			
			try {
				FramePrincipal.main(null);
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(Jframe, "Verifique sus datos de ingreso e intentelo nuevamente", "Ha ocurrido un error!",
					JOptionPane.WARNING_MESSAGE);
			
		}
}
}
