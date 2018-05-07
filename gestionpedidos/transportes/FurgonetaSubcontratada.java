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


public class FurgonetaSubcontratada extends Furgoneta {
	private double eurosPKm=1;
	public FurgonetaSubcontratada(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa, tara);
		// TODO Auto-generated constructor stub
	}
	public void setEurosPKm(double eurosPKm){
		this.eurosPKm=eurosPKm;
	
	}
	public double getEurosPKm(){
		return this.eurosPKm;
	}
	
	
	public double coste(String codPosOrigen, String codPosDestino){
		double coste;
		Mapa mapa=this.getMapa();
		if (this.getTara() <1000) {
		coste=mapa.distancia(codPosOrigen,codPosDestino)*eurosPKm;
		}
		else 
			coste=mapa.distancia(codPosOrigen,codPosDestino)*eurosPKm*1.10;
		
		return coste;
	}
}
	


