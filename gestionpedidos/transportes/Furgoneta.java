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


public abstract class Furgoneta extends Transporte{
	private double tara;

	public Furgoneta(String codigo, Mapa mapa,double tara) {
		super(codigo, mapa);
		this.tara=tara;
		// TODO Auto-generated constructor stub
	}
	public double getTara(){
		return tara;
	}
	public void setTara(double tara){
		this.tara=tara;
	}
	
	}
	
