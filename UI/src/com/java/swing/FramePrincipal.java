package com.java.swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.beans.UbicacionesBeanRemote;

public class FramePrincipal {

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
		
		initializeMenuBar(frame);

		// Display the window.
		frame.setVisible(true);
		}
		
		private static void initializeMenuBar(JFrame frame) {
			
			JMenuBar menuBar = new JMenuBar();
			
			initializeMenuUsuarios(menuBar, frame);
			initializeMenuObservaciones(menuBar, frame);
			initializeMenuFenomenos(menuBar, frame);
			
			frame.setJMenuBar(menuBar);

		}
		
		//Agrego la opci�n USUARIOS al menu
		private static void initializeMenuUsuarios(JMenuBar menuBar, final JFrame frame) {
			
			JMenu usuarios = new JMenu("Usuarios");
			
			JMenuItem nuevoUsuario = new JMenuItem("Nuevo Usuario");
			
			nuevoUsuario.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                
	            	new FrameAltaUsuario(frame);
	            	
	            }
	        });
			JMenuItem modificarUsuario = new JMenuItem("Modificar Usuario");
			
			nuevoUsuario.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                
	            	new FrameCargarUsuario(frame);
	            	
	            }
	        });


			usuarios.add(nuevoUsuario);
			usuarios.add(modificarUsuario);
			menuBar.add(usuarios);
			
		}
		
		private static void initializeMenuObservaciones(JMenuBar menuBar, final JFrame frame) {
			
			JMenu observaciones = new JMenu("Observaciones");
			
			JMenuItem nuevaObservacion = new JMenuItem("Nueva Observaci�n");
			
			nuevaObservacion.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                
	            	new FrameAltaObservacion(frame);
	            	
	            }
	        });
		
			
			/*JMenuItem listarObservaciones = new JMenuItem("Listar Observaciones");
			
			listarObservaciones.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                
	            	new FrameListarObservaciones(frame);
	            	
	            }
	        });*/

			observaciones.add(nuevaObservacion);
			//observaciones.add(listarObservaciones);
			
			menuBar.add(observaciones);
			
		}
		
		private static void initializeMenuFenomenos(JMenuBar menuBar, final JFrame frame) {
			
			JMenu fenomenos = new JMenu("Fen�menos");
			
			JMenuItem nuevoFenomeno = new JMenuItem("Nuevo Fen�meno");
			
			nuevoFenomeno.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                
	            	new FrameAltaFenomeno(frame);
	            	
	            }
	        });
			JMenuItem modifFenomeno = new JMenuItem("Modificar Fen�meno");
			
			modifFenomeno.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent event) {
	                
	            	new FrameModificarFenomeno(frame);
	            	
	            }
	        });

			fenomenos.add(nuevoFenomeno);
			fenomenos.add(modifFenomeno);
			menuBar.add(fenomenos);
		
			//Accesos directos
		JButton botonRegistrarFenomeno = new JButton("Registrar fen�meno");
		botonRegistrarFenomeno.setFont(new Font("Dialog",Font.BOLD,12));
		botonRegistrarFenomeno.setSize(50, 10);
	
		JButton botonRegistrarObservacion = new JButton("Registrar observaci�n");
		botonRegistrarObservacion.setFont (new Font("Dialog",Font.BOLD,12));
		botonRegistrarObservacion.setSize(50, 10);
		
		JButton botonRegistrarUsuario = new JButton("Nuevo usuario");
		botonRegistrarUsuario.setFont (new Font("Dialog",Font.BOLD,12));
		botonRegistrarUsuario.setSize(50, 10);
		
		JButton botonModificarUsuario = new JButton("Modificar usuario");
		botonModificarUsuario.setFont (new Font("Dialog",Font.BOLD,12));
		botonModificarUsuario.setSize(50, 10);
		
	    JPanel panelCentroSistema = new JPanel (new GridBagLayout());
	    GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.CENTER;
		
		
	    panelCentroSistema.setBorder(new EmptyBorder(30,30,30,30));
	    
	    constraints.gridx = 0;
	    constraints.gridy = 0;
	    constraints.gridwidth = 1;
	    panelCentroSistema.add (botonRegistrarFenomeno, constraints);
	    
	    constraints.gridx = 0;
	    constraints.gridy = 1;
	    constraints.gridwidth = 1;
	    panelCentroSistema.add (botonRegistrarObservacion);
	    
	    constraints.gridx = 0;
	    constraints.gridy = 2;
	    constraints.gridwidth = 1;
	    
	    panelCentroSistema.add (botonRegistrarUsuario);
	    
	    constraints.gridx = 0;
	    constraints.gridy = 3;
	    constraints.gridwidth = 1;
	    
	    panelCentroSistema.add (botonModificarUsuario);
	    
	    frame.add(panelCentroSistema);
	    frame.pack();
	    frame.setVisible(true);
 
	    botonRegistrarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	
            	
        		/*UbicacionesBeanRemote ubi = null;
				try {
					ubi = (UbicacionesBeanRemote)InitialContext.doLookup("GeoPosUy/UbicacionesBean!com.beans.UbicacionesBeanRemote");
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

        		boolean aver = ubi.holaMundo();
        		
        		System.out.println(aver);*/
        		
            	new FrameAltaUsuario(frame);
            	
            }
        });
	    
	    botonRegistrarObservacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameAltaObservacion(frame);
            	
            }
        });
	    
	    botonRegistrarFenomeno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameAltaFenomeno(frame);
            	
            	
            	
            }
        });
	    
	    botonModificarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                
            	new FrameCargarUsuario(frame);          	
            	
            	
            }
        });
	 
	}
		
		
}


