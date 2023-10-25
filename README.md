# Technical Challenge
This repo was initialised as:
 - Maven
 - Java
 - Sporing Boot
 - Jar package
 - Java 17

## json template examples path
\templates\ifStatementTemplates.json

## Data structure
* The IfStatement consists of 4 parts, condition, thenClause, elseClause, and result.
* condition is a string type to record the condition of an if-Statement
* thenClause is an IfStatement type to record the true condition result
* elseClause is an IfStatement type to record the false condition result
* result is a Boolean type to record the result of this branch, if there is no condition, result will be true or false
IfStatement{
    String condition;
    IfStatement thenClause;
    IfStatement elseClause;
    Boolean result;
}

## APIs

| Resource     | POST                      | PUT                     | test data template path                        |
|--------------|---------------------------|-------------------------|------------------------------------------------|
| /ifStatement | Create a new if-Statement | update the if-Statement | \templates\ifStatementTemplates.json           |
| /result      | Evaluate the result       | N/A                     | \templates\evaluateTestStatementTemplates.json |
| /translation | N/A                       | N/A                     | N\A                                            |

## future function

* translate the json format

In this repo, I have leave an API for the future function, and it will return error code currently.
In addition, I have provided the Jackson configuration, which is helpful for the future function development.

## How to run the code

1. Find `Logan_challenge.jar` and use `java -jar Logan_challenge.jar` to run the code in root path
2. If you want to run the source code, you can use IDE tools such as `IntelliJ IDEA` and the path of application class is \demo\src\main\java\com\example\demo\DemoApplication
3. Create a new if-Statement by using POST: localhost:8999/ifStatement with a json body
4. Evaluate the result by using POST: localhost:8999/ifStatement with a json body
5. Modify the if-Statement by using PUT: localhost:8999/ifStatement with a json body

* tips: 
* Json body should follow the rule of the json templates, which can be found in test data template path

## Additional Information
* the default server port is 8999

##



