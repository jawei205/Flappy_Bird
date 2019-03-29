float birdX ;
float birdY;
float xoff;
int score = 0;
int g;
Pfeiler[] pfeiler = new Pfeiler[5];

void setup() {
  size(1680, 600);
  g=width/1000;
  birdX = width/9;
  birdY = height/2;  
  score=0;
  for (int i = 0; i < pfeiler.length; i++) {
    pfeiler[i]= new Pfeiler();
  }
}

void draw() {
  background(51);
  noStroke();

  for (int i  =0; i < pfeiler.length; i++) {
    pfeiler[i].show();
    ellipse(birdX, birdY, 30, 30);   
    birdX+=0.7;

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



void keyPressed() {
  if (keyCode==UP) {
    birdY -= 15;
  }
  if (keyCode==DOWN) {
    birdY += 15;
  }
}