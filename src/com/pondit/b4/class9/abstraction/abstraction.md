## Abstraction
- Means business functionality hiding.
- Main differences between abstraction and encapsulation are, Abstraction hides method functionality whereas encapsulation hides data members or instance variables.
- To define an abstract method, the method signature must contain abstract keyword.
- The abstract method must not have a method body.
- Any class containing an abstract method must have the abstract keyword with it too
- An abstract method must have it's implementation in a subclass of the abstract class. In this case the subclass must not be abstract.
- If the subclass is abstract, it does not have any necessity to implement the abstract method.
- The instantiation of an abstract class must have an anonymous inner class, where the instantiation will contain a body with the method implementation
