import java.util.*;
public class Board{
    public Player[] Gamblers = new Player[4];
    public Board(){
	for(int i = 0; i < 4; i++){
	    Gamblers[i] = new Player();
	}
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
	int a = 0;
	for(int i = 0; i < 4; i++){
	    System.out.println(""+i);
	    Gamblers[i].roll();
	}
	for(int i = 0; believed(i%4); i++){
	    a++;
	    System.out.println("Player" + (i%4+1));
	    Gamblers[i%4].bid(highBid[0], highBid[1]);
	    if(Gamblers[i%4].getBid()[0] != -1){
		highBid = Gamblers[i%4].getBid();
	    }
	}
	for(int i = 0; i < 4; i++){
	    System.out.println("player"+ (i+1) +":"+ 
			       Arrays.toString(Gamblers[i].
			       getDice()));
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
	for(int i = 0; i < 4; i++){
	    System.out.println("player"+(i+1)+":"+Gamblers[i].getCash());
	}
	for(int i = 0; i > 4; i++){
	    Gamblers[i].reset();
	}
    }
    
    public int Controlled;
    public int[] highBid = new int[2];
    public boolean isLiar(){
	int a = 0;
	for(int i = 0; i<4; i++){
	    a+=Gamblers[i].howMany(highBid[0]);
	}
	return(a >= highBid[1]);
    }
    public double pot = 50.00;
}
    