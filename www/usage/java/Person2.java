// FILE: /home/steffen/projects/ArgoUML/tests/test/Person.java

package test;
import java.util.*;

/** A class that represents ...
   *
   * @see OtherClasses
   * @author your_name_here
   * @invariant unnamedConstraint_0: married implies ( age >= 18 )
   */
class Person
{
  // Attributes

  /** An attribute that represents ...
   */
  public  int age;

  /** An attribute that represents ...
   */
  public  boolean married;

  // Associations

  // Operations

  public Person() {
    super();

    age = 17;
    married = true;
  }

  public String toString() {
    return
      ((married)?
       ("Married person"):
       ("Person")
      ) +
      ": age = " + age;
  }

  public static void main (String[] args) {
    Person p = new Person();

    System.out.println ("Created new person:");
    System.out.println (p);
  }
} /* end class Person */
