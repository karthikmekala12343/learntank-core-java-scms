
# Notes
-------

## Why you used ArrayList instead of array ?
> In this project, we utilized java.util.ArrayList instead of primitive arrays (e.g., Student[]) to store entities.

> Reason:
- 	Dynamic Sizing: Arrays have a fixed length. Once created, they cannot grow or shrink. Since LearnTrack is a management system, the number of students and courses is unknown at compile time and changes frequently. ArrayList automatically resizes when elements are added or removed.
- 	ArrayList provides built-in methods like contains(), remove(), and size() which simplifies the code logic compared to manually iterating and shifting elements in a standard array.

## Where you used static members and why ?
> We used static members in the IdGenerator utility class.

> Reason: 
- The studentIdCounter, courseIdCounter, etc., need to be shared across all instances of the application to ensure unique ID generation. 
- If these were instance variables, every time we created a new service, the counter might reset. 
- By making them static, they belong to the class itself, maintaining state for the duration of the program run.

## Where you used inheritance and what you gained from it ?
> We implemented an inheritance hierarchy with Person as the base class and Student as the derived class

> Reason:
- 	Code Reusability: 
	- Common fields like id, firstName, lastName, and email are defined once in Person. Student inherits these without rewriting code.
- Polymorphism: We defined getDisplayName() in Person and override it in Student. This allows us to treat objects uniformly while still leveraging specific behaviors. 