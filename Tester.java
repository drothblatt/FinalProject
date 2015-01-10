import java.util.*;
public class Tester{
    public static void main(String[]args){
	Board al = new Board();
	while(al.hasCash(0))
	    al.playRound();
    }
}