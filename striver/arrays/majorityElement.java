// MOJORITY N / 2
// Sorting
public int majorityElement1(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length/2];
}


// Hashtable 
public int majorityElement2(int[] nums) {
    Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
    //Hashtable<Integer, Integer> myMap = new Hashtable<Integer, Integer>();
    int ret=0;
    for (int num: nums) {
        if (!myMap.containsKey(num))
            myMap.put(num, 1);
        else
            myMap.put(num, myMap.get(num)+1);
        if (myMap.get(num)>nums.length/2) {
            ret = num;
            break;
        }
    }
    return ret;
}


// Moore voting algorithm
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, res = 0;
        for (int num : nums) {
            if (count == 0) res = num;
            else if (num == res) count++;
            else count--;
        }
        return res;
    }
}


// MOJORITY N / 3
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int num1 = -1; int num2 = -1; 
        int count1 = 0; int count2 = 0;
        
        for (int val : nums) {
            if(val == num1) 
                count1++;
            else if (val == num2) 
                count2++;
            
            else if (count1 == 0) {
                num1 = val;
                count1++;
                }
            else if (count2 == 0) {
                num2 = val;
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        
        count1 = 0;
        count2 = 0;
        for(int val : nums) {
            if(val == num1) 
                count1++;
            else if(val == num2) 
                count2++;
        }
        
        if(count1 > nums.length/3)
            res.add(num1);
        if(count2 > nums.length/3)
            res.add(num2);
        return res;
    }
}
