int rectX,rectY;
color rectColor, baseColor;
color currentColor;
color[] rectHighlights = new color[5];
boolean[] rectOvers = new boolean[5];
Button[] rects = new rect[5];

void setup() {
  size(800, 800);
  rectColor = color(0);
  for (int i = 0; i < rectHighlights.length; i++){
     rectHighlights[i] = color(51);
  }
  baseColor = color(102);
  currentColor = baseColor;
  Button r1 = new Button(300, 300, 200, 40, 200, 51); // Two
  Button r2 = new Button(300, 350, 200, 40, 200, 51); // Three
  Button r3 = new Button(300, 400, 200, 40, 200, 51); // Four
  Button r4 = new Button(300, 450, 200, 40, 200, 51); // Five
  Button r5 = new Button(300, 500, 200, 40, 200, 51); // Six
} 

void draw() {
  update(mouseX, mouseY);
  background(currentColor);
  for (int i = 0; i < rectOvers.length; i++){
    if (rectOvers[i]){
      fill(rectHighlights[i]);
    } else {
      fill(rectColor);
    }
  } 
  
  stroke(255);
  rect(300, 300, 200, 40); // Two
  rect(300, 350, 200, 40); // Three
  rect(300, 400, 200, 40); // Four
  rect(300, 450, 200, 40); // Five
  rect(300, 500, 200, 40); // Six

}

void update(int x, int y) {
  for (int i = o; i < rects.length;i++){
    
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
    rect(rectX, rectY, sizeX, sizeY);
  }
    
  boolean overRect(int x, int y, int width, int height)  {
    if (mouseX >= x && mouseX <= x+width && 
        mouseY >= y && mouseY <= y+height) {
      isOver = true;
    } else {
      isOver = false;
    }
  }

  void mousePressed() {
    if (isOver){
      currentColor = color(i + 10*i);
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
    
  

