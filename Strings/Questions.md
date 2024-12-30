# Questions Count 

--> For performing any sorting related operation on a string , first convert it into its corresponding character array and then perform the operation on the array and convert it back to String;

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

## Check if the sentence in pangram (leetcode - 1832) (Easy)

```java
class Solution {
    public boolean checkIfPangram(String sentence) {

        boolean result = true;

        boolean[] visited = new boolean[26];

        for(int i = 0;i<sentence.length();i++){
            int ascii = (int)(sentence.charAt(i));
            visited[ascii-97] = true;
        }

        for(int i = 0;i < visited.length;i++){

            if(visited[i] == false){
                result = false;
                break;
            }
        }
        return result;
    }
}
```

## Sort vowels in a string (leetcode - 2785) (Medium)

```java
class Solution {
    public String sortVowels(String s) {

        StringBuilder sb = new StringBuilder(s);

        ArrayList<Character> char_list = new ArrayList<>();
        ArrayList<Integer> idx_list = new ArrayList<>();

        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U'){
                char_list.add(s.charAt(i));
                idx_list.add(i);
            }
        }

        Collections.sort(char_list);

        System.out.println(char_list);

        for(int i = 0;i<char_list.size();i++){
            sb.setCharAt(idx_list.get(i) , char_list.get(i));
        }

        return sb.toString();
        
    }
}
```

## Sort Characters by Frequency (leetcode - 451) (medium)

```java
class Solution {

    public class comparePair implements Comparator<Pair>{
        @Override
        public int compare(Pair p1 , Pair p2){
            return p1.frequency - p2.frequency;
        } 
    }

    public class Pair{
        char ch;
        int frequency;
        public Pair(char c , int freq){
            this.ch = c;
            this.frequency = freq;
        }
    }

    public String frequencySort(String s) {

        HashMap<Character , Integer> map = new HashMap<>();

        for(int i = 0;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i) , 1);
            }else{
                int val = map.get(s.charAt(i));
                map.put(s.charAt(i) , val+1);
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new comparePair());

        for(char ch : map.keySet()){
            Pair pair = new Pair(ch , map.get(ch));
            pq.add(pair);
        }

        System.out.println(pq.peek().ch);

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            char ch = p.ch;
            int freq = p.frequency;

            for(int i = 0;i<freq;i++){
                sb.append(ch);
            }
        }

        return sb.reverse().toString();
    }
}
```

## Reverse words in a string (leetcode - 151) (Medium)

```java
class Solution {

    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder(s);

        sb.reverse();

        StringBuilder result = new StringBuilder("");


        int i = 0;
        while(i<sb.length()){

            StringBuilder individual = new StringBuilder("");

            while(i<sb.length() && sb.charAt(i) != ' '){
                individual.append(sb.charAt(i));
                i++;
            }

            if(individual.length() != 0){
                result.append(individual.reverse());
                result.append(" ");
            }
            i++;
        }

        result.deleteCharAt(result.length()-1);
        return result.toString();
        
    }
}
```

## Sum of beuty of all substring (leetcode - 1781) (Medium)

```java
class Solution {
    public int beautySum(String s) {

        int sum = 0;

        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<s.length();j++){
                String subStr = s.substring(i,j+1);
                int beuty = calculateBeuty(subStr);
                sum += beuty;
            }
        }

        return sum ;
        
    }

    public int calculateBeuty(String s){
        int[] arr = new int[26];

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            int idx = ch-'a';
            arr[idx] ++;
        }

        for(int i = 0;i<arr.length;i++){
            if(arr[i] != 0){
                max = Math.max(arr[i] , max);
                min = Math.min(arr[i] ,  min);
            }
        }

        return max - min;
    }
}
```

## Largest odd number in a string (leetcode - 1903) (Easy)

```java
class Solution {
    public String largestOddNumber(String num) {

        String final_ans = "";

        for(int i = num.length()-1;i>=0;i--){
            if(Character.getNumericValue(num.charAt(i)) % 2 != 0){
                final_ans = num.substring(0 , i+1);
                break;
            }
        }

        return final_ans;
        
    }
}
```

## Maximum nesting depth of parenthesis (leetcode - 1614) (Easy)

```java
class Solution {
    public int maxDepth(String s) {

        int n = s.length();

        int max = Integer.MIN_VALUE;

        int count = 0;

        for(int i = 0;i<n;i++){

            if(s.charAt(i) == '('){
                count += 1;
                max = Math.max(max , count);
            }else if(s.charAt(i) == ')'){
                count -= 1;
            }else{
                continue;
            }

        }

        if(max == Integer.MIN_VALUE){
            return 0;
        }else{
            return max;
        }   
    }
}
```

## Remove outerrmost parenthesis (leetcode - 1021) (Easy)

