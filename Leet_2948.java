import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

//This question's trick is using TRANSITIVE method
//sort the elements first. We're making good use of transitive elements. 
//If the limit is 3 I can't switch 8 and 4 in [8,6,4] but I can switch 8 and 6 to [6,8,4]
//Then switch 6 and 4 to [4,8,6] and then finally switch 8 and 6 to [4,6,8]
//Even though 4 and 8 are above the diffirence limit of 3, we were able to use a middle value
//We made use of TRANSITIVE method here. 


class Solution {


    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
       HashMap<Integer, Integer> groupList = new HashMap<>();
       HashMap<Integer, PriorityQueue<Integer>> sortedMap = new HashMap<>();
       int group = 0;

       int[] sortedArray = nums.clone();
       Arrays.sort(sortedArray);

       for (int i = 0; i < sortedArray.length - 1; i++) {
           groupList.put(sortedArray[i], group);
           sortedMap.putIfAbsent(group, new PriorityQueue<>());
           sortedMap.get(group).add(sortedArray[i]);

           if (Math.abs(sortedArray[i] - sortedArray[i + 1]) > limit) {
               group++;
           }
       }

       groupList.put(sortedArray[sortedArray.length - 1], group);
       sortedMap.putIfAbsent(group, new PriorityQueue<>());
       sortedMap.get(group).add(sortedArray[sortedArray.length - 1]);

       for (int i = 0; i < nums.length; i++) {
           int currGroup = groupList.get(nums[i]);
           nums[i] = sortedMap.get(currGroup).poll();
       }

       return nums;
   }
  



}