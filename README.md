## Prerequisites
 * java 17
 * Maven
 * Serenity BDD
 * Webdriver
 * Junit
 * Cucumber

## How to run the tests
* The test cases were written in Gherkin and Cucumber was used to transform them from a natural 
* language to the automation steps, using the Screenplay and POM pattern.

## How to run the tests
 * clean report: serenity:clean
 * run tests: serenity:aggregate-history
 * Generate report: serenity:aggregate
 * open report: serenity:open
 * If you want to run all test cases use the @Regresion tag in the src/test/java/runners/TestRunner.java field.
 * if you want to run a specify case use the tag located at the top of the test case
 * If you want execute a specify feature use the tag located at the top of the feature description


### The project directory structure
The project has build scripts for both Maven , and follows the standard directory structure used in most Serenity projects:
```Gherkin
src
  + main                                  | Source main
    + java                                | Test runners and supporting code
    + org.example                         | Package base
      + models                            | DTOs, Pojos, VOs, etc ...
      + constants                         | Variables that won´t be modified
      + utils                             | General utility class
      + questions                         | Classes that answers any questions
      + tasks                             | Classes than simulate a behavior
  + test                                    |
    + java                                | Test runners and supporting code
      + runners                           | Execute the proyect
      + stepsdefinitions                  | Steps of the script
      + serenity.conf                     | Config file for Serenity
  + RunnerTestSuite.java              | Main class
    + resources                           |
    + features                          | Feature files
          + {feature_name}                 | Feature file  specific
     {feature_name}.featurePET       |
      + serenity.conf                     | Config file for Serenity
```
