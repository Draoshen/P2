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


public class FurgonetaPropia extends Furgoneta{
	private double velocidadMedia = 30;
	private static final double  EUROSPHORA=40;
	
	public FurgonetaPropia(String codigo, Mapa mapa, double tara) {
		super(codigo, mapa, tara);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public double coste(String codOrigen, String codDestino){
		double coste = 0;
		Mapa mapa= getMapa();
		if (this.getTara()<1000){
		coste=mapa.distancia(codOrigen,codDestino)*EUROSPHORA/velocidadMedia;
		}
		else 
			coste=mapa.distancia(codOrigen,codDestino)*EUROSPHORA/velocidadMedia*1.10;
		return coste;	
    }
	public void setVelocidadMedia(double velocidadMedia){
		this.velocidadMedia=velocidadMedia;
	}
	public double getVelocidadMedia(){
		return this.velocidadMedia;
	}


}
