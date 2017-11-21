package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import vos.AbstractAlimento;
import vos.ConsultaFuncionamiento;
import vos.Restaurante;
import vos.RestauranteAux;

/**
 * 
 * @author angeloMarcetty
 *	RFC11
 */
public class DAOConsultaFuncionamiento {
	
	private ArrayList<Object> recursos;
	
	public String diaActual;


	private Connection conn;

	public DAOConsultaFuncionamiento() {
		recursos = new ArrayList<Object>();
		diaActual = "cs";
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

	

	
	
	
	public ArrayList<Date> fechasDisponibles() throws SQLException, Exception{
		
		ArrayList<Date> fechasDARRAY = new ArrayList<>();
		
		String sql = "SELECT DISTINCT FECHA\n" + 
				"FROM PEDIDO\n" + 
				"WHERE ESTADO = 'Servido'  ORDER BY FECHA";
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while(rs.next()) {
			Date fechaDis = rs.getDate("FECHA");
			fechasDARRAY.add(fechaDis);	
		}	
		return fechasDARRAY;
	}
	
	
	
	

	
	
	public RestauranteAux restauranteMasVisitado(Date fecha) throws SQLException, Exception {
		
		RestauranteAux restMas = null;
		
		
		String sql = "SELECT * \n" + 
				"FROM\n" + 
				"(\n" + 
				"SELECT DISTINCT(P.ID_RESTAURANTE), COUNT(P.ID_RESTAURANTE) AS RECURRENCIA , to_char(to_date('"+fecha+"','YYYY/MM/DD'),'Day') AS DIA  \n" + 
				"FROM PEDIDO P\n" + 
				"WHERE FECHA = TO_DATE('"+ fecha +"','YYYY/MM/DD') AND ESTADO = 'Servido'\n" + 
				"GROUP BY P.ID_RESTAURANTE\n" + 
				") A INNER JOIN RESTAURANTES R ON A.ID_RESTAURANTE = R.ID\n" + 
				"WHERE ROWNUM = 1\n" + 
				"ORDER BY RECURRENCIA DESC";
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) 
		{

		Long idRestaurante = rs.getLong("ID_RESTAURANTE");
		Integer numVisitas = rs.getInt("RECURRENCIA");
		String nombre = rs.getString("NOMBRE");
		Long cuentaBancaria = rs.getLong("CUENTA_BANCARIA");
		Boolean personzalible = false;
		if(rs.getInt("PERSONALIZABLE") == 1) personzalible = true;
		String descripcion = rs.getString("DESCRIPCION");
		String tipo = rs.getString("TIPO");
		String web = rs.getString("PAGINA_WEB");
		String representante = rs.getString("REPRESENTANTE");
		Integer capacidadMax = rs.getInt("CAPACIDADMAX");
		diaActual = rs.getString("DIA");
		
		restMas = new RestauranteAux(idRestaurante, nombre, cuentaBancaria, personzalible, descripcion, tipo, web, representante, capacidadMax, numVisitas);	
	
		}
		
		return restMas;
	}
	
	
	public RestauranteAux restauranteMenosVisitado(Date fecha) throws SQLException, Exception{
		
		RestauranteAux restMens = null;
		
		String sql = "SELECT * \n" + 
				"FROM\n" + 
				"(\n" + 
				"SELECT DISTINCT(P.ID_RESTAURANTE), COUNT(P.ID_RESTAURANTE) AS RECURRENCIA \n" + 
				"FROM PEDIDO P\n" + 
				"WHERE FECHA = TO_DATE('"+ fecha +"','YYYY/MM/DD') AND ESTADO = 'Servido' \n" + 
				"GROUP BY P.ID_RESTAURANTE\n" + 
				"ORDER BY RECURRENCIA ASC\n" + 
				") A INNER JOIN RESTAURANTES R ON A.ID_RESTAURANTE = R.ID\n" + 
				"WHERE ROWNUM = 1";		
		
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next()) 
		{

		Long idRestaurante = rs.getLong("ID_RESTAURANTE");
		Integer numVisitas = rs.getInt("RECURRENCIA");
		String nombre = rs.getString("NOMBRE");
		Long cuentaBancaria = rs.getLong("CUENTA_BANCARIA");
		Boolean personzalible = false;
		if(rs.getInt("PERSONALIZABLE") == 1) personzalible = true;
		String descripcion = rs.getString("DESCRIPCION");
		String tipo = rs.getString("TIPO");
		String web = rs.getString("PAGINA_WEB");
		String representante = rs.getString("REPRESENTANTE");
		Integer capacidadMax = rs.getInt("CAPACIDADMAX");
		
		restMens = new RestauranteAux(idRestaurante, nombre, cuentaBancaria, personzalible, descripcion, tipo, web, representante, capacidadMax, numVisitas);	
	
		}
		
		return restMens;
		
		
	}
	
	
	

	
	
	
	
	

}
