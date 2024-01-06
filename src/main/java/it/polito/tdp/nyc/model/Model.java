package it.polito.tdp.nyc.model;

import java.util.*;
import java.util.List;
import java.util.Set;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.nyc.db.NYCDao;

public class Model {
	
	private NYCDao dao;
	private Graph<NTA,DefaultWeightedEdge> grafo;
	private List<NTA> NTAs;
	
	public Model(){
		this.dao = new NYCDao();
	}
	
	public void creaGrafo(String b) {
		this.grafo = new SimpleWeightedGraph<> (DefaultWeightedEdge.class);
		this.NTAs = dao.getVertici(b);
		//VERTICI
		Graphs.addAllVertices(this.grafo, this.NTAs);
		
		
		//ARCHI
		for (NTA n1: this.NTAs) {
			for (NTA n2: this.NTAs){
				if (n1.getNTACode().compareTo(n2.getNTACode())<0) {
					Set<String> unione = new HashSet<> (n1.getSSIDs());
					//ADDALL AGGIUNGE SE NON SONO GIA' PRESENTI -> IL VALORE E' L'UNIONE DEI DUE INSIEMI 
					unione.addAll(n2.getSSIDs());
					Graphs.addEdge(this.grafo, n1, n2, unione.size());
				}
			}
		}
		
	}
	public List<Arco> analisiArchi() {
		double media = 0.0;
		for (DefaultWeightedEdge e : this.grafo.edgeSet()) {
			media += this.grafo.getEdgeWeight(e);
			
		}
		media = media/this.grafo.edgeSet().size();
		
		List<Arco> risultato = new ArrayList<>();
		
		for (DefaultWeightedEdge e : this.grafo.edgeSet()) {
			if (this.grafo.getEdgeWeight(e) > media) {
				risultato.add(new Arco(
						this.grafo.getEdgeSource(e).getNTACode(),
						this.grafo.getEdgeTarget(e).getNTACode(),
						(int) this.grafo.getEdgeWeight(e)));
			}
		}
		Collections.sort(risultato);
		return risultato;
		
		
	}
	
	public int numV() {
		return this.grafo.vertexSet().size();
	}
	public int numA() {
		return this.grafo.edgeSet().size();
	}

	public List<String> getBorghi(){
		return this.dao.getBorghi();
	};

	
}
