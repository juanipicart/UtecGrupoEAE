package com.interfaz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.beans.FenomenosBeanRemote;
import com.beans.LoginBeanRemote;
import com.beans.CodRolBeanRemote;
import com.beans.UbicacionesBeanRemote;
import com.beans.UsuarioBeanRemote;
import com.clases.Usuario;
import com.clases.codigueras.CodDepartamento;
import com.clases.codigueras.CodLocalidad;
import com.clases.codigueras.CodRol;
import com.clases.codigueras.CodZona;
import com.clases.relaciones.RelUbicacion;



public class ClienteGeoPosUy {

	private static String JNDI_USUARIO = "GeoPosUy/com.beans/UsuariosBean!servicios.remote.UsuariosBeanRemote";
	private static String JNDI_FENOMENO = "GeoPosUy/com.beans/FenomenosBean!servicios.remote.FenomenosBeanRemote";
	private static String JNDI_UBICACION = "GeoPosUy/com.beans/UbicacionesBean!servicios.remote.UbicacionesBeanRemote";
	private static String JNDI_LOGIN = "GeoPosUy/com.beans/LoginBean!servicios.remote.LoginBeanRemote";
	private static String JNDI_ROL = "GeoPosUy/com.beans/RolBean!servicios.remote.RolBeanRemote";
	

	

	/*** Operaciones sobre Usuarios ***/
	public static Usuario buscarUsuario(String username) throws Exception {
		
		UsuarioBeanRemote usuarioBeanRemote = EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
		return usuarioBeanRemote.buscarUsuario(username);
	}

	public static int registrarUsuario(long id, String usuario, String nombre, String apellido, String direccion, String password, String documento ,int estado, int rol, int tipodoc, String correo,
			RelUbicacion ubicacion) throws Exception {
		
		UsuarioBeanRemote usuarioBeanRemote = EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
		return usuarioBeanRemote.registrarUsuario(id, usuario, nombre, apellido, direccion,password, documento, estado, rol, tipodoc, correo, ubicacion);
	}
	
	public static int modificarUsuario(long id, String usuario, String nombre, String apellido, String direccion, String password, String documento ,int estado, int rol, int tipodoc, String correo,
			RelUbicacion ubicacion) throws Exception {

		UsuarioBeanRemote usuarioBeanRemote = EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
		return usuarioBeanRemote.modificarUsuario(id,  usuario,  nombre,  apellido,  direccion,  password,
				 documento,  estado,  rol,  tipodoc,  correo,  ubicacion);
	}
	
	public static boolean existeUsuario(String usuario) throws Exception {

		UsuarioBeanRemote usuarioBeanRemote = EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
		return usuarioBeanRemote.ExisteUsuario(usuario);
	}
	
	public static boolean validarLogin(String username, String password) throws Exception {

		LoginBeanRemote LoginBeanRemote = EJBLocator.getInstance().lookup(LoginBeanRemote.class);
		
		return LoginBeanRemote.verificarLogin(username, password);
	}
	
	public static boolean eliminarUsuario(long idUsuario) throws NamingException {

		UsuarioBeanRemote usuarioBeanRemote = EJBLocator.getInstance().lookup(UsuarioBeanRemote.class);
		return usuarioBeanRemote.eliminarUsuario(idUsuario);		
	}
	/*** Operaciones sobre Ubicaciones ***/
	
	public static List<CodZona> obtenerZonas()throws Exception {

		/*UbicacionesBeanRemote ubi = null;
		try {
			ubi = (UbicacionesBeanRemote)InitialContext.doLookup("GeoPosUy/UbicacionesBean!com.beans.UbicacionesBeanRemote");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		List<CodZona> aver = (List<CodZona>)ubi.retornarZonas();
		
		return aver;*/
		
		UbicacionesBeanRemote ubicaciones = EJBLocator.getInstance().lookup(UbicacionesBeanRemote.class);
		return ubicaciones.retornarZonas();
	}
	
