class Pfeiler {

  float pfeilerX;
  float pfeilerY;


  Pfeiler() {
    pfeilerX = random(width);
    pfeilerY = random(height);
  }
  void show() {
    rectMode(CENTER);
    rect(pfeilerX, pfeilerY, 30, 140);
  }
}