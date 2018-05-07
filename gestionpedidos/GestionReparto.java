package gestionpedidos;

import gestionpedidos.mapa.Mapa;
import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Transporte;

public class GestionReparto {
	// C�DIGO DE APOYO
	private GestionRepartoLocal[] gestoresLocales;
	private Mapa mapa;
	
	public GestionReparto(Mapa mapa){
		//TO-DO
		this.mapa=mapa;
		this.gestoresLocales = new GestionRepartoLocal[4];
		for(int i=0; i<gestoresLocales.length;i++){
			gestoresLocales[i]=new GestionRepartoLocal();
					
		}
		
	}
	
	//C�DIGO DE APOYO
	public Mapa getMapa() {
		return mapa;
	}
	
	// C�DIGO DE APOYO
	public String getEstadoGestorLocal(int i){
		return this.gestoresLocales[i].getDisponibles() + this.gestoresLocales[i].getEsperando();
	}
	
	// C�DIGO DE APOYO
	public String getEstadoGestorLocalNum(int i){
		return  this.gestoresLocales[i].getCodMotosDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodFurgoDisponibles().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoMoto().size() + ";" +
				this.gestoresLocales[i].getCodEsperandoFurgo().size() ;
	}
	
	public void addTransporteLocalidad(Transporte transporte) {
		//Coordenadas del mapa global
		int coordenadaX = this.mapa.getMaxCoordX();
		int coordenadaY = this.mapa.getMaxCoordY();
		
		
		//Coordenadas del mapa asociado al transporte
		
		String codTransporte= transporte.getCodigo();
		int coordenadaTransX = mapa.getPosicion(codTransporte).getX();
		int coordenadaTransY = mapa.getPosicion(codTransporte).getY();		
		/*
		 * Una vez obtenidas todas las coordenadas del mapa del transporte
		 * proseguiremos a ver en cual de las cuatro zonas de Reparto est�
		 * Para ello vamos a mira primero la coordenadaX para determinar si est� en
		 * la parte de la derecha o de la izquierda, y para la Y miraremos si est� en la
		 * parte superior o inferior
		 */
		
		//Si se cumple el primer requisito el transporte est� en la parte derecha
		if((coordenadaX/2)<coordenadaTransX){
			if((coordenadaY/2)<coordenadaTransY){
				gestoresLocales[3].add(transporte);
				}
			else{
				gestoresLocales[1].add(transporte);
				
			}
		}
		else{
			if((coordenadaY/2)<coordenadaTransY){
				gestoresLocales[2].add(transporte);
				}
			else{
				gestoresLocales[0].add(transporte);
			}
			
		}
		
			
		
	}
		
	
	public void asignarPedido(Pedido pedido){
		/*
		 * Obtenemos primeramente el c�digo del cliente, para luego obtener su ubicaci�n en el mapa
		 * 
		 */
		
		String codCliente=pedido.getCliente().getCodigo();
		int coordClienteX= mapa.getPosicion(codCliente).getX();
		int coordClienteY = mapa.getPosicion(codCliente).getY();
		
		//Coordenadas del mapa
		int coordenadaX = this.mapa.getMaxCoordX();
		int coordenadaY = this.mapa.getMaxCoordY();
		
		//volvemos a repetir el proceso que hemos hecho en los transportes
		if((coordenadaX/2)<coordClienteX){
			if((coordenadaY/2)<coordClienteY){
				gestoresLocales[3].asignarPedido(pedido);
				}
			else{
				gestoresLocales[1].asignarPedido(pedido);
				
			}
		}
		else{
			if((coordenadaY/2)<coordClienteY){
				gestoresLocales[2].asignarPedido(pedido);
				}
			else{
				gestoresLocales[0].asignarPedido(pedido);
			}
			
		}
		
		
	}
	
	public void notificarEntregaPedido(Pedido pedido){
		//TO-DO
		String codCliente=pedido.getCliente().getCodigo();
		int coordClienteX= mapa.getPosicion(codCliente).getX();
		int coordClienteY = mapa.getPosicion(codCliente).getY();
		
		//Coordenadas del mapa
		int coordenadaX = this.mapa.getMaxCoordX();
		int coordenadaY = this.mapa.getMaxCoordY();
		
		//volvemos a repetir el proceso que hemos hecho en los transportes
		if((coordenadaX/2)<coordClienteX){
			if((coordenadaY/2)<coordClienteY){
				gestoresLocales[3].notificarEntregaPedido(pedido);
				}
			else{
				gestoresLocales[1].notificarEntregaPedido(pedido);
				
			}
		}
		else{
			if((coordenadaY/2)<coordClienteY){
				gestoresLocales[2].notificarEntregaPedido(pedido);
				}
			else{
				gestoresLocales[0].notificarEntregaPedido(pedido);
			}
			
		}
		
		
	}
	
}
