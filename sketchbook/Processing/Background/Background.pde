
int nOpponents;
int nDice;
int nCash;
int nDifficulty;
int nBuyIn;

void setup(){
    size(800,800);
}

void draw(){
    PImage bg, img;
    bg = loadImage("background.png");
    background(bg);
    noStroke();
    img = loadImage("dice.png");
    
    if (nOpponents == 0){
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
      textSize(16);
      text("Please Select Number Of Opponents:",400,180);
    }
   
    else if (nDice == 0){
      textAlign(CENTER);
      textSize(22);
      strokeWeight(5);
      int z = 200; // starting point for buttons (height)
      for (int i = 0; i < 4; i++){
        fill(0,153,0);
        rect(300,z,200,40);
        z += 50;
      }
      fill(255);
      text("Five", 400,230);
      text("Six", 400,280);
      text("Seven", 400,330);
      text("Eight", 400,380);
      textSize(16);
      text("Please Select Number Of Dice Per Person:",400,180);
    }
    
    else if (nDifficulty == 0){
      textAlign(CENTER);
      textSize(22);
      strokeWeight(5);
      fill(255,128,0);
      rect(300,200,200,40);
      rect(300,250,200,40);
      fill(255);
      text("Easy", 400,230);
      text("Hard", 400,280);
      textSize(16);
      text("Please Select Difficulty",400,180);
    }
    int profiles = 1;
    int x = 0;
    int y = 0;
    
    if (nOpponents > 0 && nDifficulty >0 && nOpponents%2 == 0){
      while (profiles <= nOpponents){
       fill(255,102,0);
       ellipse(320-x,240+y,140,140);
       ellipse(480+x,240+y,140,140);
       image(img,260-x,185+y,img.width/2.5,img.height/2.5);
       image(img,420+x,185+y,img.width/2.5,img.height/2.5);
       x += 120;
       y += 110;
       profiles += 2;
      }
      int r = 360 + x;
      int s = 130 + y;
      while (profiles > 0){
        fill(255);
        textSize(13);
        text("Gambler" /*+ profiles*/, r, s);
        if (profiles > nOpponents/2 + 1){
          r -= 120;
          s -= 110; 
        } else if (profiles > 0){
          r += 120;
          s += 110;
        }
        profiles--;
      }
    }
    
    if (nOpponents > 0 && nDifficulty > 0 && nOpponents%2 == 1){
       x = 120;
       y = 80;
       fill(255,102,0);
       ellipse(400,200,140,140);
       image(img,340,145,img.width/2.5,img.height/2.5);
       profiles++;
       while (profiles <= nOpponents){
         fill(255,102,0); 
         ellipse(400-x,240+y,140,140);
         ellipse(400+x,240+y,140,140);
         image(img,340-x,185+y,img.width/2.5,img.height/2.5);
         image(img,340+x,185+y,img.width/2.5,img.height/2.5);
         x += 120;
         y += 110;
         profiles += 2;
      }
      int r = 400 + x;
      int s = 240 + y;
      while (profiles > 0){
        fill(255);
        textSize(13);
        text("Gambler" /*+ profiles*/, r, s);
        r -= 120;
        s -= 110; 
        profiles--;
        System.out.println("text written at: " + r + " " + s);
        System.out.println("profiles left:" + profiles); 
      }
    }
    Game g = new Game(nOpponents,nDice,nDifficulty);
    //g.playGame();
}

void mouseClicked(){
    if (nOpponents == 0){
    choosingOpponents();
    } else if (nOpponents > 0 && nDice == 0){
      choosingDice();
    } else{
      choosingDifficulty();
    } 
}

void choosingOpponents(){
    if(mouseX >= 300 &&  mouseX <= 500 && mouseY >= 200 && mouseY <= 240){
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
    System.out.println("Opponents:");
    System.out.println(nOpponents);
}

void choosingDice(){
  if(mouseX >= 300 &&  mouseX <= 500 && mouseY >= 200 && mouseY <= 240){
      nDice = 5;
    } else if(mouseX >= 300 &&  mouseX <= 500 && mouseY >= 250 && mouseY <= 290){
      nDice = 6;
    } else if (mouseX >= 300 && mouseX <= 500 && mouseY >= 300 && mouseY <= 340){
      nDice = 7;
    } else if (mouseX >= 300 && mouseX <= 500 && mouseY >= 350 && mouseY <= 390){
      nDice = 8;
    }
    System.out.println("Dice:");
    System.out.println(nDice);
}

void choosingDifficulty(){
    if(mouseX >= 300 &&  mouseX <= 500 && mouseY >= 200 && mouseY <= 240){
      nDifficulty = 1;
    } else if(mouseX >= 300 &&  mouseX <= 500 && mouseY >= 250 && mouseY <= 290){
      nDifficulty = 2;
    } 
    System.out.println("Difficulty:");
    System.out.println(nDifficulty);
}

                          
