int rectX,rectY;
color rectColor, baseColor;
color currentColor;
color[] rectsHighlights = new color[5];
boolean[] rectsOver = new boolean[5];
Button[] rects = new Button[5];
color[] changesColor = new color[5];

void setup() {
  size(800, 800);
  rectColor = color(0);
  for (int i = 0; i < rectsHighlights.length; i++){
     rectsHighlights[i] = color(51);
  }
  baseColor = color(102);
  currentColor = baseColor;
  int thisColor = 50;
  for (int i = 0; i < changesColor.length; i++){
      changesColor[i] = color(thisColor);
      thisColor += 50;
  }
} 

void draw() {
  update(mouseX, mouseY);
  int thisLocation = 300;  
  for (int i = 0; i < rects.length; i++){
      rects[i] = new Button(300,thisLocation,200,40,200,51);
      rects[i].makeRect();
      thisLocation += 50;
      System.out.println("button made");
  }
  
  background(currentColor);
  for (int i = 0; i < rectsOver.length; i++){
    if (rectsOver[i]){
      fill(rectsHighlights[i]);
    } else {
      fill(rectColor);
    }
  } 
}

void update(int x, int y) {
  int j = 300;
  for (int i = 0; i < rects.length;i++){
    if (rects[i].
    overRect(300,j,200,40)){
      rectsOver[i] = true;
      j+=50;
    }
  }
}

/*
void update(int x, int y) {
  if ( rect1.overRect(300,300,200,40) ) {
    rectOvers[0] = true;
  } else if (rect2.overRect(300,350,200,40) ){
    rectOvers[1] = true;
  } else if (rect3.overRect(300,400,200,40) ){
    rectOvers[2] = true;
  } else if (rect4.overRect(300,450,200,40) ){
    rectOvers[3] = true;
  } else if (rect5.overRect(300,500,200,40) ){
    rectOvers[4] = true;
  } else {
    for (int i = 0; i < rectOvers.length;i++){
      rectOvers[i] = false;
    }
  }
}
*/


class Button {
  int rectX, rectY;
  int sizeX, sizeY;
  color rectColor, highlightColor, currentColor;
  boolean isOver = false;
  
  Button(int a, int b, int w, int h, color rColor, color rHighlight){
    rectX = a;
    rectY = b;
    sizeX = w;
    sizeY = h;
    rectColor = color(rColor);
    highlightColor = color(rHighlight);
    currentColor = color(255);
  }
  
  void makeRect(){
    stroke(255);
    fill(currentColor);
    rect(rectX, rectY, sizeX, sizeY);
  }
    
  boolean overRect(int x, int y, int width, int height)  {
    if (mouseX >= x && mouseX <= x+width && 
        mouseY >= y && mouseY <= y+height) {
      isOver = true;
      return true;
    } else {
      isOver = false;
      return false;
    }
  }

  void mousePressed() {
    int r = int(random(5));
    if (isOver){
      currentColor = changesColor[r];
      background(currentColor);
    }
  }
  
  void update(){
    if (isOver){
      currentColor = highlightColor;
    } else{
      rectColor = color(102);  
    }
  }   


}
    
  

