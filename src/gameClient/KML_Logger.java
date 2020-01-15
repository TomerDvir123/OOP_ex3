package gameClient;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import Server.game_service;
import dataStructure_ex3.edge_data;
import dataStructure_ex3.graph;
import dataStructure_ex3.node_data;

public class KML_Logger {

	game_service game;
	graph grap;

	public KML_Logger() {

	}
	public void setGraph(graph grap) {
		this.grap= grap;
	}
	public graph getGraph(){
		return grap;
	}
	public void setGame(game_service game) {
		this.game= game;
	}
	public game_service getGame(){
		return game;
	}
	public void openKML() {
		Collection<node_data> keep_node = grap.getV();
		
		
		String upper ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\r\n" + 
				"<Document>\r\n" + 
				"	<name>icon.kml</name>\r\n" + 
				"	<Style id=\"sh_wheel_chair_accessible\">\r\n" + 
				"		<IconStyle>\r\n" + 
				"			<color>ffffaa00</color>\r\n" + 
				"			<scale>1.4</scale>\r\n" + 
				"			<Icon>\r\n" + 
				"				<href>http://maps.google.com/mapfiles/kml/shapes/wheel_chair_accessible.png</href>\r\n" + 
				"			</Icon>\r\n" + 
				"			<hotSpot x=\"0.5\" y=\"0\" xunits=\"fraction\" yunits=\"fraction\"/>\r\n" + 
				"		</IconStyle>\r\n" + 
				"		<BalloonStyle>\r\n" + 
				"		</BalloonStyle>\r\n" + 
				"		<ListStyle>\r\n" + 
				"		</ListStyle>\r\n" + 
				"	</Style>\r\n" + 
				"	<StyleMap id=\"msn_wheel_chair_accessible\">\r\n" + 
				"		<Pair>\r\n" + 
				"			<key>normal</key>\r\n" + 
				"			<styleUrl>#sn_wheel_chair_accessible</styleUrl>\r\n" + 
				"		</Pair>\r\n" + 
				"		<Pair>\r\n" + 
				"			<key>highlight</key>\r\n" + 
				"			<styleUrl>#sh_wheel_chair_accessible</styleUrl>\r\n" + 
				"		</Pair>\r\n" + 
				"	</StyleMap>\r\n" + 
				"	<Style id=\"sn_wheel_chair_accessible\">\r\n" + 
				"		<IconStyle>\r\n" + 
				"			<color>ffffaa00</color>\r\n" + 
				"			<scale>1.2</scale>\r\n" + 
				"			<Icon>\r\n" + 
				"				<href>http://maps.google.com/mapfiles/kml/shapes/wheel_chair_accessible.png</href>\r\n" + 
				"			</Icon>\r\n" + 
				"			<hotSpot x=\"0.5\" y=\"0\" xunits=\"fraction\" yunits=\"fraction\"/>\r\n" + 
				"		</IconStyle>\r\n" + 
				"		<BalloonStyle>\r\n" + 
				"		</BalloonStyle>\r\n" + 
				"		<ListStyle>\r\n" + 
				"		</ListStyle>\r\n" + 
				"	</Style>\r\n" + 
				"		<name>ED1.kml</name>\r\n" + 
				"	<StyleMap id=\"m_ylw-pushpin\">\r\n" + 
				"		<Pair>\r\n" + 
				"			<key>normal</key>\r\n" + 
				"			<styleUrl>#s_ylw-pushpin</styleUrl>\r\n" + 
				"		</Pair>\r\n" + 
				"		<Pair>\r\n" + 
				"			<key>highlight</key>\r\n" + 
				"			<styleUrl>#s_ylw-pushpin_hl</styleUrl>\r\n" + 
				"		</Pair>\r\n" + 
				"	</StyleMap>\r\n" + 
				"	<Style id=\"s_ylw-pushpin_hl\">\r\n" + 
				"		<IconStyle>\r\n" + 
				"			<scale>1.3</scale>\r\n" + 
				"			<Icon>\r\n" + 
				"				<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>\r\n" + 
				"			</Icon>\r\n" + 
				"			<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>\r\n" + 
				"		</IconStyle>\r\n" + 
				"		<LineStyle>\r\n" + 
				"			<color>ff0000ff</color>\r\n" + 
				"			<width>2</width>\r\n" + 
				"		</LineStyle>\r\n" + 
				"	</Style>\r\n" + 
				"	<Style id=\"s_ylw-pushpin\">\r\n" + 
				"		<IconStyle>\r\n" + 
				"			<scale>1.1</scale>\r\n" + 
				"			<Icon>\r\n" + 
				"				<href>http://maps.google.com/mapfiles/kml/pushpin/ylw-pushpin.png</href>\r\n" + 
				"			</Icon>\r\n" + 
				"			<hotSpot x=\"20\" y=\"2\" xunits=\"pixels\" yunits=\"pixels\"/>\r\n" + 
				"		</IconStyle>\r\n" + 
				"		<LineStyle>\r\n" + 
				"			<color>ff0000ff</color>\r\n" + 
				"			<width>2</width>\r\n" + 
				"		</LineStyle>\r\n" + 
				"	</Style>";
	
		String ans="";
		for (node_data nd : keep_node) {
			String points ="<Placemark>\r\n" + 
					"			<name>"+ nd.getKey()+"</name>\r\n" + 
					"			<LookAt>\r\n" + 
					"				<longitude>34.8960629819371</longitude>\r\n" + 
					"				<latitude>31.51045941503297</latitude>\r\n" + 
					"				<altitude>0</altitude>\r\n" + 
					"				<heading>0.04263291216809318</heading>\r\n" + 
					"				<tilt>0</tilt>\r\n" + 
					"				<range>105178.7509273705</range>\r\n" + 
					"				<gx:altitudeMode>relativeToSeaFloor</gx:altitudeMode>\r\n" + 
					"			</LookAt>\r\n" + 
					"			<styleUrl>#msn_wheel_chair_accessible</styleUrl>\r\n" + 
					"			<Point>\r\n" + 
					"				<gx:drawOrder>1</gx:drawOrder>\r\n" + 
					"				<coordinates>"+nd.getLocation().x()+","+nd.getLocation().y()+",0</coordinates>\r\n" + 
					"			</Point>\r\n" + 
					"		</Placemark>\r\n" + 
					"";
			ans+=points;
		}
		String edge = "";
		for (node_data nd : keep_node) {
			Collection<edge_data> ed_node = grap.getE(nd.getKey());
			for (edge_data ed : ed_node) {
				double x1=grap.getNode(ed.getSrc()).getLocation().x();
				double y1=grap.getNode(ed.getSrc()).getLocation().y();
				
				double x2=grap.getNode(ed.getDest()).getLocation().x();
				double y2=grap.getNode(ed.getDest()).getLocation().y();
				String edges = "	<Placemark>\r\n" + 
						"		<name>"+ed.getWeight()+"</name>\r\n" + 
						"		<styleUrl>#m_ylw-pushpin</styleUrl>\r\n" + 
						"		<LineString>\r\n" + 
						"			<tessellate>1</tessellate>\r\n" + 
						"			<coordinates>\r\n" + 
						"				"+x1+","+y1+",0 "+x2+","+y2+",0\r\n" + 
						"			</coordinates>\r\n" + 
						"		</LineString>\r\n" + 
						"	</Placemark>\n";
				edge=edge+edges;
			}
		}
		
		String bottom = "	</Document>\r\n" + 
				"</kml>";

		String KML = upper+ans+edge+bottom;
	
		
		saveKML(KML);
		
		//start save the file
	}
	
	public void saveKML(String KML) {
		try {
			FileWriter f1 = new FileWriter("test1.kml");
			f1.write(KML);
			f1.close();
			
//			FileOutputStream f = new FileOutputStream(new File("test1.kml"));
//			ObjectOutputStream o = new ObjectOutputStream(f);
//
//			// Write objects to file
//			o.writeObject(KML);
//			o.close();
//			f.close();
		} catch (RuntimeException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
