package gameClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import Server.Fruit;
import Server.Game_Server;
import Server.fruits;
import Server.game_service;
import Server.robot;
import dataStructure_ex3.DGraph;
import dataStructure_ex3.Node;
import dataStructure_ex3.edge_data;
import dataStructure_ex3.graph;
import utils.Point3D;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.*;


//-1 from high to low 
//1 from low to high 




public class GamePar {
	List<myFruit>fr = new ArrayList<myFruit>();
	List<robot>rb = new ArrayList<robot>();
	int scene;
	game_service game;
	
	public GamePar(int scene) {
		this.scene=scene;
		game = Game_Server.getServer(this.scene);
	}
	public void initFruit(List<String> fruit_info) throws JSONException {
		
		
		for (int i = 0; i < fruit_info.size(); i++) {
			
			myFruit temp = new myFruit(fruit_info.get(i));
			fr.add(temp);
			System.out.println(fr.get(i).toString());
			
	
		
		}
		/**
		 * public void init(String check) throws IOException {

		DGraph grap = new DGraph();
		// System.out.println(robot_json);
		// JSONParser file = new JSONParser();
		JSONStringer file = new JSONStringer();
		try {

			// Object obj = file.parse(new FileReader(check));

			JSONObject jsonObject = new JSONObject(check);
			// JSONArray jsonArray= jsonObject.getJSONArray("Employees");
			JSONArray json_Edges =jsonObject.getJSONArray("Edges");
			JSONArray json_Nodes =jsonObject.getJSONArray("Nodes");
			// JSONArray json_Edges = (JSONArray)jsonObject.get("Edges");
			// JSONArray json_Nodes = (JSONArray)jsonObject.get("Nodes");

			for (int i = 0; i < json_Nodes.length(); i++) {

				JSONObject empObj = new JSONObject();
				empObj = json_Nodes.getJSONObject(i);
				int src = (int) empObj.get("id");
				String pos = (String)empObj.get("pos");
				Point3D loc = new Point3D(pos);
				this.addNode(new Node(src, loc));
			}

			for (int i = 0; i < json_Edges.length(); i++) {


				JSONObject empObj = new JSONObject();
				empObj = json_Edges.getJSONObject(i);

				double src = Double.parseDouble(empObj.get("src").toString());
				double w = (double) empObj.get("w");
				int dest = (int) empObj.get("dest");
				this.connect((int)src, dest, w);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
		 */

	}
	public void setrobot() {

	}
	public void getfruit() {

	}
	public void getrobot() {

	}
}
