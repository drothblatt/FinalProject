import java.util.*;
public class Board{
    Random r = new Random();
    public Player[] Gamblers;
    public int[] highBid;
    public double buyin;
    public int d;
    public boolean hardMode;

    public Board(){
	highBid = new int[2];
	highBid[1] = 1;
	highBid[0] = 1;
	System.out.println("\nLIAR'S POKER v1.0" + "\nBy Randy Higgins & David Rothblatt"
			   + "\nAPCS     Fall 2014-15     Mr. Konstantinovich \n" + "\n>> Let's Begin!" );
    }

    public void chooseOpponents(){
	Scanner s = new Scanner(System.in);
	if (s.hasNextInt()){
	    int opponents = s.nextInt();
	    if (2 <= opponents && opponents <= 6){
		Gamblers = new Player[opponents+1];
	    } else{
		System.out.println(">> Invalid Number. Choose Between 2 and 6.");
		chooseOpponents();
	    }
	} else{
	    System.out.println(">> Oops, Problem. Must Input Integer.");
	    if (s.hasNextLine()){	
		chooseOpponents();
	    }
	}
    }

    public void chooseDice(){
	Scanner s = new Scanner(System.in);
	if (s.hasNextInt()){
	    int y = s.nextInt();
	    if (y >= 5 && y <= 8){
		d = y;
	    } else{
		System.out.println(">> Invalid Number. Choose Between 5 and 8.");
		chooseDice();
	    }
	} else{
	    System.out.println(">> Oops, Problem. Must Input Integer.");
	    if (s.hasNextLine()){	
		chooseDice();
	    }
	}
    }

    public void chooseMode(){
	Scanner s = new Scanner(System.in);
	if (s.hasNextLine()){
	    String next = s.nextLine();
	    hardMode = (next == "Y" || next == "y" || next == "yes" || next == "Yes");
	} else{
	    System.out.println(">> Oops, Problem. Must Answer. Not Case Sensitive. ");
	    chooseMode();
	}
    }
    
    public void chooseBuyIn(){
	Scanner s = new Scanner(System.in);
	if (s.hasNextDouble()){
	    double input = s.nextDouble();
	    if (input > 0 && input <= 500){
		buyin = input;
	    } else{
		System.out.println(">> Invalid Double. Keep It Positive And Below $500.00"); 
		chooseBuyIn();
	    }
	} else{
	    System.out.println(">> Oops, Something Went Wrong. " + 
			       "Note That Buy-In Must Be An Integer Or Double.");
	    if (s.hasNextLine()){
		chooseBuyIn();
	    }			 
	}
    }
    public void playGame(){
	System.out.println(">> Select How Many Players You Want to Play Against (btwn 2 and 6)");
	chooseOpponents();
	System.out.println(">> Select How Many Dice You Want Per Player (btwn 5 and 8)");
	chooseDice();
	System.out.println(">> Would You Like To Play The Harder Mode?" + 
			   "\n>> (Type Y or Yes to answer yes. Otherwise, We Will Assume You Choose No.)");
	chooseMode();
	System.out.println(">> Set The Buy-in For Each Round. Keep in Mind You Start With $500.00");
	chooseBuyIn();

	for(int i = 0; i < Gamblers.length; i++){
	    Gamblers[i] = new Player(d, hardMode);
	}

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
		    System.out.println(">> You Win!!!");
		    winner = true;
		}
	    }else{
		System.out.println(">> You Lose...");
		winner = true;
	    }
	}
	System.out.println(">> Game over..."+"\n"+"Play Again? (Y/N)");
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
	System.out.println("-----------\n" + "Next Round:");
	if (a < Gamblers.length){
	    System.out.println("\n>> Gambler " + a + " Starts\n");
	} else if (a == Gamblers.length){
	    System.out.println("\n>> You Start.\n ");
	}
	for(int i = 0; i < Gamblers.length; i++){
	    Gamblers[i].roll();
	}
	int b = a;
	for(int i = b; a - b < Gamblers.length; i++){
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
		    System.out.println(">> Gambler "+ i%Gamblers.length +" Calls: " + Gamblers[i%Gamblers.length].wordBid());
		}else{
		    System.out.println(">> Your Dice:"+ Arrays.toString(Gamblers[0].getDice()));
		    Gamblers[0].bid(highBid[0], highBid[1]);
		    if(Gamblers[i%Gamblers.length].getBid()[0] != -1){
			highBid = Gamblers[0].getBid();
		    }
		    System.out.println(">> You Call: " + Gamblers[i%Gamblers.length].wordBid());
		}
	    }
	}
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
		    System.out.println(">> Gambler "+ i%Gamblers.length +" Calls: " + Gamblers[i%Gamblers.length].wordBid());
		}else{
		    System.out.println("\n>> Your Dice:"+ Arrays.toString(Gamblers[0].getDice()));
		    Gamblers[0].bid(highBid[0], highBid[1]);
		    if(Gamblers[i%Gamblers.length].getBid()[0] != -1){
			highBid = Gamblers[0].getBid();
		    }
		    System.out.println(">> You Call: " + Gamblers[i%Gamblers.length].wordBid());
		}
	    }
	}

	System.out.println("\n>> Round Over... Results:\n>> Dice:"+"\n"+">>>>   You: "+ Arrays.toString(Gamblers[0].getDice()));
	for(int i = 1; i < Gamblers.length; i++){
	    if(hasCash(i))
		System.out.println(">>>>   Gambler "+ i +": "+ Arrays.toString(Gamblers[i].getDice()));
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
	System.out.println("\n>> Cash Update:\n" +">>>>   You: $"+Gamblers[0].getCash());
	for(int i = 1; i < Gamblers.length; i++){
	    if(hasCash(i))
		System.out.println(">>>>   Gambler"+i+": $"+Gamblers[i].getCash());
	}
	System.out.println("\n");
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
    
