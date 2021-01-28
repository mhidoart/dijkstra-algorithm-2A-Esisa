package com.esisa.models;

public class Shape {
	private int type_shape=0;
	private int x0,y0,rayon;
	private int lx1,ly1,lx2,ly2;
	private String name;
public Shape() {
	// TODO Auto-generated constructor stub
}
public Shape(String name,int type_shape, int x0, int y0, int rayon, int lx1, int ly1,
		int lx2, int ly2) {
	super();
	this.name=name;
	this.type_shape = type_shape;
	this.x0 = x0;
	this.y0 = y0;
	this.rayon = rayon;
	this.lx1 = lx1;
	this.ly1 = ly1;
	this.lx2 = lx2;
	this.ly2 = ly2;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getType_shape() {
	return type_shape;
}
public void setType_shape(int type_shape) {
	this.type_shape = type_shape;
}
public int getX0() {
	return x0;
}
public void setX0(int x0) {
	this.x0 = x0;
}
public int getY0() {
	return y0;
}
public void setY0(int y0) {
	this.y0 = y0;
}
public int getRayon() {
	return rayon;
}
public void setRayon(int rayon) {
	this.rayon = rayon;
}

public int getLx1() {
	return lx1;
}
public void setLx1(int lx1) {
	this.lx1 = lx1;
}
public int getLy1() {
	return ly1;
}
public void setLy1(int ly1) {
	this.ly1 = ly1;
}
public int getLx2() {
	return lx2;
}
public void setLx2(int lx2) {
	this.lx2 = lx2;
}
public int getLy2() {
	return ly2;
}
public void setLy2(int ly2) {
	this.ly2 = ly2;
}




}
