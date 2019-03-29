import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Flappy_Bird extends PApplet {

float birdX ;
float birdY;
float xoff;
int score = 0;
int g;
Pfeiler[] pfeiler = new Pfeiler[5];

public void setup() {
  
  g=width/1000;
  birdX = width/9;
  birdY = height/2;  
  score=0;
  for (int i = 0; i < pfeiler.length; i++) {
    pfeiler[i]= new Pfeiler();
  }
}

public void draw() {
  background(51);
  noStroke();

  for (int i  =0; i < pfeiler.length; i++) {
    pfeiler[i].show();
    ellipse(birdX, birdY, 30, 30);   
    birdX+=0.7f;

    if (dist(birdX, birdY, pfeiler[i].pfeilerX, pfeiler[i].pfeilerY) < 90) { 
      score = 0;
      birdX = width/9;
      birdY = height/2;
    }
  }



  if (birdX>=width) {
    birdX=width/9;
    for (int i = 0; i < pfeiler.length; i++) {
      pfeiler[i]= new Pfeiler();
    }
    score++;
  }
  textSize(32);
  text("Score:" + score, 35, 40);
}



public void keyPressed() {
  if (keyCode==UP) {
    birdY -= 15;
  }
  if (keyCode==DOWN) {
    birdY += 15;
  }
}
class Pfeiler {

  float pfeilerX;
  float pfeilerY;


  Pfeiler() {
    pfeilerX = random(width);
    pfeilerY = random(height);
  }
  public void show() {
    rectMode(CENTER);
    rect(pfeilerX, pfeilerY, 30, 140);
  }
}
  public void settings() {  size(1680, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Flappy_Bird" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
