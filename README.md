# Project Quiz  
*2019-02-19*

## Authors    
* **Antoan Hristov**
* **Patrick Wakil**

## Description of the project

Quiz is composed by different types of questions with different types of answers.

## howto

1. Recover the project files:
```
git clone https://github.com/AntoanH/Quiz.git
git pull
```
2. Run the project
```
By default the project is on console
To test:
java -jar target/COO-QUESTIONNAIRE-1.0-SNAPSHOT.jar question_foot.txt/question_tolkien.txt
To change in interface:
1. change pom.xml mainClass to ihm.QuestionnaireFrame
2. generate project with mvn package
To test:
java -jar target/COO-QUESTIONNAIRE-1.0-SNAPSHOT.jar question_foot.txt/question_tolkien.txt
```

## Performance of the code

**Interesting points**  
Issues encountered: the structure/layout of the final frame, how to wrap up component(Jpanel, Jtextfield) with other component (Jpanel).
Testing the class Answer, we couldn't create a specific test class for our concrete answer (as the answer class was generic). We solve this problem by using 2 methods "createAnswerToTest" and "createString" in AnswerTest  

We add another questionnaire in the project.

**In the project we used**

Here are some patterns used in this project:  

1. Factory: As you can see in the package factory, we implemented QuestionnaireFactory and AnswerFactory classes because we don't need the class object to be create only, the functionalities will be used.  

2. Template: All the answer have similar functionnalities therefore we create an abstract class Answer with a 'createAnswer' method which return the 'true' answer type we want.  

3. Strategy: QuestionPanel class have an answerPanel attributes which may vary for different question. example we can have a QuestionPanel with MultipleChoiceAnswerPanel and another one with YesNoAnswerPanel. Instead of an interface that those concrete answer will implemented, we choose an abstract class.
