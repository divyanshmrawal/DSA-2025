//QUESTION-->
//There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.
/*/


Explanation of question :--
You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.

Return a list of groups such that each person i is in a group of size groupSizes[i].

Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.

 

Example 1:--
Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Explanation: 
The first group is [5]. The size is 1, and groupSizes[5] = 1.
The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] = 3.
The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] = groupSizes[6] = 3.
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
*/

//ANSWER-->
import java.util.*;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // HashMap to store group size as key and list of indices as value
        HashMap<Integer, List<Integer>> hash = new HashMap<>();
        // List to store the final grouped people
        List<List<Integer>> res = new ArrayList<>();

        // Iterate through the groupSizes array
        for (int i = 0; i < groupSizes.length; i++) {
            // If the group size is not already in the map, add it with an empty list
            hash.putIfAbsent(groupSizes[i], new ArrayList<>());
            // Add the current index to the corresponding group size list
            hash.get(groupSizes[i]).add(i);

            // If the current list reaches the required group size
            if (hash.get(groupSizes[i]).size() == groupSizes[i]) {
                // Add a copy of the list to the result
                res.add(List.copyOf(hash.get(groupSizes[i])));
                // Clear the list to start forming a new group of the same size
                hash.get(groupSizes[i]).clear();
            }
        }
        // Return the final grouped list
        return res;
    }
}


// Time Complexity: O(n) (each person is processed once)
// Space Complexity: O(n) (for storing groups in the HashMap and result list)
