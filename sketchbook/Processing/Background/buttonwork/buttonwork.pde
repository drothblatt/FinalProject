int rectX,rectY;
color rectColor, baseColor;
color rectHighlight2,rectHighlight3,rectHighlight4,rectHighlight5,rectHighlight6;
color currentColor;
boolean rectOver2,rectOver3,rectOver4,rectOver5,rectOver6;

color[] rectHighlights = new color[5];
boolean[] rectOvers = new boolean[5];

void setup() {
  size(800, 800);
  rectColor = color(0);
  for (int i = 0; i < rectHighlights.length; i++){
     rectHighlights[i] = color(51);
  }
  baseColor = color(102);
  currentColor = baseColor;
  rectOver2 = false;
} 

void draw() {
  update(mouseX, mouseY);
  background(currentColor);
  
  if (rectOvers[0]) {
    fill(rectHighlights[0]);
  } else {
    fill(rectColor);
  }
  stroke(255);
  rect(300, 300, 200, 40); // Two
  rect(300, 350, 200, 40); // Three
  rect(300, 400, 200, 40); // Four
  rect(300, 450, 200, 40); // Five
  rect(300, 500, 200, 40); // Six

}

void update(int x, int y) {
  if ( overRect(300,300,200,40) ) {
    rectOvers[0] = true;
  } else if (overRect(300,350,200,40) ){
    rectOvers[1] = true;
  } else if (overRect(300,400,200,40) ){
    rectOvers[2] = true;
  } else if (overRect(300,450,200,40) ){
    rectOvers[3] = true;
  } else if (overRect(300,500,200,40) ){
    rectOvers[4] = true;
  } else {
    for (int i = 0; i < rectOvers.length;i++){
      rectOvers[i] = false;
    }
  }
}

void mousePressed() {
  for (int i = 0; i < rectOvers.length; i++){
      if (rectOvers[i]){
          currentColor = color(i + 10*i);
      }
  }
}

boolean overRect(int x, int y, int width, int height)  {
  if (mouseX >= x && mouseX <= x+width && 
      mouseY >= y && mouseY <= y+height) {
    return true;
  } else {
    return false;
  }
}

