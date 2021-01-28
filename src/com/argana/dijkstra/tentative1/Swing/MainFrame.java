package com.argana.dijkstra.tentative1.Swing;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.argana.dijkstra.tentative1.Dijkstra;
import com.argana.dijkstra.tentative1.Edge;
import com.argana.dijkstra.tentative1.Vertex;

public class MainFrame extends JFrame implements ActionListener{
	private DrawPad screen;
	private JPanel menu;

	public MainFrame() {
		//dijtra_manuellement();
		screen=new DrawPad();
		setContentPane(screen);
		menu=new JPanel();
		
		JButton b=new JButton("Ajouter Cercle");
		b.addActionListener(this);
		JButton b1=new JButton("Ajouter Arc");
		b1.addActionListener(this);
		JButton b2=new JButton("Dijkstra");
		b2.addActionListener(this);
		menu.add(b2);
		menu.add(b);
		menu.add(b1);
		getContentPane().add(menu);
		
		fenetre();
	}
	void dijtra_manuellement() {
		  Vertex v1 = new Vertex("A");
	        Vertex v2 = new Vertex("B");
	        Vertex v3 = new Vertex("C");
	        Vertex v4 = new Vertex("D");
	        Vertex v5 = new Vertex("E");
	        v1.addNeighbour(new Edge(1, v1, v2));
	        v1.addNeighbour(new Edge(1, v1, v2));
	        v3.addNeighbour(new Edge(1, v3, v4));
	        v2.addNeighbour(new Edge(1, v2, v3));
	        v3.addNeighbour(new Edge(1, v3, v5));
	        v5.addNeighbour(new Edge(1, v5, v4));
	        Dijkstra dijkstra = new Dijkstra();
	        dijkstra.computePath(v1);

	        System.out.println(dijkstra.getShortestPathTo(v4));
	}
	void fenetre()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MainFrame();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b =(JButton) e.getSource();
		if(b.getText().equals("Ajouter Cercle"))
		{
			screen.setWhat(0);
		
		}
		else if(b.getText().equals("Ajouter Arc")){
			ArcFrame af=new ArcFrame(this, screen);
			
		}else if(b.getText().equals("Dijkstra")){
			Dijkstra d= new Dijkstra();
			List<Vertex> vv=screen.vex;
			d.computePath(vv.get(0));
			JOptionPane.showMessageDialog(null, d.getShortestPathTo(vv.get(vv.size()-1)), "Dijkstra", JOptionPane.INFORMATION_MESSAGE);
			System.out.println(d.getShortestPathTo(vv.get(vv.size()-1)));
			
		}
	}

}
