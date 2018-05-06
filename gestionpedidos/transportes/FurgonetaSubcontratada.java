package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

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
	


