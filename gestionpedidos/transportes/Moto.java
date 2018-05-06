package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

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
