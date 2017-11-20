package rest;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import tm.RotondAndesTM;
import vos.ConsultaFuncionamiento;

import javax.ws.rs.core.Response;


/**
 * 
 * RFC11
 * @author angeloMarcetty
 *
 */
@Path("administradores/{idAdministradores: \\d+}/consultaFuncionamiento")
public class ConsultaFuncionamientoService {

	@Context
	private ServletContext context;
	
	
	private String getPath() {
		return context.getRealPath("WEB-INF/ConnectionData");
	}
	
	
	private String doErrorMessage(Exception e){
		return "{ \"ERROR\": \""+ e.getMessage() + "\"}" ;
	}
	
	
//	@GET
//	@Produces( { MediaType.APPLICATION_JSON } )
//	public Response consultaFuncionamiento(@PathParam("idAdministradores") Long idAdministradores) throws Exception {
//		
//		RotondAndesTM tm = new RotondAndesTM(getPath());
//		
//		ArrayList<ConsultaFuncionamiento> listConsulta = tm.consultaFuncionamientoArray(idAdministradores);
//		
//		
//		
////		ConsultaFuncionamiento cf = tm.con
//
//	}
	
	
}
