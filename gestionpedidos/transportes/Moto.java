package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;
//Este paquete hay que importarlo para que el compilador 
//reconozca la anotación @Programacion2
import anotacion.Programacion2; 

//Rellenar siempre los datos del Autor 1
//Para entrega en grupo rellenar los datos del Autor 2
@Programacion2 (
	nombreAutor1 = "Rafael Alejandro",
	apellidoAutor1 = "Mellado Climent",
	emailUPMAutor1 = "rafael.mellado.climent@alumnos.upm.es",
	nombreAutor2 = "Miguel Ángel",
	apellidoAutor2 = "Sánchez Magalotti", 
	emailUPMAutor2 = "miguelangel.sanchez.magalotti@alumnos.upm.es"
)


public class Moto extends Transporte{
	private double eurosPKm =2;
	
	public Moto(String codigo, Mapa mapa) {
		super(codigo, mapa);
		// TODO Auto-generated constructor stub
	}
	public double getEurosPKm(){
		return this.eurosPKm;
	}
	public void setEurosPKm(double eurosPKm){
		this.eurosPKm=eurosPKm;
	}
	@Override
	public double coste(String codOrigen,String codDestino){
		Mapa mapa=this.getMapa();
		double coste=super.coste(codOrigen)+
				mapa.distancia(codOrigen, codDestino);
		
		return coste*eurosPKm;
	}
	@Override
	public double coste(String codDestino){
		return super.coste(codDestino)*eurosPKm;
	}
	

}
