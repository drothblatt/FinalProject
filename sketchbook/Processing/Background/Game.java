import java.util.*;
class Game{
  Random r = new Random();
  public Player[] Gamblers;
  public int[] highBid;
  public double buyin;

  public Game(int nOpponents, int nDice, int nDifficulty){
    highBid = new int[2];
    highBid[1] = 1;
    highBid[0] = 1;
    Gamblers = new Player[nOpponents+1];
    for(int i = 0; i < Gamblers.length; i++){
       Gamblers[i] = new Player(nDice, nDifficulty);
    }   
  }
  
  public void playGame(){
    highBid = new int[2];
    highBid[1] = 1;
    highBid[0] = 1;
    Scanner s = new Scanner(System.in);
    boolean winner = false;
    while(winner == false){
        if(hasCash(0)){
      boolean others = false;
      for(int i = 1; i < Gamblers.length; i++){
         if(hasCash(i))
        others = true;
      }
      if(others)
          playRound();
      else{
          System.out.println("You win");
          winner = true;
      }
        }else{
      System.out.println("You loose");
      winner = true;
        }
    }
    System.out.println("Game over"+"\n"+"Play Again?(Y/N)");
    String b = s.next();
    if(b == "Y" || b == "y"){
        playGame();
    }
    }
    
    public boolean believed(int a){
  boolean belief = false;
  for(int i = 0; i < Gamblers.length; i++){
      if(i == a){
    int d = 69;
      }else{
    if(Gamblers[i].getBid()[0] != -1){
        if(hasCash(i)){
      belief = true;
        }
    }else{
        System.out.println("Gambler" + i + Arrays.toString(Gamblers[i].getBid()));
    }
      }
  }
  return belief;
    }
    
    public void playRound(){
  int a = r.nextInt(Gamblers.length) + 1;
  for(int i = 0; i > Gamblers.length; i++){
      Gamblers[i].reset();
  }
  highBid[0] = 1;
  highBid[1] = 1;
  System.out.println("next round");
  for(int i = 0; i < Gamblers.length; i++){
      Gamblers[i].roll();
  }
  System.out.println(believed(a%Gamblers.length));
  for(int i = a; believed(i%Gamblers.length); i++){
      a++;
      if(hasCash(i%Gamblers.length)){
    try{
        Thread.sleep(r.nextInt(1500) + 500);
    }catch(InterruptedException ex){
        Thread.currentThread().interrupt();
    }
    if((i%Gamblers.length) > 0){
        Gamblers[i%Gamblers.length].bidGod(Gamblers, highBid);
        if(Gamblers[i%Gamblers.length].getBid()[0] != -1){
      highBid = Gamblers[i%Gamblers.length].getBid();
        }
        System.out.println("Gambler "+ i%Gamblers.length +" calls " + Gamblers[i%Gamblers.length].wordBid());
        //text(Gamblers[i%Gamblers.length].wordBid(),100*i,650);
    }else{
        System.out.println("your dice:"+ Arrays.toString(Gamblers[0].getDice()));
        Gamblers[0].bid(highBid[0], highBid[1]);
        if(Gamblers[i%Gamblers.length].getBid()[0] != -1){
      highBid = Gamblers[0].getBid();
        }
        System.out.println("you call " + Gamblers[i%Gamblers.length].wordBid());
    }
      }
  }

  System.out.println("Dice"+"\n"+"You: "+ Arrays.toString(Gamblers[0].getDice()));
  for(int i = 1; i < Gamblers.length; i++){
      if(hasCash(i))
    System.out.println("Gambler"+ i +": "+ Arrays.toString(Gamblers[i].getDice()));
  }

  if(isLiar(a%Gamblers.length)){
      for(int i = 0; i < Gamblers.length; i++){
    if(hasCash(i))
        Gamblers[i].giveMoney(buyin, Gamblers[a%Gamblers.length]);
      }
  }else{
      for(int i = 0; i < Gamblers.length; i++){
    if(hasCash(i))
        Gamblers[a%Gamblers.length].giveMoney(buyin, Gamblers[i]);
      } 
  }

  for(int i = 0; i > Gamblers.length; i++){
      Gamblers[i].reset();
  }
  highBid[0] = 1;
  highBid[1] = 1;
  System.out.println("You: $"+Gamblers[0].getCash());
  for(int i = 1; i < Gamblers.length; i++){
      if(hasCash(i))
    System.out.println("Gambler"+i+": $"+Gamblers[i].getCash());
  }
  System.out.println("\n"+"\n");
    }


    public boolean isLiar(int z){
  int a = 0;
  for(int i = 0; i < Gamblers.length; i++){
      a+=Gamblers[i].howMany(Gamblers[z].getBid()[0]);
  }
  return(a >= Gamblers[z].getBid()[1]);
    }
    public boolean hasCash(int a){
  if(Gamblers[a].getCash() > 0.00)
      return true;
  return false;
    }
      
}
