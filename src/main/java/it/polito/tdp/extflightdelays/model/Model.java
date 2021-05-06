package it.polito.tdp.extflightdelays.model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	ExtFlightDelaysDAO dao;
	Graph<Airport, DefaultWeightedEdge> grafo ;
	Map<Integer,Airport> idMap;
	
	public Model() {
		dao = new ExtFlightDelaysDAO();
		idMap=new HashMap<Integer,Airport>();
	}
	
	public List<Airline> getAirlineList() {
		return dao.loadAllAirlines();
	}
	
	public void getAirportList(Map<Integer,Airport> idMap) {
		dao.loadAllAirports(idMap);
	}
	
	public List<Flight> getFlightList() {
		return dao.loadAllFlights();
	}
	
	public String creaGrafo(int x) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
	
		getAirportList(idMap);
		Graphs.addAllVertices(this.grafo,idMap.values());
		
		List<Adiacenza> adiacenzeTotali=dao.getAllAdiacenze();
		
		for(Adiacenza a:adiacenzeTotali) {
			for(Adiacenza b:adiacenzeTotali) {
				if(a.getId1().equals(b.getId2()) && a.getId2().equals(b.getId1())) {
					double peso=(a.getSommaMiglia()+b.getSommaMiglia())/(a.getNumeroVoli()+b.getNumeroVoli());
					if(peso>=x) {
						Graphs.addEdge(grafo,idMap.get(a.getId1()),idMap.get(a.getId2()),peso);
					}
				}
			}
		}
		
		String s="# VERTICI: " + grafo.vertexSet().size()+"\n# ARCHI: " + grafo.edgeSet().size()+"\n";
		for(DefaultWeightedEdge e:grafo.edgeSet()) {
			s=s+e.toString()+"\n";
		}
		return s;
		
		
	}
}
