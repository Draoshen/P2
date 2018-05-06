package gestionpedidos;

import gestionpedidos.pedido.Pedido;
import gestionpedidos.transportes.Furgoneta;
import gestionpedidos.transportes.Moto;
import gestionpedidos.transportes.Transporte;
import list.ArrayList;


public class GestionRepartoLocal {	
	// CÓDIGO DE APOYO
	private ArrayList<Moto> motosDisponibles;
	private ArrayList<Furgoneta> furgonetasDisponibles;

	private ArrayList<Pedido> pedidosEsperandoMoto;
	private ArrayList<Pedido> pedidosEsperandoFurgoneta;
	
	// CÓDIGO DE APOYO
	private static ArrayList<String> getCodList(ArrayList<?> disponibles) {
		ArrayList<String> salida = new ArrayList<>();
		for(int i=0; i<disponibles.size(); i++)
			salida.add(salida.size(),((Transporte) disponibles.get(i)).getCodigo());
		return salida;
	}
	
	// CÓDIGO DE APOYO
	private static ArrayList<String[]> getClienteRestauranteList(ArrayList<?> disponibles){
		 ArrayList<String[]> salida = new  ArrayList<>();
		for(int i=0; i<disponibles.size(); i++)
			salida.add(salida.size(),new String[]{((Pedido) disponibles.get(i)).getCliente().getCodigo() ,
					((Pedido) disponibles.get(i)).getRestaurante().getCodigo()});
		return salida;
	}
	
	// CÓDIGO DE APOYO
	private static String myArrayListToString (ArrayList<?> list){
		String salida = "";
		for(int i=0; i<list.size(); i++){
			salida += " " ;
			if (list.get(i) instanceof String[]){
				String[] item = (String[])list.get(i);
				for(int j=0; j<item.length; j++){
					salida += item[j] ;
				}	
			}else if (list.get(i) instanceof String){
				salida += (String)list.get(i);
			}
		}
			
		return salida;
	}
	
	// CÓDIGO DE APOYO
	public String getDisponibles(){
		return "Motos Disponibles:" + myArrayListToString(getCodList(motosDisponibles)) + System.lineSeparator() +
			"Furgonetas Disponibles:" + myArrayListToString(getCodList(furgonetasDisponibles)) + System.lineSeparator();
			
	}
	
	// CÓDIGO DE APOYO
	public String getEsperando(){
		return "Pedidos esperando moto:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoMoto)) + System.lineSeparator() +
				"Pedidos esperando furgoneta:" + myArrayListToString(getClienteRestauranteList(pedidosEsperandoFurgoneta)) + System.lineSeparator();
	}
	
	// CÓDIGO DE APOYO
	public ArrayList<String> getCodMotosDisponibles(){
		return getCodList(motosDisponibles);
	}	
	
	// CÓDIGO DE APOYO
	public ArrayList<String> getCodFurgoDisponibles(){
		return getCodList(furgonetasDisponibles);
			
	}
	
	// CÓDIGO DE APOYO
	public ArrayList<String[]> getCodEsperandoMoto(){
		return getClienteRestauranteList(pedidosEsperandoMoto);
	}
	
	public ArrayList<String[]> getCodEsperandoFurgo(){
		return getClienteRestauranteList(pedidosEsperandoFurgoneta);
	}

	private static final double PESOMAXMOTO = 20;

	// CÓDIGO DE APOYO
	public GestionRepartoLocal(){		
		
		this.motosDisponibles = new ArrayList<>();
		this.furgonetasDisponibles = new ArrayList<>();

		this.pedidosEsperandoFurgoneta = new ArrayList<>();
		this.pedidosEsperandoMoto = new ArrayList<>();
	}

	public void add(Transporte transporte){
		//TO-DO
		if (transporte instanceof Furgoneta) {
			Furgoneta f = (Furgoneta) transporte;
			this.furgonetasDisponibles.add(furgonetasDisponibles.size(),f);
		}
		else if(transporte instanceof Moto){
			Moto m = (Moto) transporte;
			this.motosDisponibles.add(motosDisponibles.size(), m);
		}
	}
			
	public void asignarPedido(Pedido pedido){
		//TO-DO		
		
		//Ahora vamos a ver que hay motos disponibles
		double costeMin=100000;
		int pos=0;
		
		if (pedido.getPeso()<PESOMAXMOTO) {
		if(motosDisponibles.size()!=0){
		 
			pos=0;
			//Damos como primer valor el de primera posición
			
			costeMin=pedido.coste(motosDisponibles.get(0));
			
			//Ahora vamos a calcular el min yendo uno por uno
			
			for(int i=0; i<motosDisponibles.size(); i++){
				if(costeMin>pedido.coste(motosDisponibles.get(i))){
					costeMin=pedido.coste(motosDisponibles.get(i));
					pos=i;
					
				}
			}
			//Una vez hallada la moto de menor coste la asignamos
			pedido.setTransporte(motosDisponibles.get(pos));
			motosDisponibles.removeElementAt(pos);
			
		 
		}
		else {
			pedidosEsperandoMoto.add(pedidosEsperandoMoto.size(),pedido);
		}
		}
		
		else {
			if (furgonetasDisponibles.size()!=0){
			costeMin = pedido.coste(furgonetasDisponibles.get(0));
			for(int i=0; i<furgonetasDisponibles.size(); i++){
				if(costeMin>pedido.coste(furgonetasDisponibles.get(i))){
					costeMin=pedido.coste(furgonetasDisponibles.get(i));
					pos=i;
				}
			}
			
			pedido.setTransporte(furgonetasDisponibles.get(pos));
			furgonetasDisponibles.removeElementAt(pos);
		}
			else{
				pedidosEsperandoFurgoneta.add(pedidosEsperandoFurgoneta.size(),pedido);
			}
		}
	}
		
	
	public void notificarEntregaPedido(Pedido pedido) {	
		//TO-DO	
		if(pedidosEsperandoMoto.size()==0 && pedidosEsperandoFurgoneta.size()==0){
		add(pedido.getTransporte());
		}
		if(pedido.getTransporte() instanceof Moto && pedidosEsperandoMoto.size()!=0){
			pedidosEsperandoMoto.get(0).setTransporte(pedido.getTransporte());
			pedidosEsperandoMoto.removeElementAt(0);
			
		}
		if(pedido.getTransporte() instanceof Furgoneta && pedidosEsperandoFurgoneta.size()!=0){
			pedidosEsperandoFurgoneta.get(0).setTransporte(pedido.getTransporte());
			pedidosEsperandoFurgoneta.removeElementAt(0);
			
		}
		
	}
	
	
}