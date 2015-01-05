import java.util.*;
public class Board{
    Random r = new Random();
    public Player[] Gamblers;
    public Board(){
	Gamblers = new Player[4];
	for(int i = 0; i < 4; i++){
	    Gamblers[i] = new Player();
	}
	highBid[1] = 1;
	highBid[0] = 1;
    }
    public Board(int a){
	Gamblers = new Player[a];
	for(int i = 0; i < 4; i++){
	    Gamblers[i] = new Player();
	}
	highBid[1] = 1;
	highBid[0] = 1;
    }
    
    public boolean believed(int a){
	boolean liar = false;
	for(int i = 0; i < 4; i++){
	    if(i != a){
		if(Gamblers[i].getBid()[0] != -1){
		    liar = true;
		}
	    }
	}
	return liar;
    }
    
    public void playRound(){
	System.out.println("next round");
	int a = r.nextInt(Gamblers.length) + 1;
	for(int i = 0; i < Gamblers.length; i++){
	    Gamblers[i].roll();
	}
	for(int i = a; believed(i%Gamblers.length); i++){
	    a++;
	    if((i%Gamblers.length) > 0){
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException ex){
		    Thread.currentThread().interrupt();
		}
		Gamblers[i%Gamblers.length].bidAI(highBid[0], highBid[1]);
		if(Gamblers[i%Gamblers.length].getBid()[0] != -1){
		    highBid = Gamblers[i%Gamblers.length].getBid();
		}
		System.out.println("Gambler "+ i%Gamblers.length +" calls " + Gamblers[i%4].wordBid());
	    }else{
		System.out.println("your dice:"+ Arrays.toString(Gamblers[0].getDice()));
		Gamblers[0].bid(highBid[0], highBid[1]);
		if(Gamblers[i%Gamblers.length].getBid()[0] != -1){
		    highBid = Gamblers[i%Gamblers.length].getBid();
		}
		System.out.println("you call " + Gamblers[i%Gamblers.length].wordBid());
	    }
	}
	System.out.println("Dice"+"\n"+"You:"+ Arrays.toString(Gamblers[0].getDice()));
	for(int i = 1; i < Gamblers.length; i++){
	    System.out.println("Gambler"+ i +":"+ Arrays.toString(Gamblers[i].getDice()));
	}
	if(isLiar()){
	    for(int i = 0; i < Gamblers.length; i++){
		Gamblers[i].giveMoney(pot, Gamblers[a%Gamblers.length]);
	    }
	}else{
	   for(int i = 0; i < Gamblers.length; i++){
		Gamblers[a%Gamblers.length].giveMoney(pot, Gamblers[i]);
	    } 
	}
	for(int i = 0; i > Gamblers.length; i++){
	    Gamblers[i].reset();
	}
	highBid[0] = 1;
	highBid[1] = 1;
	System.out.println("You:"+Gamblers[0].getCash());
	for(int i = 1; i < Gamblers.length; i++){
	    System.out.println("Gambler"+i+":"+Gamblers[i].getCash());
	}
	System.out.println("\n"+"\n");
    }

    public int[] highBid = new int[2];
    public boolean isLiar(){
	int a = 0;
	for(int i = 0; i<4; i++){
	    a+=Gamblers[i].howMany(highBid[0]);
	}
	return(a >= highBid[1]);
    }
    public double pot = 50.00;
    public boolean isBroke(int a){
	if(Gamblers[a].cash <= 0.00)
	    return true;
	return false;
    }
}
    