```java
class Solution {
    public String removeOuterParentheses(String s) {

        int n = s.length();

        StringBuilder sb = new StringBuilder("");

        int count = 0;
        for(int i = 0;i<n;i++){

            if(s.charAt(i) == ')'){
                count -= 1;
            }
            if(count != 0){
                sb.append(s.charAt(i));
            }
            if(s.charAt(i) == '('){
                count += 1;
            }
        }
        return sb.toString();
    }
}
```

## minimum add to make parenthesis valid (leetcode - 921) (Medium)

```java
class Solution {
    public int minAddToMakeValid(String s) {

        int n = s.length();

        int size = 0;

        int close_bracket = 0;

        for(int i = 0;i<n;i++){
            if(s.charAt(i) == '('){
                size += 1;
            }else{
                if(size == 0){
                    close_bracket += 1;
                }else{
                    size -= 1;
                }
            }
        }
        return size + close_bracket;
    }
}
```

## Minimum remove to make valid parenthesis (leetcode 1249) (Medium) 

```java
class Solution {
    public String minRemoveToMakeValid(String s) {

        int n = s.length();

        // first traversal 

        int openBracketCount = 0; 

        StringBuilder sb1 = new StringBuilder("");

        for(int i = 0;i < n;i++){

            if(s.charAt(i) == '('){
                sb1.append('(');
                openBracketCount += 1;
            }else if(s.charAt(i) == ')'){
                if(openBracketCount > 0){
                    sb1.append(')');
                    openBracketCount -= 1;
                }
            }else{
                sb1.append(s.charAt(i));
            }
        }

        System.out.println(sb1.toString());

        // second traversal (right to left)

        int closeBracketCount = 0;

        for(int i = sb1.length()-1;i>=0;i--){

            if(sb1.charAt(i) == ')'){
                closeBracketCount += 1;
            }else if(sb1.charAt(i) == '('){
                if(closeBracketCount > 0){
                    closeBracketCount -= 1;
                }else{
                    sb1.deleteCharAt(i);
                }
            }else{
                continue;
            }
        }

        return sb1.toString();
    }
}
```



## Longest common prefix (leetcode - 14) (Easy)

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {

        StringBuilder sb = new StringBuilder("");

        Arrays.sort(strs);

        for(int i = 0;i<strs[0].length();i++){
            if(strs[0].charAt(i) == strs[strs.length-1].charAt(i)){
                sb.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
}
```

## Check if 2 string are anagrams of each other (leetcode - 242) (Easy)

```java
class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }
    
        int[] arr_s = new int[26];
        int[] arr_t = new int[26];
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            int idx = ch - 'a';
            arr_s[idx]++;
        }
        
        for(int i = 0;i<t.length();i++){
            char ch = t.charAt(i);
            int idx = ch - 'a';
            arr_t[idx]++;
        }
        
        
        for(int i = 0;i<arr_s.length;i++){
            
            if(arr_s[i]>0 && arr_s[i] != arr_t[i]){
                return false;
            }
        }
        
        return true;
    }
}
```

## Isomorphic Strings (leetcode - 205) (Easy)

```java
class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character,Character> map1 = new HashMap<>();

        HashMap<Character,Character> map2 = new HashMap<>();


        for(int i = 0;i<s.length();i++){

            char ch = s.charAt(i);

            if(!map1.containsKey(ch)){
                if(!map2.containsKey(t.charAt(i))){
                    map1.put(ch , t.charAt(i));
                    map2.put(t.charAt(i),ch);
                }else{
                    return false;
                }
            }else{
                if(map1.get(ch) != t.charAt(i)){
                    return false;
                }
            }
        }
        return true; 
    }
}
```

## Count & Say (leetcode - 38) (Medium)

```java
class Solution {
    public String countAndSay(int n) {

        if(n == 1){
            return "1";
        }

        String previousAns = countAndSay(n-1);

        String ans = "";

        int i = 0;
        while(i < previousAns.length()){
            char current_Character = previousAns.charAt(i);
            String individual = "";
            int count = 0;
            while(i < previousAns.length() && current_Character ==  previousAns.charAt(i)){
                count += 1;
                i += 1;
            }
            individual += count;
            individual += current_Character;

            ans += individual;
        }

        return ans;
        
    }
}
```

## Repeated substring pattern (leetcode - 459) (Easy)

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {

        int n = s.length();
        
        for (int l = n/2; l >= 1; l--) {
            
            if (n % l == 0) {
                
                int times = n/l;
                String pattern = s.substring(0, l);
                StringBuilder newStr = new StringBuilder();
                
                while(times > 0) {
                    newStr.append(pattern);
                    times--;
                }
                
                
                if (s.equals(newStr.toString())) {
                    return true;
                }
            }
        }
        
        return false;
        
    }
}
```

-- > Find all pallindromic substring and subsequence of a string & sliding window problem of strings 
-- > string is a permutation of another string or not ?


