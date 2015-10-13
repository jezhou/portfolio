/**
 *  Author         : Jesse Zhou
 *  Date Completed : 10/12/2015
 *  Difficulty     : Medium
 *  Problem        : There are N gas stations along a circular route, where the
 *                   amount of gas at station i is gas[i].
 *                   You have a car with an unlimited gas tank and it costs
 *                   cost[i] of gas to travel from station i to its next station
 *                   (i+1). You begin the journey with an empty tank at one of
 *                   the gas stations.
 *                   Return the starting gas station's index if you can travel
 *                   around the circuit once, otherwise return -1.
 *  Strategy       : First, check if the total gas exceeds the total cost.
 *                   There is no way to make it around the circuit unless the
 *                   gas is greater than or equal to the cost. Then, set the
 *                   start node to the first gas station. For each successful
 *                   gas station, calculate the running difference. If the
 *                   difference is ever negative, set the start node to the
 *                   next node in the circuit and set the running difference
 *                   to zero.
 *
 * 									 The idea is to basically to "go as far as you can" before
 * 									 running out of gas. If you run out of gas (the negative
 * 									 difference) then none of the nodes checked in the
 * 									 calculation thus far cannot be the starting node (since
 * 									 starting at any of those nodes will cause you to crash
 * 									 at the the same station). If you crash at a certain station
 * 									 then, it means you should restart the calculation at the
 * 									 next station for the rest of the trip. The node at which
 * 									 you can make it to the end without crashing is the node
 * 									 you should start at (since you will have leftover gas
 * 									 at the end of the trip, which will then carry over to
 * 									 gas[0], causing you NOT to crash since there is equal or
 * 									 greater gas when compared to cost).
 *  Time           : O(2n), which simplifies to O(n). There are two for loops
 *                   that go through the duration of each array.
 *  Dependencies   : None
 *  Notes          : None
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasTotal = 0;
        int costTotal = 0;
        int diff = 0;
        int startNode = 0;

        // First check if the gas >= the cost. If the cost is greater,
        // there is no conceivable way to make it around the circuit.
        for(int i = 0; i < gas.length; i++){
            gasTotal += gas[i];
            costTotal += cost[i];
        }

        if(gasTotal < costTotal){ return -1; }

        // iterate through the gas and cost arrays,
        // and do the appropriate calculations.
        for(int i = 0; i < gas.length; i++) {
            diff += gas[i] - cost[i];
            if(diff < 0) { // Reset the difference to 0, reset starting node
                diff = 0;
                startNode = i + 1;
            }
        }

        if(startNode == gas.length){
            startNode = 0;
        }

        return startNode;
    }
}
