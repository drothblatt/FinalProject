  import controlP5.*;
  
  ControlP5 cp5;
  RadioButton r;
  String textValue = "";

  
  void setup() {
    PImage bg;
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
    text("Please Select Number Of Opponents:",400,200);
    text("by Randy Higgins & David Rothblatt",400,100);
    
    
    
    PFont font = createFont("arial",20);

    cp5 = new ControlP5(this);
    
    r = cp5.addRadioButton("radioButton")
           .setPosition(175,250)
           .setSize(40,20)
           .setColorForeground(color(120))
           .setColorActive(color(255))
           .setColorLabel(color(255))
           .setItemsPerRow(5)
           .setSpacingColumn(50)
           .addItem("2",1)
           .addItem("3",2)
           .addItem("4",3)
           .addItem("5",4)
           .addItem("6",5)
           ;
       
       for(Toggle t:r.getItems()) {
         t.captionLabel().setColorBackground(color(140,180));
         t.captionLabel().style().moveMargin(-7,0,0,-3);
         t.captionLabel().style().movePadding(7,0,0,3);
         t.captionLabel().style().backgroundWidth = 45;
         t.captionLabel().style().backgroundHeight = 13;
       }
               
                 
         cp5.addButton("Two")
             .setValue(0)
             .setPosition(300,500)
             .setSize(200,19)
             ;
         cp5.addButton("Three")
             .setValue(100)
             .setPosition(300,520)
             .setSize(200,19)
             ;
         cp5.addButton("Four")
             .setPosition(300,540)
             .setSize(200,19)
             .setValue(0)
             ;
         cp5.addButton("Five")
             .setPosition(300,560)
             .setSize(200,19)
             .setValue(0)
             ;
         cp5.addButton("Six")
             .setPosition(300,580)
             .setSize(200,19)
             .setValue(0)
             ;

  }
  public void clear() {
  cp5.get(Textfield.class,"input").clear();
}
  
  void draw(){
    PImage img;
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
  
                     
                          
