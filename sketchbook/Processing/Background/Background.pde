void setup() {
    PImage bg;
    PImage img;
    size(800,800);
    bg = loadImage("table.jpg");
    background(bg);
    
    fill(255,102,0);
    ellipse(400,400,140,140);
    img = loadImage("dice.png");
    image(img,340,345,img.width/2.5,img.height/2.5);
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
          
