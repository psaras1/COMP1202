# Extension to coursework explained:

## Functionality 

- I added a new class called "Research".
Objects of Research represent buildings subsidised by the government.
For a university to build a research facility it needs to have a budget of at least 1000 ECS coins and at least 20000 reputation points.
At the end of each year as long as the university covers the 2 conditions above, it has a 20% chance to build a research facility(based on a random variable).
At the end of each year, the university gains 1000 ECS coins as revenue and 800 reputation points from each research facility.


- Additionally, I added a file called "state.txt". When the user calls the main method with a years parameter, at the end of the simulation they get asked whether they want to save the statistics of their simulation to a text file.
Using a bufferedWriter object, the program writes the user's name along with the statistics of their simulation.
All following users get appended to the file.


- Finally, I've added functionality to save the current state of the simulation to a .dat file.

## Usage

- When the main method is called if 4 arguments are passed:
The first one represents the text file used to populate the market, the second one represents the initial funding of the university, the third one represents the years to be simulated for and the fourth one can be "yes"/"no"(not case-sensitive).
If the answer is yes, the simulation carries out normally but at the end, the saveSimulation method is called which saves the simulation object as a binary stream in a file called "simulation.dat".

- In the case where 2 arguments are passed:
It means that the user wants to continue from the saved simulation. The first argument specifies the file where the progress is saved and the second argument specifies the number of years to simulate for, on top of the additional ones.

- When choosing to save the state of the simulation, the last one saved is overwritten. 
