## Gift Card
This is a program that will take in two arguments, one for a file path and one for a giftcard total,
that will be used to find the two highest priced items from that file that is equal to but not over the total gift card amount.

This can be run from the command line by first compiling the class:

javac GiftCard.java

The executed using your two arguments:

java GiftCard "C:\Users\bgree\IdeaProjects\PMPTest\src\main\resources\prices.txt" 2500

You'll get an output of your two items.

#### Unit tests can be run if Maven is installed via the command line or terminal from the root of the project directory via:

mvn test -Punit-test

You can also run them from inside your IDE via the GiftCardTest class by executing a Runner against that class or clicking the green arrow beside the class name if using IntelliJ.