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


public abstract class  Transporte {
	private String codigo;
	private Mapa mapa;
	public Transporte(String codigo,Mapa mapa){
		this.mapa=mapa;
		this.codigo=codigo;
		
	}
	public void setCodigo(String codigo){
		this.codigo=codigo;
		
	}

	public  double coste(String posDestino){
		return this.mapa.distancia(this.codigo,posDestino);
		
	}
		
	public abstract double coste(String codigo1, String codigo2);
	
	
	public Mapa getMapa(){
		return this.mapa;
	}
	public String getCodigo() {
		return this.codigo;		
	}

	

}
