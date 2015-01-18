int nOpponents;
int nDice;
int nCash;
int nDifficulty;
int nBuyIn;

  void setup() {
    PImage bg, img;
    PFont f1, f2;
    size(800,800);
    noStroke();
    bg = loadImage("table.jpg");
    background(bg);
                      
    f1 = createFont("Arial",32,true);
    textFont(f1);
    textAlign(CENTER);
    text("LIAR'S POKER!",400,75);
    
                      
    f2 = createFont("Arial",16,true); 
    textFont(f2);       
    textAlign(CENTER);
    text("Please Select Number Of Opponents:",400,180);
    text("by Randy Higgins & David Rothblatt",400,100);
    text("You",400,695);
    
    fill(255,102,0);
    ellipse(400,600,140,140);
    img = loadImage("dice.png");
    image(img,340,545,img.width/2.5,img.height/2.5); 

    PFont font = createFont("arial",20);
    
    textAlign(CENTER);
    textSize(22);
    strokeWeight(5);
    int z = 200; // starting point for buttons (height)
    for (int i = 0; i < 5; i++){
      fill(14,19,158);
      rect(300,z,200,40);
      z += 50;
    }
    fill(255);
    text("Two", 400,230);
    text("Three", 400,280);
    text("Four", 400,330);
    text("Five", 400,380);
    text("Six", 400,430);
  }

  
void mouseClicked(){
    if(mouseX >= 300 &&  mouseX <= 500 && mouseY >= 200 && mouseY <= 240){
      fill(51);
      nOpponents = 2;
    } else if(mouseX >= 300 &&  mouseX <= 500 && mouseY >= 250 && mouseY <= 290){
      nOpponents = 3;
    } else if (mouseX >= 300 && mouseX <= 500 && mouseY >= 300 && mouseY <= 340){
      nOpponents = 4;
    } else if (mouseX >= 300 && mouseX <= 500 && mouseY >= 350 && mouseY <= 390){
      nOpponents = 5;
    } else if (mouseX >= 300 && mouseX <= 500 && mouseY >= 400 && mouseY <= 440){
      nOpponents = 6;
    }
    System.out.println("Newest Variable");
    System.out.println(nOpponents);
  }

  void draw(){
    /*
    int opponents = 6;
    for (int i = 0; i < opponents; i++){
    img = loadImage("dice.jpeg");
    if (i == 0){
      image(img,100,400,img.width/2,img.height/2);
    }else if (i == 1){
    image(img,200,300,img.width/2,img.height/2);
    }else if(i == 2){
    image(img,300,200, img.width/2,img.height/2);
    }else if (i == 3){
    image(img,400,200,img.width/2,img.height/2);
    }else if (i == 4){
    image(img,500,300,img.width/2,img.height/2);
    }else if (i == 5){
    image(img,600,400,img.width/2,img.height/2);
    }
    }
    */
  }
  
    /*
  public void Two() {
      //activateBy(cp5.RELEASE);
      //if (isOn){
      PImage img;
      fill(255,102,0);
      ellipse(300,400,140,140);
      ellipse(500,400,140,140);
      img = loadImage("dice.png");
      image(img,240,345,img.width/2.5,img.height/2.5);
      image(img,440,345,img.width/2.5,img.height/2.5);
      //}
  }
  */
  
                     
                          
