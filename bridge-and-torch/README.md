# Bridge and Torch problem
This dojo combines a logical puzzle with programming. 
The problem should first be solved for the base case (first example input), without using any computers!
When a solution is found for the first case, the challenge is to write a program that can solve it for any input. Even when more than 40 people are involved! 

## problem
A number of people need to cross a bridge at night
* There is 1 torch, which is needed to cross the bridge (and needs to be brought back for the next crossing)
* Max 2 people can cross the bridge at a time
* Every person moves at their own pace. 
* When two people cross, they move at the pace of the slowest person.

*Given a list of people, by their moving speed. Calculate the shortest time in which everybody can cross the bridge.*

Example inputs and outputs:
* [1, 2, 5, 8] = 15
* [1 3 5 7 9 10 11 12 15 19 20 30] = 116
* [1..40] = 515

## Solution
<details>
<summary>solution</summary>
While the naive solution often is to use the fastest person as 'shuttle' for bringing back the torch for every person crossing. 
This is not the most optimal solution. 

The actual most optimal solution is to let the slowest persons move in pairs, as it would be 'wasteful' to pair the slow people with the fast ones. 
For example, with the group of [1, 2, 5, 8]; moving 5 & 8 together will take 8 time. 5 & 1 and 8 & 1 will take 13 time.  

To get the torch back, the idea of the most optimal solution is too use the two fastest people in turns. 

Using this method, the [1, 2, 5, 8] group will take 15 time. 
1. Move 1 and 2. Total time: 2
2. 1 moves back. Total time: 3
3. Move 5 and 8. Total time: 12 
4. 2 moves back. Total time: 14
5. Move 1.       Total time: 15
</details>
