
int nOpponents;
int nDice;
int nCash;
int nDifficulty;
int nBuyIn;
boolean run = false;

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
      text("Please Select Difficulty:",400,180);
    }
    makeProfiles();
    //Game4 g = new Game4(nOpponents,nDice,nDifficulty);
    if (run){
      System.out.println(nDifficulty);
      //g.display();
      makeProfiles();
    }
}

void makeProfiles() {
    int profiles = 1;
    int x = 0;
    int y = 0;
    PImage img = loadImage("dice.png");
    
    if (nOpponents > 0 && nDifficulty > 0 && nOpponents%2 == 0){
      while (profiles <= nOpponents){
       fill(255,102,0);
       ellipse(337.5-x,200,100,100);
       ellipse(462.5+x,200,100,100);
       image(img,290-x,155,img.width/3.5,img.height/3.5);
       image(img,415+x,155,img.width/3.5,img.height/3.5);
       x += 125;
       profiles += 2;
      }
      float pos = 337.5 - x + 125; // move back to second to last pos. 
      fill(255);
      for (int i = 1; i <= nOpponents; i++){
        text("Gambler " + i + ":", pos, 270);
        pos += 125;
      }
    }

    if (nOpponents > 0 && nDifficulty > 0 && nOpponents%2 == 1){
       x = 125;
       fill(255,102,0);
       ellipse(400,200,100,100);
       image(img,352.5,155,img.width/3.5,img.height/3.5);
       profiles++;
       while (profiles <= nOpponents){
         fill(255,102,0); 
         ellipse(400-x,200,100,100);
         ellipse(400+x,200,100,100);
         image(img,352.5-x,155,img.width/3.5,img.height/3.5);
         image(img,352.5+x,155,img.width/3.5,img.height/3.5);
         x += 125;
         profiles += 2;
      }
      float pos = 400 - x + 125; // move back to second to last x pos. 
      fill(255);
      for (int i = 1; i <= nOpponents; i++){
        text("Gambler " + i + ":", pos, 270);
        pos += 125;
      }
    }
    fill(255);
    textSize(13);
    textAlign(CENTER);
    /*
    if (nDifficulty > 0){
      if (nOpponents == 2){
         text("Gambler 1:", 317.5, 325);
         text("Gambler 2:", 480, 325);
      } else if(nOpponents == 3){
         text("Gambler 1:", 280, 410);
         text("Gambler 2:", 400, 290);
         text("Gambler 3:", 520, 410);
      } else if(nOpponents == 4){
         text("Gambler 1:", 200, 435);
         text("Gambler 2:", 320, 325);
         text("Gambler 3:", 480, 325);
         text("Gambler 4:", 610, 435);
      } else if(nOpponents == 5){
         text("Gambler 1:", 160, 520);
         text("Gambler 2:", 280, 410);
         text("Gambler 3:", 400, 290);
         text("Gambler 4:", 520, 410);
         text("Gambler 5:", 640, 520);
      } else if (nOpponents == 6){
         text("Gambler 1:",  80, 545); 
         text("Gambler 2:", 200, 435);
         text("Gambler 3:", 320, 325);
         text("Gambler 4:", 480, 325);
         text("Gambler 5:", 610, 435);
         text("Gambler 6:", 730, 545);
      }    
      
    run = true;  
    }
    */
}


/*
void display(){
    Game4 g = new Game4(nOpponents,nDice,nDifficulty);
    g.playRound();
    for (int i = 1; i <= nOpponents; i++){
      text("Gambler "+ i +" calls " + g.Gamblers[i].wordBid(), 100*i, 100);
    }

      
      
    //}
    //System.out.println(g.Gamblers[0].getDice());
    //int[] myDice = g.Gamblers[0].getDice();
    //String strDice = "[ ";
    //for (int i = 0; i < myDice.length; i++){
    //  strDice += " " + myDice[i];
    //}
    //strDice += " ]";
    //textSize(15);
    //text(strDice,400,750);
}
*/

void mouseClicked(){
    if (nOpponents == 0){
      choosingOpponents();
    } else if (nOpponents > 0 && nDice == 0){
      choosingDice();
    } else if (nDifficulty == 0){
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

                          
