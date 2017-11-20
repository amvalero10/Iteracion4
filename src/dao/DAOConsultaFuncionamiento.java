package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.AbstractAlimento;

/**
 * 
 * @author angeloMarcetty
 *	RFC11
 */
public class DAOConsultaFuncionamiento {
	
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOConsultaPedidos() {
		recursos = new ArrayList<Object>();
	}

	public void cerrarRecursos() {
		for (Object ob : recursos) {
			if (ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	public void setConn(Connection con) {
		this.conn = con;
	}
	
	
	
	public AbstractAlimento productoMasC()throws SQLException, Exception{
		
		AbstractAlimento alimentoMacC = null;
		
		Integer alimentoMasCons = 0;
		
		
		
		
		
		
		
		return
	}
	
	
	
	
	
	

}
