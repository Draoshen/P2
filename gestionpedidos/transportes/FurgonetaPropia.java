package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

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
