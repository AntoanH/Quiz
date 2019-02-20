# Project Quiz  
*2019-02-19*

## Authors    
* **Antoan Hristov**
* **Patrick Wakil**

## Description of the project

Quiz is composed by different types of questions with different types of answers.

## Performance of the code

**In the project we used**

Here are some patterns used in this project:  

1. Factory: As you can see in the package factory, we implemented QuestionFactory class because we deal with the problem of creating objects 

2. Template: All the answer have similar functionnalities therefore we create an abstract class Answer with a 'createAnswer' method which return the 'true' answer type we want.  