	public static List<CodLocalidad> obtenerLocalidades()throws Exception {

		
		UbicacionesBeanRemote ubicaciones = EJBLocator.getInstance().lookup(UbicacionesBeanRemote.class);
		return ubicaciones.retornarLocalidades();
	}

	public static List<CodDepartamento> obtenerDepartamentos()throws Exception {

		
		UbicacionesBeanRemote ubicaciones = EJBLocator.getInstance().lookup(UbicacionesBeanRemote.class);
		return ubicaciones.retornarDepartamentos();
	}
	/*** Operaciones sobre Fenomenos ***/

	/*public static boolean ExisteFenomeno(String nombre) throws Exception {

		FenomenosBeanRemote veterinariosBeanRemote = EJBLocator.getInstance().lookup(FenomenosBeanRemote.class);
		return veterinariosBeanRemote.ExisteFenomeno(nombre);

	}*/
	
	/*** Operaciones sobre Roles ***/

	public static List<CodRol> obtenerRoles() throws Exception {

		CodRolBeanRemote rolBean = EJBLocator.getInstance().lookup(CodRolBeanRemote.class);
		return rolBean.retornarRoles();

	}

	public static boolean crearFenomeno(String codigo, String nombre, String desc, String contacto) throws Exception {
		
		FenomenosBeanRemote	fen = EJBLocator.getInstance().lookup(FenomenosBeanRemote.class);
		return fen.crearFenomeno(codigo, nombre, desc, contacto);
	}



	/*public static boolean ingresarNuevaVeterinario(String fieldCodigo, String fieldEspecialidad, String fieldNombre,
			String fieldCi) throws Exception {

		VeterinariosBeanRemote veterinariosBeanRemote = EJBLocator.getInstance().lookup(VeterinariosBeanRemote.class);
		return veterinariosBeanRemote.ingresarNuevaVeterinario(fieldCodigo, fieldEspecialidad, fieldNombre, fieldCi);
	}
	
	public static List<Veterinario> obtenerTodosVeterinarios() throws Exception {
		VeterinariosBeanRemote veterinariosBeanRemote = EJBLocator.getInstance().lookup(VeterinariosBeanRemote.class);
		return veterinariosBeanRemote.obtenerTodosVeterinarios();
	}
	
	/*** Operaciones sobre Mascotas ***/

	/*public static boolean existeMascota(String fieldPatente) throws Exception {
		
		MascotasBeanRemote mascotasBeanRemote = EJBLocator.getInstance().lookup(MascotasBeanRemote.class);
		return mascotasBeanRemote.existeMascota(fieldPatente);
	}

	public static boolean ingresarNuevaMascota(String fieldPatente, String fieldTipo, int edad, String fieldNombre,
			String ciCliente) throws Exception {
		
		MascotasBeanRemote mascotasBeanRemote = EJBLocator.getInstance().lookup(MascotasBeanRemote.class);
		return mascotasBeanRemote.ingresarNuevaMascota(fieldPatente, fieldTipo, edad, fieldNombre, ciCliente);
	}

	public static List<Mascota> obtenerTodasMascotas() throws Exception{
		
		MascotasBeanRemote mascotasBeanRemote = EJBLocator.getInstance().lookup(MascotasBeanRemote.class);
		return mascotasBeanRemote.obtenerTodasMascotas();
	}

	/*** Operaciones sobre Consultas ***/
	/*
	public static List<Consulta> obtenerTodasConsultas() throws Exception {
		
		ConsultasBeanRemote consultasBeanRemote = EJBLocator.getInstance().lookup(ConsultasBeanRemote.class);
		return consultasBeanRemote.obtenerTodasConsultas();
	}

	public static boolean ingresarNuevaConsulta(String codigoVeterinario, String patenteMascota, Date fecha) throws Exception {
		ConsultasBeanRemote consultasBeanRemote = EJBLocator.getInstance().lookup(ConsultasBeanRemote.class);
		return consultasBeanRemote.ingresarNuevaConsulta(codigoVeterinario, patenteMascota, fecha);
	}*/

	
	
	

}
