# String Functions:

str.length(); ---> gives length of the string

str.charAt(index); ---> fetching charecter at a perticular index

str.indexof(character); ---> fetching index of a perticular character of its 1st occurance

str1.compareTo(str2); ----> it lexographically compares str1 and str2 
                             0   if (ascii(str1) == ascii(str2))
                            >0   if (ascii(str1) > ascii(str2))
                            <0   if (ascii(str1) < ascii(str2))

str.contains(string); ----> it gives true/false according to the "String" is present in str or not

str.startsWith(string); --->it gives true/false based on the , if str is starting with "string" or not

str.endsWith(String); ---> it gives true/false based on the , if str is ending with the "string" or not

str.toLowerCase(); ---> convets all the charecters of the str to lowercase characters

str.toUpperCase(); ---> convets all the charecters of the str to uppercase characters

str1.concat(str2); ---> it cancatenates both str1 and str2 and forms a new string 

str1.equals(str2); ---> compares str1 and str2 and gives true or false (always use this function for checking if  two strings are equal or not instead of "==") . It checks only the value

Integer.parseInt(Str)  ---> converts str to Integer if its possible

char[] ch = str.toCharArray();  ---> converting a String to its corresponding character array

String s = new String(ch);     ---> converting a character array to its corresponding String

String[] str_arr = str.split(",") ---> split the String "str" to form an array of Strings with respect to  a delimiter


## Adding string to string/integer/character

we can use "+" operator for concatenating 

"abc" + "def" = "abcdef"
"abc" + 'd' = "abcd"
"abc" + 10 = "abc10"
"abc" + 10 + 20 = "abc1020"

## substrings ---> conteneous part of a string

eg -- "abcd" ---> abc,cd,abcd,ab ..... are substrings but cb and cba are not substrings

str.substring(start,end) ---> it prints the substring of str from start index to end-1 index

str.substring(i)  ---> it prints all the elements after i including i

## INTERNING 

String str = "Hello"
String gtr = "Hello"

after declaration of above 2 statements --> The "Hello" keyword is being stored in the "heap" memmory and the address is being stored in the "stack" memmory but the variables "str" and "gtr" are pointing to the the same string "hello" there is no creation of a new "hello" keyword is happening . The variables are point to the same keyword with same address

## Avoiding Interning

we can avoid interning by using "new" keyword.

String str = new String("Hello");
String gtr = new String("Hello");

in the first statement Hello keyword is being stored in the heap memmory with an address and the variable str is pointing to it , and after declaration of the 2nd statement a new "hello" keyword is forming with a new address and the variable "gtr" is pointing to the new "hello" keyword.

## Strings are immutable in java.

## String Builder class in java

StringBuilder sb = new StringBuilder("");      // initialisation with an empty string 
StringBuilder sb1 = new StringBuilder("amlan") // initialisation with a specified string 
 
sb.setCharAt("index_no","char");  // replaces the charecter "char" at a given index "index_no" . The length of the string is NOT getting changed.
sb.append(a);                     // append "a" at the last of the sb and "a" can be a charecter,string,int,double ....
sb.insert("index_no","char");     // inserts the charecter "char" at a given index "index_no" . The length of the string is getting changed.
sb.deleteCharAt("index_no");      // deletes the charecter at a given index
sb.reverse();                     // reverses the specified string 
sb.length();                      // returns the length of the stringbuilder


## Charecters

checking non alpha numeric characters -- Character.isLetterOrDigit("c") (it will give false in case of zero)
checking uppercase and lower case -- Character.isUpperCase("c") , Character.isLowerCase("c") 
converting a string to integer (if possible) -- Character.getNumericValue("str")
