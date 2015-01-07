FinalProject
============

Attempting to recreate Liar's Poker/Liar's Dice. Final version should include: ability to adjust numbers of AI's and dice, funtional AIs in addition to basic LIars Poker/Liars Dice game.

Schedule:
12.23.2014
David: Created the template for Player, including cash, dice, and bid, as well as methods, giveCash(), getDice() and bid().

Randy: Created the template for Board, including Controlled, Gamblers[], highBid[] isBroke(int a) and beleived(int a).

12.27.2014
Randy:
on "Board"
Removed Controlled, added basic version of playRound() which required manual imput,it had problems with cycling to the next round but was functional. Also added isLiar(int a) and beleived(int a).
on "Player"
Recoded bid(), included sperate bid(int a, int b) method to verify answers. Also coded getBid(), howMany(int a) and roll().

12.31.2014
David:
on "Player"
Added wordBid() to mad current bid more obvious. Also added AI for bidding (bidAI()) which uses current bids to decide wether to raise or call liar. Also fixed a boolean in bid(int a, int b) which didn't allow for lower Face Value bids.
Randy:
On "Board"
Managed to smooth out issues cycling by rearanging code in playRound(). Changed initial highBid[] from [0, 0] to [1, 1]

1.1.2015
Randy:
on "Board"
added isBroke() boolean, did not implement.

1.5.2015
Randy:
Added variable amounts to the number of players and Dice.

2015-01-06
David:
Established new constructor for Board class, which uses Scanner to allow user's to select (1) the number of opponents they will face and (2) the buy-in for the sitting, which remains the same for the entire sitting. 
Made some changes to the AI in order to get it working for any input of oponents, not just 6.  
