import java.util.*;
public class Board{
    Random r = new Random();
    public Player[] Gamblers = new Player[4];
    public Board(){
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
	int a = r.nextInt(4) + 1;
	for(int i = 0; i < 4; i++){
	    Gamblers[i].roll();
	}
	for(int i = a; believed(i%4); i++){
	    a++;
	    if((i%4) > 0){
		try{
		    Thread.sleep(1000);
		}catch(InterruptedException ex){
		    Thread.currentThread().interrupt();
		}
		Gamblers[i%4].bidAI(highBid[0], highBid[1]);
		if(Gamblers[i%4].getBid()[0] != -1){
		    highBid = Gamblers[i%4].getBid();
		}
		System.out.println("Gambler "+ i%4 +" calls " + Gamblers[i%4].wordBid());
	    }else{
		System.out.println("your dice:"+ Arrays.toString(Gamblers[0].getDice()));
		Gamblers[0].bid(highBid[0], highBid[1]);
		if(Gamblers[i%4].getBid()[0] != -1){
		    highBid = Gamblers[i%4].getBid();
		}
		System.out.println("you call " + Gamblers[i%4].wordBid());
	    }
	}
	System.out.println("Dice"+"\n"+"You:"+ Arrays.toString(Gamblers[0].getDice()));
	for(int i = 1; i < 4; i++){
	    System.out.println("Gambler"+ i +":"+ Arrays.toString(Gamblers[i].getDice()));
	}
	if(isLiar()){
	    for(int i = 0; i < 4; i++){
		Gamblers[i].giveMoney(pot, Gamblers[a%4]);
	    }
	}else{
	   for(int i = 0; i < 4; i++){
		Gamblers[a%4].giveMoney(pot, Gamblers[i]);
	    } 
	}
	for(int i = 0; i > 4; i++){
	    Gamblers[i].reset();
	}
	highBid[0] = 1;
	highBid[1] = 1;
	System.out.println("You:"+Gamblers[0].getCash());
	for(int i = 1; i < 4; i++){
	    System.out.println("Gambler"+i+":"+Gamblers[i].getCash());
	}
	System.out.println("\n"+"\n"+"\n");
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
    