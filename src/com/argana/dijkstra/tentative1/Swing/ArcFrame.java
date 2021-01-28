package com.argana.dijkstra.tentative1.Swing;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.esisa.models.Shape;

public class ArcFrame extends JDialog implements ActionListener {
	private JComboBox<String> start;
	private JComboBox<String> destination;
	private DrawPad pad;
	List<Shape> shapes;
	private JTextField txt;
public ArcFrame(JFrame owner,DrawPad pad) {
	// TODO Auto-generated constructor stub
	super(owner);
	this.pad=pad;
	shapes=pad.shapes;
	setModal(true);
	JPanel p1=new JPanel();
	p1.setLayout(new FlowLayout());
	JLabel l1=new JLabel("Start       ");
	start=new JComboBox<>();
	
	start.setPreferredSize(new Dimension(300,20));
	p1.add(l1);
	
	destination=new JComboBox<>();
	destination.setPreferredSize(new Dimension(300,20));
	JLabel l2=new JLabel("destination");
	JPanel p2=new JPanel();
	p2.setLayout(new FlowLayout());
	p2.add(l2);
	for (Shape s : shapes) {
		if(s.getType_shape()!=1) {
			start.addItem(s.getName());
			destination.addItem(s.getName());
		}
	}
	p2.add(destination);p1.add(start);
	JPanel screen=new JPanel();
	screen.setLayout(new BoxLayout(screen,BoxLayout.Y_AXIS));
	screen.add(p1);
	screen.add(p2);
	JLabel l3=new JLabel("weight");
	 txt=new JTextField(7);
	 txt.setText("5");
	JPanel  p3 = new JPanel();
	p3.setLayout(new FlowLayout());
	p3.add(l3);
	p3.add(txt);
	screen.add(p3);
	
	JButton b=new JButton("add arc");
	b.addActionListener(this);
	screen.add(b);
	setContentPane(screen);
	
	
	
	
	//setResizable(true);
	pack();
	//setSize(200, 200);
	
	setLocation(900,800);
	setVisible(true);
	
	
}
public void add_in_compenoment()
{
	
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
	JButton b=(JButton)e.getSource();
	if(b.getText().equals("add arc")) {
		String source = (String) start.getSelectedItem();
		String destin = (String) destination.getSelectedItem();
		Shape start=pad.shape_by_name(source);
		Shape ending =pad.shape_by_name(destin);
		if(start != null && ending !=null) {
			pad.addArc(source,destin,new Shape("R"+pad.getCp_arcs(), 1, Integer.parseInt(txt.getText()), 0, 0, start.getX0()+25,ending.getX0()+25, start.getY0()+25, ending.getY0()+25));
		}
		
	}
}

}
