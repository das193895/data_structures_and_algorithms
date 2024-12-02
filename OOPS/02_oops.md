# Packages

Packages are containers for classes. They are used to keep the class name space compartmentalized.
For example, a package allows you to create a class named List, which you can store in your own package without
concern that it will collide with some other class named List stored elsewhere. Packages are stored in a hierarchical
manner and are explicitly imported into new class definitions.

The package is both a naming and a visibility control mechanism.

The following statement creates a package called MyPackage: package MyPackage;

Java uses file system directories to store packages. For example, the .class files for any classes you declare to be
part of MyPackage must be stored in a directory called MyPackage. Remember that case is significant, and the directory
name must match the package name exactly.

A package hierarchy must be reflected in the file system of your Java development system.
For example, a package declared as

    package java.awt.image;

needs to be stored in java\awt\image in a Windows environment. Be sure to choose your package names carefully.
You cannot rename a package without renaming the directory in which the classes are stored.



# Static 

Understanding static:

When a member is declared static, it can be accessed before any objects of its class are created,
and without reference to any object. You can declare both methods and variables to be static.
The most common example of a static member is main( ).
main( ) is declared as static because it must be called before any objects exist.
Static method in Java is a method which belongs to the class and not to the object.

A static method can access only static data. It cannot access non-static data (instance variables)
A non-static member belongs to an instance. It's meaningless without somehow resolving which instance of a class you
are talking about. In a static context, you don't have an instance, that's why you can't access a non-static member
without explicitly mentioning an object reference.


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

A static method can call only other static methods and cannot call a non-static method from it.
A static method can be accessed directly by the class name and doesn’t need any object
A static method cannot refer to "this" or "super" keywords in anyway.
Outside classes can not be static , only the iner classes can be declared as static.