Use this file to record your reflection on this assignment.

- Tell me about your class! What does it represent?
I wrote a class for drones. Every new instance of the drone has its own name, age, and every drone starts at the origin (0,0). We can examine whether it is in a good condition or it need to be trade in for refurbishment or renewal. After it is turned on, it can pick up items and fly to a specified coordinate. Based on the location, we can determine whether the drone is apporaching the correct direction and we can re-center/reset its flying location by setting coordinate to the origin. When the batter is low ,it will shut down and need to be re-charged. 

- What additional methods (if any) did you implement alongside those listed in the interface?
I implemented a charge() method to update the battery to 100 because rest() didn't particularly fit the action of a drone, so instead I include a charge method so that when the drone is resting, it is turned off and charged.

- What worked, what didn't, what advice would you give someone taking this course in the future?
It is very useful to think of the interface as a contract to fullfill, but initially I was a little constrained and didn't see what kind of class object will satisfy all of these method. However, I think it is important to recognize that we can always implement more than what is required as long as the basic requirement is fullfilled. Also, I think this project is especially useful talking to other people. During class time, I talked to Jenny Gong and Zhirou Liu. We started with the ideas of a robot, then we went on to discover other alternatives such as a robot vacuum and food delivery robot. Then we concluded it is best to work with drone because it best fit to the fly() method. Through brainstorming, we came up with more and more ideas to builds the relevant attributes and creates the methods. 
