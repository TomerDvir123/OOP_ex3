package gameClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dataStructure_ex3.edge_data;
import utils.Point3D;

public class myFruit {

	
		double value ;
		int type;
		Point3D location;
		
		//{"Fruit":{"value":5.0,"type":-1,"pos":"35.188900353135324,32.105320110855615,0.0"}}
		//{"Fruit":[{"value":5.0,"type":-1,"pos":"35.188900353135324,32.105320110855615,0.0"}]}
		public myFruit(String info) throws JSONException {
			String temp = info.substring(1);
			int y = temp.indexOf("{");
			info = info.substring(0, y)+":[{"+info.substring(y+2, info.length()-2)+"}]}";
			
			
			JSONObject jsonObject = new JSONObject(info);
			JSONArray json_fruit =jsonObject.getJSONArray("Fruit");
			JSONObject empObj = new JSONObject();
			empObj = json_fruit.getJSONObject(0);
			this.value = (double) empObj.get("value");
			this.type = (int) empObj.get("type");
			//this.location = (Point3D)empObj.get("pos");
			String pos = (String)empObj.get("pos");
			Point3D loc = new Point3D(pos);
			this.location=loc;
			
	}
		
		public double getValue() {
			return this.value;
		}
		public Point3D getLocation() {
			return this.location;
		}
		public int getType() {
			return this.type;
		}
		public String toString() {
			return "value: "+this.value+" location: "+this.location+" type: " +this.type;		
			}
}
