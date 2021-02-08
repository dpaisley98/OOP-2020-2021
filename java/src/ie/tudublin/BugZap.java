package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet{

	public void settings(){
		size(1200, 800);
	}

	
	public void setup() {
		playerX=width/2;
		playerY=height-50;
		playerWidth=250;
		bugX=random(width/2);
		bugY=100;
		bugWidth=100;
		spaceShot=0;
		check = false;
		bugAttack=200;
		smooth(); //GAMER SMOOTHNESS
	}

	float playerX, playerY, playerWidth, bugX, bugY, bugWidth, spaceShot, bugAttack;
	boolean check;
	public void draw(){
		background(0);  
		this.drawPlayer(playerX, playerY, playerWidth);
		this.drawBug(bugX, bugY, bugWidth);
		//bugX+=10;
		//bugY+=10;
	}

	public void drawBug(float x, float  y, float w){
		float h = w/2;
		stroke(255, 255, 255);
		strokeWeight(2);
		rectMode(CENTER);//90 110
		line(x,y,x-10,y+10);
		line(x,y,x+10,y+10);
		fill(0, 0, 0);
		rect(x,y-20,w/10,h);
		fill(0, 100, 0);
		ellipse(x,y-30,w*0.3f,((h/5)*3));
		//fill(0, 0, 0);
		//ellipse(92.5f,70,16/2,32/2); 
		//ellipse(107.5f,70,16/2,32/2); 
		if ((frameCount % 15) == 0){
			bugX = random(x-10,x+20);
		}
		if ((frameCount %bugAttack ) == 0){
			bugY+=20;
			if (bugAttack!=20){
			bugAttack-=20;
			}else if(bugAttack>=5){
				bugAttack--;
			}
		}
		fill(0,0,0);
	}

	public void drawPlayer(float x, float y, float w){
		float h = w/6, shipWindow = y-h/4;
		if(!(spaceShot<=0)  && check == true){
			strokeWeight(5);
			stroke(255, 0, 0);
			fill(255,0,0);
			line(x,y,x,0);
			spaceShot-=20;
		}else{
			check=false;
		}
		strokeWeight(3);
		stroke(255, 255, 255);
		noStroke();
		rect(x,y,w/3,h/2);
		stroke(255, 255, 255);
		ellipseMode(CENTER);
		ellipse(x,shipWindow,w/5,h/2);
		noStroke();
		triangle(x, y, x-w/6, y-30, x-w/6, y);
		triangle(x, y, x+w/6, y-30, x+w/6, y);
		fill(0,0,0);
		stroke(255,255,255);
		line(x-w/6, y-30, x-w/6,y+h/4);
		line(x-w/6,y+h/4,x+w/6,y+h/4);
		line(x+w/6, y-30, x+w/6,y+h/4);
		line(x+w/6, y-30, x,y);
		line(x-w/6, y-30, x,y);


	}
	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			//System.out.println("Left arrow pressed");
			if(!((playerX)<=playerWidth/6))
				playerX-=15;		
		}
		if (keyCode == RIGHT)
		{
			//System.out.println("Right arrow pressed");
			if((playerX)<=(width-playerWidth/6))
				playerX+=20;
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
			spaceShot=playerWidth;
			check=true;
			this.hitDetection();
		}
	}

	public void hitDetection() {
		if((bugX<=(playerX+20)) && (bugX>=(playerX-20))){
			System.out.println("AHHHHHHHHHHH");
			bugY = random(100,120);
			bugX = random(100,400);
			bugAttack=200;
		}else{
			System.out.println("Miss");
		}
	}
}
