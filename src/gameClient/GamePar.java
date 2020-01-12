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
	}
	
	public void initRobot(List<String> robot_info) throws JSONException {	
		
	}

	public void setrobot() {

	}
	public List<myFruit> getfruit() {
		return fr;
	}
	public void getrobot() {

	}
}
