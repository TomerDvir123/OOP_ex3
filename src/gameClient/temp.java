package gameClient;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import Server.Game_Server;
import Server.game_service;
import dataStructure_ex3.node_data;
import dataStructure_ex3.DGraph;
import dataStructure_ex3.Node;
import dataStructure_ex3.edge_data;
import dataStructure_ex3.graph;
import gui.Game_GUI;
import utils.Point3D;
/**
 * This class represents a simple example for using the GameServer API:
 * the main file performs the following tasks:
 * 1. Creates a game_service [0,23] (line 36)
 * 2. Constructs the graph from JSON String (lines 37-39)
 * 3. Gets the scenario JSON String (lines 40-41)
 * 4. Prints the fruits data (lines 44-45)
 * 5. Add a single robot (line 48) // note: in genera a list of robots should be added
 * 6. Starts game (line 49)
 * 7. Main loop (should be a thread)
 * 8. move the robot along the current edge (line 54)
 * 9. direct to the next edge (if on a node) (line 68)
 *  
 * @author boaz.benmoshe
 *
 */
public class temp {
	public static void main(String[] a) {
		
//		
//		node_data t = new Node(1,new Point3D(1.0,2.0,3.0));
//		
//		DGraph p = new DGraph();
//		p.addNode((dataStructure_ex3.node_data) t);
		Game_GUI p2 = new Game_GUI();
		System.out.println();
//		test1();
	}
	public static void test1() {
		game_service game = Game_Server.getServer(23); // you have [0,23] games
		String g = game.getGraph();
		DGraph gg = new DGraph();
		try {
			gg.init(g);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		String info = game.toString();
		System.out.println(info);
		System.out.println(g);
		
		// the list of fruits should be considered in your solution
		Iterator<String> f_iter = game.getFruits().iterator();
		while(f_iter.hasNext()) {System.out.println(f_iter.next());}
		
		int src_node = 0;  // arbitrary node, you should start at one of the fruits
		game.addRobot(src_node);
		game.startGame();
		int i=0;
		while(game.isRunning()) {
			long t = game.timeToEnd();
			//System.out.println("roung: "+i+"  seconds to end:"+(t/1000));
			List<String> log = game.move();
			if(log!=null) {
				String robot_json = log.get(0);
			//	System.out.println(robot_json);
				JSONObject line;
				try {
					line = new JSONObject(robot_json);
					JSONObject ttt = line.getJSONObject("Robot");
					int rid = ttt.getInt("id");
					int src = ttt.getInt("src");
					int dest = ttt.getInt("dest");
					
					if(dest==-1) {	
						dest = nextNode(gg, src);
						game.chooseNextEdge(rid, dest);
						System.out.println("Turn to node: "+dest);
						System.out.println(ttt);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	
				
				}
			i++;
		}
	}
	/**
	 * a very simple random walk implementation!
	 * @param g
	 * @param src
	 * @return
	 */
	private static int nextNode(graph g, int src) {
		int ans = -1;
		Collection<edge_data> ee = g.getE(src);
		Iterator<edge_data> itr = ee.iterator();
		int s = ee.size();
		int r = (int)(Math.random()*s);
		int i=0;
		while(i<r) {itr.next();i++;}
		ans = itr.next().getDest();
		return ans;
	}

}
