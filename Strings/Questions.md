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

