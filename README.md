FinalProject
============

Attempting to recreate Liar's Poker/Liar's Dice. Final version should include: ability to adjust numbers of AI's and dice, funtional AIs in addition to basic LIars Poker/Liars Dice game.

Logs

2014-12-23
David: Created the template for Player, including cash, dice, and bid, as well as methods, giveCash(), getDice() and bid().

Randy: Created the template for Board, including Controlled, Gamblers[], highBid[] isBroke(int a) and beleived(int a).

2014-12-27
Randy:
on "Board"
Removed Controlled, added basic version of playRound() which required manual imput,it had problems with cycling to the next round but was functional. Also added isLiar(int a) and beleived(int a).
on "Player"
Recoded bid(), included sperate bid(int a, int b) method to verify answers. Also coded getBid(), howMany(int a) and roll().

2014-12-31
David:
on "Player"
Added wordBid() to mad current bid more obvious. Also added AI for bidding (bidAI()) which uses current bids to decide wether to raise or call liar. Also fixed a boolean in bid(int a, int b) which didn't allow for lower Face Value bids.
Randy:
On "Board"
Managed to smooth out issues cycling by rearanging code in playRound(). Changed initial highBid[] from [0, 0] to [1, 1]

2015-01-01
Randy:
on "Board"
added isBroke() boolean, did not implement.

2015-01-05
Randy:
Added variable amounts to the number of players and Dice.

2015-01-06
David:
Established new constructor for Board class, which uses Scanner to allow user's to select (1) the number of opponents they will face and (2) the buy-in for the sitting, which remains the same for the entire sitting. 
Made some changes to the AI in order to get it working for any input of oponents, not just 6. 

2015-01-07
Randy and David (Class):
Fixed AI to work with anywhere between 2 and 6 opponents. 
This was primarily achieved by fixing bidAI method in Player class and playRound method in Board class.
Randy:
Added omnipotent bidding method, bidGod()

2015-01-08
Randy(Class):
Added dumb bidding method, bidDumb().
Removed checks from playRound().
Added dollar sign to String that returns cash amount b/c it's cash

2015-01-09:
Randy(Class): Worked on getting rid of players with no cash
David(Class): Worked on 

2015-01-10:
Randy:
Removed broke players from rounds.
David: 
Updated work on processing. Figured out how to add text and cool buttons (CP5) and researched how to utilize processing.

2015-01-13
Randy(Class)
Fixed  cycling error (I think)
