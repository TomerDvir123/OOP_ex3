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
import dataStructure.node_data;
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
	List<myRobot> rb = new ArrayList<myRobot>();
	int scene;
	game_service game;
	graph grap;
	public GamePar(int scene,DGraph grap) {
		this.scene=scene;
		game = Game_Server.getServer(this.scene);
		this.grap=grap;
	}
	public void initFruit(List<String> fruit_info) throws JSONException {	
		for (int i = 0; i < fruit_info.size(); i++) {

			myFruit temp = new myFruit(fruit_info.get(i),getedges(),grap);
			fr.add(temp);
			System.out.println(fr.get(i).toString());
		}
	}
	public List<edge_data> getedges() {
		List<edge_data> edges = new ArrayList<edge_data>();
		Collection<dataStructure_ex3.node_data> nodes = this.grap.getV();
		for (dataStructure_ex3.node_data nd : nodes) {
			Collection<dataStructure_ex3.edge_data> checksize = this.grap.getE(nd.getKey());
			if (checksize.size()!=0) {
				for (edge_data putedges : checksize) {
					edges.add(putedges);
				}
			}
		}
		return edges;
	}

	public void initRobot(List<String> robot_info) throws JSONException {
		for (int i = 0; i < robot_info.size(); i++) {
			myRobot temp = new myRobot(robot_info.get(i));
			rb.add(temp);
			System.out.println(rb.get(i).toString());
		}
	}
	public int numRobot(String info) throws JSONException
	{
		int num = 0;
		String temp = info.substring(1);
		int y = temp.indexOf("{");
		info = info.substring(0, y)+":[{"+info.substring(y+2, info.length()-2)+"}]}";
		JSONObject jsonObject = new JSONObject(info);
		JSONArray sum_rob =jsonObject.getJSONArray("GameServer");
		JSONObject empObj = new JSONObject();
		empObj = sum_rob.getJSONObject(0);
		num = (int) empObj.get("robots");
		return num;
	}
	public void setrobot() {

	}
	public List<myFruit> getfruit() {
		return fr;
	}
	public void getrobot() {

	}
}
