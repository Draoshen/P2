package gestionpedidos.pedido;

import gestionpedidos.transportes.Transporte;
//Este paquete hay que importarlo para que el compilador 
//reconozca la anotaci�n @Programacion2
import anotacion.Programacion2; 

//Rellenar siempre los datos del Autor 1
//Para entrega en grupo rellenar los datos del Autor 2
@Programacion2 (
	nombreAutor1 = "Rafael Alejandro",
	apellidoAutor1 = "Mellado Climent",
	emailUPMAutor1 = "rafael.mellado.climent@alumnos.upm.es",
	nombreAutor2 = "Miguel �ngel",
	apellidoAutor2 = "S�nchez Magalotti", 
	emailUPMAutor2 = "miguelangel.sanchez.magalotti@alumnos.upm.es"
)

public class Pedido {
	// C�DIGO DE APOYO
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
	
	// C�DIGO DE APOYO
	public double getImporte(){
		return importe;
	}	

	// C�DIGO DE APOYO
	public Transporte getTransporte() {
		return transporte;
	}

	// C�DIGO DE APOYO
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	// C�DIGO DE APOYO
	public Cliente getCliente(){
		return cliente;
	}
	
	// C�DIGO DE APOYO
	public Restaurante getRestaurante(){
		return restaurante;
	}
}
