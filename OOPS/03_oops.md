# Properties

## Inheritance

Inheritance means creating new classes based on existing ones. So there is a super class (parent class) and there is a sub class (child class) . So the child class can have access to all the properties and functions that are present in thte parent class and it can have its own properties and functions as well. 

Declartion using thte "Extends" keyword:

class DerivedClass extends BaseClass  
{  
   //methods and fields  
}

An example of inheritance:

```java
class Main {
    
    public static class Bicycle{
        
        int gear;
        int speed;
        
        public Bicycle(int gear , int speed){
            this.gear = gear;
            this.speed = speed;
        }
        
        public void applyBreak(int decrement){
            this.speed -= decrement;
        }
        
        public void speedUp(int increment){
            this.speed += increment;
        }
        
        public String toString(){
            return ("toString Method is called for the parent class" + " " +this.gear + " " + this.speed);
        }
    }
    
    public static class MountainBike extends Bicycle{
        int seatHeight;
        
        public MountainBike(int g , int s , int seatHeight){
            super(g, s); // call the parent class constructor using super keyword
            this.seatHeight = seatHeight;
        }
        
        public void increaseSeatHeight(int increment){
            this.seatHeight += increment;
        }
        
        // overriding toString() method
        @Override
        public String toString(){
            return (super.toString()+"toStringMethod is called for the child class" +" "+this.seatHeight);
        }
        
        
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        MountainBike mbike = new MountainBike(4 , 5 , 6);
        
        System.out.println(mbike.gear); // 4
        System.out.println(mbike.speed); // 5
        System.out.println(mbike.seatHeight); // 6
        
        Bicycle bi = new MountainBike(7 , 8 , 9);// we can declare like this as well
        
        System.out.println(bi.gear); // 7
        System.out.println(bi.speed); // 8
       System.out.println(bi.seatHeight); // will give an error because the the type of referance variable here (bi) is of class Bicycle and it does not have any properties that is seatHeight;
        
        MountainBike mb = new Bicycle(7 , 8); // we can not do this because it is always the referance variable which decides the properties/method can be accessible or not , here the mb is of type MountainBike which has 3 variables which has to be initialised but the ovbject is of Bicycle type which can have only 2 properties .So the problem arises in the initialisation of variables
    }
}
```

You can only specify one superclass for any subclass that you create. Java does not support the inheritance of
multiple superclasses into a single subclass. You can, as stated, create a hierarchy of inheritance in which a subclass
becomes a superclass of another subclass. However, no class can be a superclass of itself.

Although a subclass includes all of the members of its superclass, it cannot access those members of the superclass
that have been declared as private.


Using super:
Whenever a subclass needs to refer to its immediate superclass, it can do so by use of the keyword super.
super has two general forms. The first calls the superclass’ constructor.
The second is used to access a member of the superclass that has been hidden by a member of a subclass.

```java

BoxWeight(double w, double h, double d, double m) {
    super(w, h, d); // call superclass constructor
    weight = m;
}

```

Here, BoxWeight( ) calls super( ) with the arguments w, h, and d. This causes the Box constructor to be called,
which initializes width, height, and depth using these values. BoxWeight no longer initializes these values itself.
It only needs to initialize the value unique to it: weight. This leaves Box free to make these values private if desired.

Thus, super( ) always refers to the superclass immediately above the calling class.
This is true even in a multileveled hierarchy.


```java

class Box {
     private double width;
     private double height;
     private double depth;

     // construct clone of an object

     Box(Box ob) { // pass object to constructor
       width = ob.width;
       height = ob.height;
       depth = ob.depth;
     }
}

class BoxWeight extends Box {
     double weight; // weight of box

     // construct clone of an object

     BoxWeight(BoxWeight ob) { // pass object to constructor
        super(ob);
        weight = ob.weight;
     }
}

```

Notice that super() is passed an object of type BoxWeight—not of type Box.This still invokes the constructor Box(Box ob).
NOTE: A superclass variable can be used to reference any object derived from that class.
Thus, we are able to pass a BoxWeight object to the Box constructor.Of course,Box only has knowledge of its own members.

A Second Use for super
The second form of super acts somewhat like this, except that it always refers to the superclass of the subclass in
which it is used.

super.member

Here, member can be either a method or an instance variable. This second form of super is most applicable to situations
in which member names of a subclass hide members by the same name in the superclass.

super( ) always refers to the constructor in the closest superclass. The super( ) in BoxPrice calls the constructor in
BoxWeight. The super( ) in BoxWeight calls the constructor in Box. In a class hierarchy, if a superclass constructor
requires parameters, then all subclasses must pass those parameters “up the line.” This is true whether or not a
subclass needs parameters of its own.

If you think about it, it makes sense that constructors complete their execution in order of derivation.
Because a superclass has no knowledge of any subclass, any initialization it needs to perform is separate from and
possibly prerequisite to any initialization performed by the subclass. Therefore, it must complete its execution first.

NOTE: If super( ) is not used in subclass' constructor, then the default or parameterless constructor of each superclass
will be executed.

