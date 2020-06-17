# Javachallenge BowlingCalculator
## Build and Run

The code is written in JAVA8, MAVEN and JUnit. For build and run you need run the next commands:

```mvn package
java -jar JavaChallenge-1.0.jar "C:\input.txt"
```

The param is the path or location file. In my case: C:\input.txt. So, you'll have the results.
There is a input.txt in the root of this project.

![output example](https://github.com/shuraG/javachallenge/tree/master/resources/output.MHT"output example")

## Problem design and assumptions

The solution implement Lambdas and Streams of JAVA 8. Lambdas is use, for define diferrents rules for bowling calculator. 
So, we have separate responsability between classes. If it,s necessarty modify or add rules, you only need change in FactoryRules.
With that we have Liskov's substitution, because of all rules implement rule interface, and it not depend in the place, where they will be use.
They are desacoupled. Streams are use to work with List and Maps. 
LinkedList for PinFalls in this case is a good election, because we only have inserts elements, this avoid resizing in ArrayList.


![Diagram Bowling Calculator](https://github.com/shuraG/javachallenge/tree/master/resources/diagram_bowling_calculator.png "Diagram Bowling Calculator")

Screen is based in Strategy Pattern. So we have extends from Screen a ConsoleScreen for this case, but we could extend to more interfaces, like:
GraphicalInterface; you only need extend from Screen abstrac class. In the other side, we have a set of Format algorithms, and all of these implement Format
interface. Screen not depend on algorithms format.

![Diagram Screen](https://github.com/shuraG/javachallenge/tree/master/resources/diagram_screen.png "Diagram Screen")




