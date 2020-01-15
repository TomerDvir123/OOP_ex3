package gameClient;

import java.util.ArrayList;
import java.util.List;

import dataStructure_ex3.node_data;

public class KML_Logger {
	
	List<node_data> all_node = new ArrayList<node_data>();

	public KML_Logger() {
		
	}
	public void set_all_node(List<node_data> nodelist) {
		all_node= nodelist;
	}
	public List<node_data> get_all_node(){
		return all_node;
	}
}