### Types of inheritances:

1. Single inheritance : In single inheritance, a sub-class is derived from only one super class. It inherits the properties and behavior of a single-parent class. 
2. Multilevel inheritence : In Multilevel Inheritance, a derived class will be inheriting a base class, and as well as the derived class also acts as the base class for other classes.
3. Hirarchical inheritance : In Hierarchical Inheritance, one class serves as a superclass (base class) for more than one subclass.
4. Multiple inheritance : Multiple Inheritance is a feature of an object-oriented concept, where a class can inherit properties of more than one parent class. The problem occurs when there exist methods with the same signature in both the superclasses and subclass. On calling the method, the compiler cannot determine which class method to be called and even on calling which class method gets the priority. Java doesn’t support Multiple Inheritance . it is done in java by interfaces.

5. Hybrid inheritance : It is a mix of two or more of the above types of inheritance. Since Java doesn’t support multiple inheritances with classes, hybrid inheritance involving multiple inheritance is also not possible with classes.


## Polymorphisim

Polymorphism allows us to perform a single action in different ways.The word “poly” means many and “morphs” means forms, So it means many forms.

### Types of Polymorphisim:

1. Static / Compile-time polymorphisim 

This type of polymorphism is achieved by function overloading or operator overloading. But Java doesn’t support the Operator Overloading.

When there are multiple functions with the same name but different parameters then these functions are said to be overloaded. Functions can be overloaded by changes in the number of arguments or/and a change in the type of arguments.

```java
class Helper {

    // Method with 2 integer parameters
    static int Multiply(int a, int b)
    {
        // Returns product of integer numbers
        return a * b;
    }

    // Method 2
    // With same name but with 2 double parameters
    static double Multiply(double a, double b)
    {
        // Returns product of double numbers
        return a * b;
    }
}

// Class 2
// Main class
class GFG {
    // Main driver method
    public static void main(String[] args)
    {
        // Calling method by passing
        // input as in arguments
        System.out.println(Helper.Multiply(2, 4));
        System.out.println(Helper.Multiply(5.5, 6.3));
    }
}
```

2. Dynamic /Run-time polymorphisim

This type of polymorphisim is achieved by method overriding

```java
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    
    public static class Shape{
        
        void area(){
            System.out.println("I am an arbitrary shape and my area can vary");
        }
        
    }
    
    public static class Circle extends Shape{
        
        @Override
        void area(){
            System.out.println("I am a circle my area pi * r * r");
        }
        
    }
    
    public static class Square extends Shape{
        
         @Override
        void area(){
            System.out.println("I am a sqaure and my area is a * a");
        }
        
    }
    
    public static class Rectangle extends Shape{
        
        @Override
        void area(){
            System.out.println("I am a rectangle and my area is a * b");
        }
        
    }
    
    
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        Shape shape = new Shape();
        
        shape.area(); // I am an arbitrary shape and my area can vary
        
        Circle circle = new Circle();
        
        circle.area();  // I am a circle my area pi * r * r
        
        Square square = new Square();
        
        square.area(); // I am a sqaure and my area is a * a
        
        Rectangle rectangle = new Rectangle();
        
        rectangle.area(); // I am a rectangle and my area is a * b 
        
        
        /* Here the parent class and the child class are having the same function name but different implementation , When the area() method is called from the child class object then the child class's area() method is being executed instead of the parent's class area() method , hence the annottation @Override */
        
        
        Shape shape1 = new Circle();
        
        shape1.area();  // I am a circle my area pi * r * r
        
        Shape shape2 = new Rectangle();
        
        shape2.area(); // I am a rectangle and my area is a * b
        
         /*It is the left hand side which is defining the which method should be called , in this case the object is of type "Circle()" , so the area() method defined in the Circle class is being called here */
         
         /* This is also known as UPCASTING , which method should be called is actually depends upon the type of Object (The RHS) */
         
         /* These are all happening in RUN Time*/
    }
}
```

In a class hierarchy, when a method in a subclass has the same name and type signature as a method in its superclass,
then the method in the subclass is said to override the method in the superclass. When an overridden method is called
from within its subclass, it will always refer to the version of that method defined by the subclass. The version of the
method defined by the superclass will be hidden.

Method overriding occurs only when the names and the type signatures of the two methods are identical.
If they are not, then the two methods are simply overloaded.

Dynamic Method Dispatch:

Dynamic method dispatch is the mechanism by which a call to an overridden method is resolved at run time, rather than
compile time. Dynamic method dispatch is important because this is how Java implements run-time polymorphism.
Let’s begin by restating an important principle: a superclass reference variable can refer to a subclass object.
When an overridden method is called through a superclass reference, Java determines which version of that method to
execute based upon the type of the object being referred to at the time the call occurs. Thus, this determination is
made at run time.
In other words, it is the type of the object being referred to (not the type of the reference variable)
that determines which version of an overridden method will be executed.

If B extends A then you can override a method in A through B with changing the return type of method to B.






