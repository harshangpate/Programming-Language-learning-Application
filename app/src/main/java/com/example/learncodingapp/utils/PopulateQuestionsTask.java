package com.example.learncodingapp.utils;

import android.os.AsyncTask;

import com.example.learncodingapp.database.AppDatabase;
import com.example.learncodingapp.entities.Question;

import java.util.ArrayList;
import java.util.List;

// PopulateQuestionsTask updated to include difficulty in the Question entity
public class PopulateQuestionsTask extends AsyncTask<Void, Void, Void> {
    private AppDatabase db;

    public PopulateQuestionsTask(AppDatabase db) {
        this.db = db;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        // Check if the questions are already populated
        if (db.questionDao().getCount() == 0) { // Ensure this method exists in QuestionDao
            // Add the questions only if the table is empty
            db.questionDao().insertAll(getPredefinedQuestions());
        }
        return null;
    }

    private List<Question> getPredefinedQuestions() {
        // Your predefined questions with difficulty levels
        List<Question> questions = new ArrayList<>();

        // Java questions with difficulty levels
        questions.add(new Question("What is a variable in Java?", "A variable is a container for data values.", "Variables", "Java","Easy"));
        questions.add(new Question("How do you declare a variable in Java?", "You declare a variable in Java using a data type followed by the variable name.", "Variables", "Java","Easy"));
        questions.add(new Question("What is the difference between local and global variables in Java?", "Local variables are declared inside methods; global variables are declared outside.", "Variables", "Java","Medium"));
        questions.add(new Question("What is a loop in Java?", "A loop is a control structure that allows you to repeat a block of code.", "Loops", "Java","Easy"));
        questions.add(new Question("Explain the difference between a 'for' loop and a 'while' loop in Java.", "A 'for' loop is used when you know the number of iterations; a 'while' loop is used when you don't.", "Loops", "Java","Medium"));
        questions.add(new Question("What is an infinite loop in Java?", "An infinite loop is a loop that never ends; it runs indefinitely.", "Loops", "Java","Medium"));
        questions.add(new Question("What is a function in Java?", "A function is a block of code that performs a specific task.", "Functions", "Java","Easy"));
        questions.add(new Question("How do you define a function in Java?", "You define a function using the 'def' keyword followed by the function name.", "Functions", "Java","Easy"));
        questions.add(new Question("What is the difference between a method and a function in Java?", "A method is a function that is part of a class; a function is not part of a class.", "Functions", "Java","Medium"));
        questions.add(new Question("What is an array in Java?", "An array is a collection of elements of the same data type.", "Arrays", "Java","Easy"));
        questions.add(new Question("How do you declare an array in Java?", "You declare an array using the data type followed by the array name.", "Arrays", "Java","Easy"));
        questions.add(new Question("What is the length of an array in Java?", "The length of an array is the number of elements it contains.", "Arrays", "Java","Easy"));
        questions.add(new Question("What is Object-Oriented Programming (OOP) in Java?", "OOP is a programming paradigm based on the concept of objects.", "Object-Oriented Programming", "Java","Medium"));
        questions.add(new Question("Explain the difference between a class and an object in Java", "A class is a blueprint for creating objects; an object is an instance of a class.", "Object-Oriented Programming", "Java","Medium"));
        questions.add(new Question("What is a constructor in Java?", "A constructor is a special method that is called when an object is created.", "Object-Oriented Programming", "Java","Medium"));
        questions.add(new Question("What is a data structure in Java?", "A data structure is a way to organize and store data.", "Data Structures", "Java","Hard"));
        questions.add(new Question("Explain the difference between a stack and a queue in Java","Stack: Last In, First Out (LIFO) data structure. Queue: First In, First Out (FIFO) data structure","Data Structures", "Java","Hard"));
        questions.add(new Question("What is a linked list in Java?", "A linked list is a sequence of nodes where each node contains a value and a reference to the next node.", "Data Structures", "Java","Hard"));
        questions.add(new Question("What is recursion in Java?", "Recursion is a technique where a function calls itself to solve a problem.", "Recursion", "Java","Medium"));
        questions.add(new Question("Explain the concept of recursion in Java", "Recursion is a technique where a function calls itself to solve a problem.", "Recursion", "Java","Medium"));
        questions.add(new Question("What is the base case in recursion in Java?", "The base case is the condition that stops the recursion; it prevents an infinite loop.", "Recursion", "Java","Medium"));

        //  Python questions with difficulty levels
        questions.add(new Question("What is a variable in Python?", "A variable is a container for data values.", "Variables", "Python","Easy"));
        questions.add(new Question("How do you declare a variable in Python?", "You declare a variable in Python by assigning a value without specifying a data type.", "Variables", "Python","Easy"));
        questions.add(new Question("What is the difference between local and global variables in Python?","Local variables: Defined inside a function and accessible only within that function’s scope. Global variables: Declared outside any function and accessible throughout the entire program or script","Variables", "Python","Medium"));
        questions.add(new Question("What is a loop in Python?", "A loop is a control structure that allows you to repeat a block of code.", "Loops", "Python","Easy"));
        questions.add(new Question("Explain the difference between a 'for' loop and a 'while' loop in Python.", "A 'for' loop is used when you know the number of iterations; a 'while' loop is used when you don't.", "Loops", "Python","Medium"));
        questions.add(new Question("What is an infinite loop in Python?", "An infinite loop is a loop that never ends; it runs indefinitely.", "Loops", "Python","Medium"));
        questions.add(new Question("What is a function in Python?", "A function is a block of code that performs a specific task.", "Functions", "Python","Easy"));
        questions.add(new Question("How do you define a function in Python?", "You define a function using the 'def' keyword followed by the function name.", "Functions", "Python","Easy"));
        questions.add(new Question("What is the difference between a method and a function in Python?", "A method is a function that is part of a class; a function is not part of a class.", "Functions", "Python","Medium"));
        questions.add(new Question("What is an array in Python?", "An array is a collection of elements of the same data type.", "Arrays", "Python","Easy"));
        questions.add(new Question("How do you declare an array in Python?", "You declare an array using the data type followed by the array name.", "Arrays", "Python","Easy"));
        questions.add(new Question("What is the length of an array in Python?", "The length of an array is the number of elements it contains.", "Arrays", "Python","Easy"));
        questions.add(new Question("What is Object-Oriented Programming (OOP) in Python?", "OOP is a programming paradigm based on the concept of objects.", "Object-Oriented Programming", "Python","Hard"));
        questions.add(new Question("Explain the difference between a class and an object in Python", "A class is a blueprint for creating objects; an object is an instance of a class.", "Object-Oriented Programming", "Python","Medium"));
        questions.add(new Question("What is a constructor in Python?", "A constructor is a special method that is called when an object is created.", "Object-Oriented Programming", "Python","Medium"));
        questions.add(new Question("What is a data structure in Python?", "A data structure is a way to organize and store data.", "Data Structures", "Python","Hard"));
        questions.add(new Question("Explain the difference between a stack and a queue in Python","Stack: Last In, First Out (LIFO) data structure. Queue: First In, First Out (FIFO) data structure","Data Structures", "Python","Hard"));
        questions.add(new Question("What is a linked list in Python?", "A linked list is a sequence of nodes where each node contains a value and a reference to the next node.", "Data Structures", "Python","Hard"));
        questions.add(new Question("What is recursion in Python?", "Recursion is a technique where a function calls itself to solve a problem.", "Recursion", "Python","Easy"));
        questions.add(new Question("Explain the concept of recursion in Python", "Recursion is a technique where a function calls itself to solve a problem.", "Recursion", "Python","Medium"));
        questions.add(new Question("What is the base case in recursion in Python?", "The base case is the condition that stops the recursion; it prevents an infinite loop.", "Recursion", "Python","Easy"));

        // C++ questions with difficulty levels
        questions.add(new Question("What is a variable in C++?", "A variable is a container for data values.", "Variables", "C++","Easy"));
        questions.add(new Question("How do you declare a variable in C++?", "You declare a variable in C++ by assigning a value without specifying a data type.", "Variables", "C++","Easy"));
        questions.add(new Question("What is the difference between local and global variables in C++?","Local variables: Defined inside a function and accessible only within that function’s scope. Global variables: Declared outside any function and accessible throughout the entire program or script","Variables", "C++","Medium"));
        questions.add(new Question("What is a loop in C++?", "A loop is a control structure that allows you to repeat a block of code.", "Loops", "C++","Easy"));
        questions.add(new Question("Explain the difference between a 'for' loop and a 'while' loop in C++.", "A 'for' loop is used when you know the number of iterations; a 'while' loop is used when you don't.", "Loops", "C++","Medium"));
        questions.add(new Question("What is an infinite loop in C++?", "An infinite loop is a loop that never ends; it runs indefinitely.", "Loops", "C++","Medium"));
        questions.add(new Question("What is a function in C++?", "A function is a block of code that performs a specific task.", "Functions", "C++","Easy"));
        questions.add(new Question("How do you define a function in C++?", "You define a function using the 'def' keyword followed by the function name.", "Functions", "C++","Easy"));
        questions.add(new Question("What is the difference between a method and a function in C++?", "A method is a function that is part of a class; a function is not part of a class.", "Functions", "C++","Medium"));
        questions.add(new Question("What is an array in C++?", "An array is a collection of elements of the same data type.", "Arrays", "C++","Easy"));
        questions.add(new Question("How do you declare an array in C++?", "You declare an array using the data type followed by the array name.", "Arrays", "C++","Easy"));
        questions.add(new Question("What is the length of an array in C++?", "The length of an array is the number of elements it contains.", "Arrays", "C++","Easy"));
        questions.add(new Question("What is Object-Oriented Programming (OOP) in C++?", "OOP is a programming paradigm based on the concept of objects.", "Object-Oriented Programming", "C++","Hard"));
        questions.add(new Question("Explain the difference between a class and an object in C++", "A class is a blueprint for creating objects; an object is an instance of a class.", "Object-Oriented Programming", "C++","Medium"));
        questions.add(new Question("What is a constructor in C++?", "A constructor is a special method that is called when an object is created.", "Object-Oriented Programming", "C++","Medium"));
        questions.add(new Question("What is a data structure in C++?", "A data structure is a way to organize and store data.", "Data Structures", "C++","Hard"));
        questions.add(new Question("Explain the difference between a stack and a queue in C++","Stack: Last In, First Out (LIFO) data structure. Queue: First In, First Out (FIFO) data structure","Data Structures", "C++","Hard"));
        questions.add(new Question("What is a linked list in C++?", "A linked list is a sequence of nodes where each node contains a value and a reference to the next node.", "Data Structures", "C++","Hard"));
        questions.add(new Question("What is recursion in C++?", "Recursion is a technique where a function calls itself to solve a problem.", "Recursion", "C++","Easy"));
        questions.add(new Question("Explain the concept of recursion in C++", "Recursion is a technique where a function calls itself to solve a problem.", "Recursion", "C++","Medium"));
        questions.add(new Question("What is the base case in recursion in C++?", "The base case is the condition that stops the recursion; it prevents an infinite loop.", "Recursion", "C++","Easy"));


        return questions;
    }
}
