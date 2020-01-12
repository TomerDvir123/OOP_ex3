
package gameClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import utils.Point3D;

///////robots:[{"Robot":{"id":0,"value":0.0,"src":0,"dest":-1,"speed":1.0,"pos":"35.212217299435025,32.106235628571426,0.0"}}]
public class myRobot {


	int id ;
	double value ;
	int src ;
	int dest ;
	double speed;
	Point3D location;     // pos

	//{"Fruit":{"value":5.0,"type":-1,"pos":"35.188900353135324,32.105320110855615,0.0"}}
	//{"Fruit":[{"value":5.0,"type":-1,"pos":"35.188900353135324,32.105320110855615,0.0"}]}
	public myRobot(String info) throws JSONException {

		String temp = info.substring(1);
		int y = temp.indexOf("{");
		info = info.substring(0, y)+":[{"+info.substring(y+2, info.length()-2)+"}]}";
		JSONObject jsonObject = new JSONObject(info);
		JSONArray json_fruit =jsonObject.getJSONArray("Robot");
		JSONObject empObj = new JSONObject();
		//int size = json_fruit.length();
		//int j = 0;
		// while(size>0)
		// {
		empObj = json_fruit.getJSONObject(0);
		this.id = (int) empObj.get("id");
		this.value = (double) empObj.get("value");
		this.src = (int) empObj.get("src");
		this.dest = (int) empObj.get("dest");
		this.speed = (double) empObj.get("speed");
		//this.location = (Point3D)empObj.get("pos");
		String pos = (String)empObj.get("pos");
		Point3D loc = new Point3D(pos);
		this.location=loc;
		//size--;
		//j++;
		// }
	}
	
	public double getValue() {     //this.id
		return this.value;
	}
	public Point3D getLocation() {
		return this.location;
	}
	public int getSrc() {
		return this.src;
	}
	public int getId() {
		return this.id;
	}
	public int getDest() {
		return this.dest;
	}
	public double getSpeed() {
		return this.speed;
	}
	// public int numRobot(String rob)
	// {
	// int num = 0;
	//
	//
	//
	//
	// return num;
	// }
	public String toString() {
		return  "id: "+this.id+" value: "+this.value+"src : " +this.src+" dest:"+this.dest+" speed:"+this.speed+" location: "+this.location;
	}
	public void setDest(int dest) {
		this.dest=dest;
	}
	public void setSrc(int src) {
		this.src=src;
	}
	public void setLocation(Point3D loc) {
		this.location = loc;
	}
}
