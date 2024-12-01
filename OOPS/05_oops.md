# Abstraction 

bstraction in Java is the process in which we only show essential details/functionality to the user. The non-essential implementation details are not displayed to the user. 

In Java, abstraction is achieved by interfaces and abstract classes. We can achieve 100% abstraction using interfaces.

## Abstract classes and methods

Any class that contains one or more abstract methods must also be declared abstract.

Sometimes you will want to create a superclass that only defines a generalized form that will be shared by all of its
subclasses, leaving it to each subclass to fill in the details. Such a class determines the nature of the methods that
the subclasses must implement.

You may have methods that must be overridden by the subclass in order for the subclass to have any meaning.
In this case, you want some way to ensure that a subclass does, indeed, override all necessary methods. Java’s solution
to this problem is the abstract method.
You can require that certain methods be overridden by subclasses by specifying the abstract type modifier.

        abstract type name(parameter-list);

These methods are sometimes referred to as subclass's responsibility because they have no implementation specified in
the superclass.
Thus, a subclass must override them—it cannot simply use the version defined in the superclass.

```java
class Main {
    
    public static abstract class Shape{
        
        abstract void area();
        abstract void printDimension();
        
        // we are difining a blueprint of functions that eventually has to be implemented by the child class  
        
    }
    
    public static class Circle extends Shape{
        
        int dimension;
        
        Circle(int d){
            this.dimension = d;
        }
        
        
        @Override
        void area(){
            System.out.println("Area = pi * r * r");
        }
        
        @Override
        void printDimension(){
            System.out.println("Dimension is" +" "+ this.dimension);
            
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        Circle c = new Circle(2);
        
        c.area();
        c.printDimension();
    }
}
```

1. There can be no objects of an abstract class.
2. You cannot declare abstract constructors
3. you can not declare abstract static methods because abstract methods has to be overriden but static methods can not be overriden so contradiction happens.
4. You can declare static methods in abstract class.
5. You can not have final abstract classes because abstract classes have to be inherited but final key word prevents inheritance.

Abstract classes does not support MULTIPLE INERITANCE.

