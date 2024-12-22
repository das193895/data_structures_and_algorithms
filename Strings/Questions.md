# Questions Count 

## Longest Pallindrome (leetcode - 409) (Easy)

```java
class Solution {
    public int longestPalindrome(String s) {

        int ans = 0;
        boolean flag = false;

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0;i<s.length();i++){
            Character ch = s.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch , 1);
            }else{
                Integer val = map.get(ch);
                map.put(ch , val+1);
            }
        }


        for(Character ch : map.keySet()){
            int val = map.get(ch);
            if(val % 2 == 0){
                ans += val;
            }else{
                flag = true;
                ans = ans + (val - 1);
            }
        }
        if(flag == true){
            return ans + 1;
        }else{
            return ans;
        }
    }
}
```

## Sorting the sentence (leetcode - 1859) (easy)

```java
class Solution {

    public class compareByLastIdx implements Comparator<String>{
        @Override
        public int compare(String s1 , String s2){

            int lastIdx1 = s1.charAt(s1.length()-1);
            int lastIdx2 = s2.charAt(s2.length()-1);

            return Character.getNumericValue(lastIdx1) - Character.getNumericValue(lastIdx2);
        }
    }
    public String sortSentence(String s) {

        String[] str_arr = s.split(" ");

        Arrays.sort(str_arr , new compareByLastIdx());

        StringBuilder result = new StringBuilder("");

        for(int i = 0;i<str_arr.length;i++){

            StringBuilder currentString = new StringBuilder(str_arr[i]);
            currentString.deleteCharAt(currentString.length()-1);

            result.append(currentString);
            result.append(" ");
            
        }

        result.deleteCharAt(result.length()-1);

        return result.toString();
 
    }
}
```

## Defanging an IP address (leetcode - 1108) (Easy)

```java
class Solution {
    public String defangIPaddr(String address) {

        StringBuilder sb = new StringBuilder("");

        for(int i = 0;i<address.length();i++){
            if(address.charAt(i) != '.'){
                sb.append(address.charAt(i));
            }
            else{
                sb.append('[');
                sb.append(address.charAt(i));
                sb.append(']');

            }
        }

        return sb.toString();  
    }
}
```

## Rotate String (leetcode - 796) (Easy)

An important note - If we concatenate a string with itself the resultant string will contain all possible rotations of the original string as a substring in it.

```java
class Solution {
    public boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()){
            return false;
        }

        String s1 = new String();
        s1 += s;
        s1 += s;

       
        return s1.contains(goal);
  
    }
}
```

