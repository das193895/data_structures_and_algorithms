```java
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    
    static class Human{
        
        String name;
        int age;
        boolean isMarried;
        static long population;
        
        Human(String new_name , int new_age , boolean marital_status){
            this.name = new_name;
            this.age = new_age;
            this.isMarried = marital_status;
            Human.population += 1; // ( use class Name to refer the static variables)
        }
        
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        System.out.println(Human.population); // we can access the static variables even before the declaration of objects 
            // prints 0;
        
        Human human1 = new Human("rahul" , 23 , false);
        Human human2 = new Human("susant" , 34 , true);
        
        System.out.println(Human.population); // ( use class Name to refer the static variables) prints 2; 
        // the population variable will change in all the objects of that class upon declaring a single class;
    }
}
```