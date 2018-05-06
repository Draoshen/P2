package gestionpedidos.transportes;
import gestionpedidos.mapa.Mapa;

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
