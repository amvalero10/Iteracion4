package vos;
/**
 * 
 * @author angeloMarcetty
 * RFC11
 */

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ConsultaFuncionamiento {

	@JsonProperty(value="productoMasC")
	private AbstractAlimento productoMasC;
	
	@JsonProperty(value="productoMenosC")
	private AbstractAlimento productoMenosC;
	
	@JsonProperty(value="restauranteMasF")
	private Restaurante restauranteMasF;
	
	@JsonProperty(value="restauranteMenosF")
	private Restaurante restauranteMenosF;
	
	@JsonProperty(value="fecha")
	private Date fecha;
	
	
	
	

	
	public ConsultaFuncionamiento(@JsonProperty(value="productoMasC") AbstractAlimento productoMasC,
								@JsonProperty(value="productoMenosC") AbstractAlimento productoMenosC,
								@JsonProperty(value="restauranteMasF") Restaurante restauranteMasF,
								@JsonProperty(value="restauranteMenosF") Restaurante restauranteMenosF,
								@JsonProperty(value="fecha")Date fecha) {
		super();
		this.productoMasC = productoMasC;
		this.productoMenosC = productoMenosC;
		this.restauranteMasF = restauranteMasF;
		this.restauranteMenosF = restauranteMenosF;	
		this.fecha = fecha;
	}
	
	
	
	public AbstractAlimento getProductoMasC() {
		return productoMasC;
	}
	public void setProductoMasC(AbstractAlimento productoMasC) {
		this.productoMasC = productoMasC;
	}
	

	public AbstractAlimento getProductoMenosC() {
		return productoMenosC;
	}
	public void setProductoMenosC(AbstractAlimento productoMenosC) {
		this.productoMenosC = productoMenosC;
	}

	
	public Restaurante getRestauranteMasF() {
		return restauranteMasF;
	}
	public void setRestauranteMasF(Restaurante restauranteMasF) {
		this.restauranteMasF = restauranteMasF;
	}

	
	
	public Restaurante getRestauranteMenosF() {
		return restauranteMenosF;
	}
	public void setRestauranteMenosF(Restaurante restauranteMenosF) {
		this.restauranteMenosF = restauranteMenosF;
	}


	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	
	

	

	
	
	
	
}
