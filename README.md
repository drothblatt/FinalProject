FinalProject
============

Attempting to recreate Liar's Poker/Liar's Dice. Final version should include: ability to adjust numbers of AI's and dice, funtional AIs in addition to basic LIars Poker/Liars Dice game.

*** WORKING VERSION: FULLY-FUNCTIONAL, JAVA-BASED LIAR'S POKER GAME TO BE PLAYED IN THE TERMINAL (USE Tester.java).
- Set-up and certain aspects of processing also should be working. 

Logs

2014-12-23:
* David: Created the template for Player, including cash, dice, and bid, as well as methods, giveCash(), getDice() and bid().
* Randy: Created the template for Board, including Controlled, Gamblers[], highBid[] isBroke(int a) and beleived(int a).

2014-12-27:
*Randy:
on "Board"
Removed Controlled, added basic version of playRound() which required manual imput,it had problems with cycling to the next round but was functional. Also added isLiar(int a) and beleived(int a).
on "Player"
Recoded bid(), included sperate bid(int a, int b) method to verify answers. Also coded getBid(), howMany(int a) and roll().

2014-12-31:
*David:
on "Player"
Added wordBid() to mad current bid more obvious. Also added AI for bidding (bidAI()) which uses current bids to decide wether to raise or call liar. Also fixed a boolean in bid(int a, int b) which didn't allow for lower Face Value bids.
*Randy:
On "Board"
Managed to smooth out issues cycling by rearanging code in playRound(). Changed initial highBid[] from [0, 0] to [1, 1]

2015-01-01:
*Randy:
on "Board"
added isBroke() boolean, did not implement.

2015-01-05:
*Randy:
Added variable amounts to the number of players and Dice.

2015-01-06:
*David:
Established new constructor for Board class, which uses Scanner to allow user's to select (1) the number of opponents they will face and (2) the buy-in for the sitting, which remains the same for the entire sitting. 
Made some changes to the AI in order to get it working for any input of oponents, not just 6. 

2015-01-07:
*Randy and David (Class):
Fixed AI to work with anywhere between 2 and 6 opponents. 
This was primarily achieved by fixing bidAI method in Player class and playRound method in Board class.
*Randy:
Added omnipotent bidding method, bidGod()

2015-01-08:
*Randy(Class):
Added dumb bidding method, bidDumb().
Removed checks from playRound().
Added dollar sign to String that returns cash amount b/c it's cash
*David(Class):
Looked at the possibilty of having this done in processing. Explored its features and discussed with neighbors. 

2015-01-09:
*Randy(Class): Worked on getting rid of players with no cash
*David(Class): Worked on establishing a cool poker-table type background and cool profiles (circles with dice) to symbolize each player. 

2015-01-10:
*Randy:
Removed broke players from rounds.
*David: 
Updated work on processing. Figured out how to add text and cool buttons (CP5) and researched how to utilize processing.

2015-01-11:
*David: Updated processing such that the setup also included text and buttons. still working out kinks of the buttons. Worked with CP5 (scratched it later because of poor documentation and overall confusion with it).

2015-01-12:
*David: More attempts at fixing the setup using CP5. Worked on buttons and overall background. 

2015-01-13:
*Randy(Class):
Fixed  cycling error (I think)
*David: Decided to avoid CP5. Looked at how to achieve the same endgoal (working buttons) using regular processing. explored the examples on the processing official website. 

2015-01-14:
*Randy(Class):
Implemented hardMode to choose between bidAI() and bidGod()
*David: Looked to make a button class and make an array in order to effectively use buttons. 

2015-01-15:
*David: More work with buttons. Helped Randy figure out some issues with the AI. 

2015-01-16: 
*David: Scratched a lot of the processing work already done. Went a simpler route with buttons. Looked more at processing and tried to figure out how to use the Board class written in java as an effective object that could display text. 

2015-01-18:
*David: Completely Finished worked with buttons. The buttons alter instance variables which are sent into the constructor of Board.java (renamed Game.java for processing). Re-explored work with profiles. Made significant alterations so that these would be properly setup. 

2015-01-19
*Randy: Removed testers, added a round of betting before original to stop players starting with liar calls.
*David: Tried to figure out how to utilize the Game class and turn the java code into effective processing code. Had a lot of issues with this. Nothing seemed to be working. Hopes of a successful processing aspect of the project seem unlikely at this point. 

2015-01-20:
*David: Altered the way in which the Scanners worked so that the user would have a better experience when playing the game in the terminal. Also looked to try and salvage processing, to no avail :(. 

