package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing2 extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		
	}
	
	public void draw()
	{	
		background(255,0,0);
		stroke(0,255,0);
		//line(10, 10, 200, 200);
		noStroke();
		fill(255,255,0);
		ellipse(250,300,400,400);//cx,cy,w,h
		fill(0,230,255);
		//rect(20, 100, 70, 90);
		triangle(250,10,50,450,450,450);
		fill(192,192,192);
		ellipse(250,250,200,100);//cx,cy,w,h
		fill(0);
		ellipse(250,250,80,mouseY);//cx,cy,w,h
		//text("Hello World",300,300);
	}
}
