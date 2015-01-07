import java.util.*;
public class Board{
    Random r = new Random();
    public Player[] Gamblers;
    public int[] highBid;
    public double buyin;

    public Board(){
        System.out.println("Select How Many Players You Want to Play Against (btwn 2 and 6)");
	chooseOpponents();
	System.out.println("Set The Buy-in For Each Round. Keep in Mind You Start With $500.00");
	chooseBuyIn();
	highBid = new int[2];
	highBid[1] = 1;
	highBid[0] = 1;
    }

    public void chooseOpponents(){
	Scanner s = new Scanner(System.in);
	if (s.hasNextInt()){
	    int opponents = s.nextInt();
	    if (2 <= opponents && opponents <= 6){
		Gamblers = new Player[opponents+1];
		for(int i = 0; i < Gamblers.length; i++){
		    Gamblers[i] = new Player();
		}
	    } else{
		System.out.println("Invalid Number. Choose Between 2 and 6.");
		chooseOpponents();
	    }
	} else{
	    System.out.println("Oops, Problem. Must Input Integer.");
	    if (s.hasNextLine()){	
		chooseOpponents();
	    }
	}
    }

    public void chooseBuyIn(){
	Scanner s = new Scanner(System.in);
	if (s.hasNextDouble()){
	    double input = s.nextDouble();
	    if (input > 0 && input <= 500){
		buyin = input;
	    } else{
		System.out.println("Invalid Double. Keep It Positive And Below $500.00"); 
		chooseBuyIn();
	    }
	} else{
	    System.out.println("Oops, Something Went Wrong. " + 
			       "Note That Buy-In Must Be An Integer Or Double.");
	    if (s.hasNextLine()){
		chooseBuyIn();
	    }			 
	}
    }
    
    public boolean believed(int a){
	boolean belief = false;
	for(int i = 0; i < Gamblers.length; i++){
	    if(i != a){
		if(Gamblers[i].getBid()[0] != -1){
		    belief = true;
		}
	    }
	}
	return belief;
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
		Gamblers[i%Gamblers.length].bidAI(highBid[0], highBid[1],Gamblers.length);
		if(Gamblers[i%Gamblers.length].getBid()[0] != -1){
		    highBid = Gamblers[i%Gamblers.length].getBid();
		}
		System.out.println("Gambler "+ i%Gamblers.length +" calls " + Gamblers[i%Gamblers.length].wordBid());
	    }else{
		System.out.println("your dice:"+ Arrays.toString(Gamblers[0].getDice()));
		Gamblers[0].bid(highBid[0], highBid[1]);
		if(Gamblers[i%Gamblers.length].getBid()[0] != -1){
		    highBid = Gamblers[0].getBid();
		}
		System.out.println("you call " + Gamblers[i%Gamblers.length].wordBid());
	    }
	    System.out.println(""+i%Gamblers.length);
	    System.out.println(Arrays.toString(highBid));
	    System.out.println(Arrays.toString(Gamblers[i%Gamblers.length].getBid()));
	}
	System.out.println("Dice"+"\n"+"You:"+ Arrays.toString(Gamblers[0].getDice()));
	for(int i = 1; i < Gamblers.length; i++){
	    System.out.println("Gambler"+ i +":"+ Arrays.toString(Gamblers[i].getDice()));
	}
	if(isLiar()){
	    for(int i = 0; i < Gamblers.length; i++){
		Gamblers[i].giveMoney(buyin, Gamblers[a%Gamblers.length]);
	    }
	}else{
	   for(int i = 0; i < Gamblers.length; i++){
		Gamblers[a%Gamblers.length].giveMoney(buyin, Gamblers[i]);
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
    public boolean isLiar(){
	int a = 0;
	for(int i = 0; i < Gamblers.length; i++){
	    a+=Gamblers[i].howMany(highBid[0]);
	}
	return(a >= highBid[1]);
    }
    public boolean isBroke(int a){
	if(Gamblers[a].getCash() <= 0.00)
	    return true;
	return false;
    }
}
    
