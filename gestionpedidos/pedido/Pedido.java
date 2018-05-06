package gestionpedidos.pedido;

import gestionpedidos.transportes.Transporte;

public class Pedido {
	// CÓDIGO DE APOYO
	private Cliente cliente;
	private PlatoComida[] comidas;
	private Restaurante restaurante;
	private double importe;	
	private Transporte transporte;
	private double peso;
	
	public Pedido(Cliente cliente, PlatoComida[] comidas, Restaurante restaurante) {		
		this.cliente=cliente;
		this.comidas=comidas;
		this.restaurante=restaurante;
		for(int i=0;i<comidas.length;i++){
			this.importe+=comidas[i].getPrecio();
			this.peso+=comidas[i].getPeso();
		}
	}

	
	public double getPeso(){
		
		return peso;
	}
	
	
	public double coste(Transporte transporte){
			double coste=
					transporte.coste(restaurante.getCodigo(),cliente.getCodigo())+importe;
		return coste;
	}
	
	// CÓDIGO DE APOYO
	public double getImporte(){
		return importe;
	}	

	// CÓDIGO DE APOYO
	public Transporte getTransporte() {
		return transporte;
	}

	// CÓDIGO DE APOYO
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	// CÓDIGO DE APOYO
	public Cliente getCliente(){
		return cliente;
	}
	
	// CÓDIGO DE APOYO
	public Restaurante getRestaurante(){
		return restaurante;
	}
}
