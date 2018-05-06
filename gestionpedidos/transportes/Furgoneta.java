package gestionpedidos.transportes;

import gestionpedidos.mapa.Mapa;

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
	
