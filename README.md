# **SPA_DataStructures**
Spring 2021 Advanced Topics in Computer Science Turn-in repository.

## Descriptions:
* **Assignment1:** Contains a Mouse class with instance variables String name, int xCoordinate, int yCoordinate, and ArrayList<ArrayList<Integer>> coordinateHistoryStack. The mouse can move to different coordinates, and the coordinateHistoryStack contains its full movement history. The mouse also has accessor and movement methods.

* **Assignment2:** Contains four classes created from arrays: (1) A unique list with append, pop, and insert methods (2) A stack method with the standard push and pop methods (3) A queue method with the standard queue and dequeue methods and (4) A dumb queue method which creates a queue based off of the stack method.

* **Assignment3:** Contains a grid object with an ArrayList<ArrayList<Integer>> instance variable that is full of 0's. It has a createGrid method to randomly disperse 1's throughout the grid. The mouse class from **Assignment1** was updated to traverse the grid, avoiding walls (1's) and filling every other spot with 2's. The MyStack class from **Assignment2** was updated to have an ArrayList instance variable rather than an array, and a stack was created to keep track of which squares the mouse has traveled too.

* **Assignment4:** Contains a LinkedList class that connects Node objects. The LinkedList contains add, remove, insert, switch, and reverse methods. There is also a method in the main file which merges two linked lists.

* **Assignment5:** Contains a HashSet class with an ArrayList<MyLinkedList> instance variable (using the LinkedList class from **Assignment4**). The class has add and isInSet methods. A private method called hash also creates new buckets within the add method when necessary.

* **Assignment6:** Contains a Binary Search Tree class with add and print methods (newBST). It also contains a broken BST class (BST) kept for documentation purposes. A main method also contains three recursive methods: (1) palindrome, which returns true if string is a palindrome and false if it isn’t (2) factorial, which returns the factorial of an integer and (3) firstOc which returns the index of first occurence of a given integer in an array.

* **Assignment7:** Is this ReadMe file!

* **Assignment8:** Contains a RandomSentence class that generates random sentences based on a HashMap<String, ArrayList<String>> which contains every word in Harry Potter: The Sorcerer's Stone and a connecting list of all words that follow it. Also contains a MainActivity class for an AndroidStudio app that converts from Miles to Kilometers (and vice versa).

* *Challenge1:* Contains a main file that lists all possible pairs in a randomized array list which sum to 10.
* *Challenge2:* Contains an addN method in the main file that adds a given integer n to every integer within a string.
* *Challenge3:* Contains two recursive methods within the main file: (1) loop, which iterates through each item in a list and adds n and (2) fib, which returns the nth fibonacci number.
* *Challenge4:* Contains five methods within the main file: (1) minValue, which returns the index of the minimum value in an ArrayList (2) minValue2, which returns the minimum value of two ArrayLists (3) swapTwo, which swaps two values in an ArrayList (4) selectionSort, which is a standard selectionSort method and (5) merge, which merges two ArrayLists and sorts them using selectionSort.

* *MiniAssignment1:* Contains two java files that create an app with two views (and buttons to switch between them) in android studio.
