package com.argana.dijkstra.tentative1.Swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;

import com.argana.dijkstra.tentative1.Dijkstra;
import com.argana.dijkstra.tentative1.Edge;
import com.argana.dijkstra.tentative1.Vertex;
import com.esisa.models.Shape;

public class DrawPad extends JPanel implements ActionListener,MouseListener{
	private int cp_nodes=0;
	private int cp_arcs=0;
	List<Shape> shapes;
	private int what=0;
	List<Vertex> vex;
	private Dijkstra dd;
public DrawPad() {
	// TODO Auto-generated constructor stub
	shapes=new Vector<>();
	vex=new Vector<>();
	addMouseListener(this);
	dd=new Dijkstra();
}
public void clicked()
{
	repaint();
}
public void addNode(int x ,int y)
{
	Vertex v = new Vertex("N"+cp_nodes);
vex.add(v);
	//test
	Shape s= new Shape("N"+cp_nodes, 0, x, y, 50, 0, 0, 0, 0);
	shapes.add(s);

	cp_nodes++;
	repaint();
}
public Vertex get_vertex(String name) {
	for (Vertex v : vex) {
	
		if(v.toString().equals(name))
		{
			return v;
		
		}
	}
	System.out.println("nullllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
	return null;
}
public void addArc(String node1, String node2, Shape s) {
	Vertex v1=get_vertex(node1);
	Vertex v2=get_vertex(node2);
	System.out.println(v1 +">>"+v2);
	System.out.println("Add neighbour : "+ (int)(Math.random()*50+1)+"from : "+ v1 + "to : "+ v2);
	 v1.addNeighbour(new Edge(1, get_vertex(node1), get_vertex(node2)));
	shapes.add(s);
	
	repaint();
}
public Shape shape_by_name(String name)
{
	for (Shape s : shapes) {
		if(s.getName().equals(name))
		{
			return s;
		}
	}
	return null;
}
@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
	setBackground(Color.yellow);
	g.setColor(Color.BLUE);
	g.drawOval(20, 20, 20, 20);
	
	for (Shape s : shapes) {
		if(s.getType_shape()==0)
		{
			g.setColor(Color.BLUE);
			g.drawOval(s.getX0(), s.getY0(), s.getRayon(), s.getRayon());
			g.drawString( s.getName(),s.getX0()+(s.getRayon()/2)-5, s.getY0()+(s.getRayon()/2));
		}else if(s.getType_shape()==1)
		{
			g.setColor(Color.black);
			g.drawLine(s.getLx1(), s.getLx2(), s.getLy1(), s.getLy2());
			g.drawString(""+s.getX0(),(s.getLx1()+s.getLy1())/2,(s.getLx2()+s.getLy2())/2);
		}
	}
	}

public int getCp_nodes() {
	return cp_nodes;
}
public void setCp_nodes(int cp_nodes) {
	this.cp_nodes = cp_nodes;
}
public List<Shape> getShapes() {
	return shapes;
}
public void setShapes(List<Shape> shapes) {
	this.shapes = shapes;
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
public int getWhat() {
	return what;
}
public void setWhat(int what) {
	this.what = what;
}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	int x=e.getX()-25;
    int y=e.getY()-25;
	if(what==0) {
		addNode(x,y);
		System.out.println(e.getXOnScreen()+ ", "+e.getYOnScreen());
	}
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
public int getCp_arcs() {
	return cp_arcs;
}

}
