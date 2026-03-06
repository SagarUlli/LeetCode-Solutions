class Solution {
public int[] twoSum(int[] nums, int target) {
Map<Integer, Integer> map = new HashMap<>();
for(int i = 0; i < nums.length; i++) {
int complement = target - nums[i];
if(map.containsKey(complement)) {
return new int[]{i, map.get(complement)};
}
map.put(nums[i], i);
}
throw new IllegalArgumentException("No Element Found");
}
}

Time: 2 ms (99.22%), Space: 47.2 MB (38.68%) - LeetHub

0001-two-sum/0001-two-sum.java

Code
Commit message
File Path and Name

Give for below code.
class Solution {
public String longestPalindrome(String s) {
if (s == null || s.length() < 1) return "";

int start = 0, end = 0;

for (int i = 0; i < s.length(); i++) {    
    int len1 = expand(s, i, i);       // odd length    
    int len2 = expand(s, i, i + 1);   // even length    
    int len = Math.max(len1, len2);    
        
    if (len > end - start) {    
        start = i - (len - 1) / 2;    
        end = i + len / 2;    
    }    
}    
    
return s.substring(start, end + 1);

}

private int expand(String s, int left, int right) {
while (left >= 0 && right < s.length() &&
s.charAt(left) == s.charAt(right)) {
left--;
right++;
}
return right - left - 1;  // length of palindrome
}

}
