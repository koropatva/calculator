# Calculator
Calculator is an application to calculate math operation over numbers. To interact with calculator we are using a command-line interface.

## Available operations:
- Add(**+**);
- Subtract(**-**);
- Multiply(*****);
- Divide(**/**);
- Print memory(**P**);
- Clean memory(**C**);

## Examples of calculations
##### Example 1:
    > 5
    5
    > 8
    8
    > +
    13

##### Example 2:
    > 5 8 +
    13
    > 13 -
    0.0

##### Example 3:
    > -3
    -3
    > -2
    -2
    > *
    6.0
    > 5
    6
    > +
    11.0

##### Example 4:
    > 5
    5
    > 9
    9
    > 1
    1
    > -
    8
    > /
    0.625

## Architecture
### Architecture design
The architecture was divided into two independent parts: input/output part(integration with CLI) and calculation engine.

The main responsibility for the input/output part is to received data from the user, response answer from calculation engine and have a possibility to exit from the program if needed.

The main responsibility for calculation engine: validated received args; validate the possibility to calculate operation; contains calculation results; make mathematic operations over args.

Splitting a product into two modules has its advantages. For example, we can easily add new input/output integration without modification of existing architecture; modify existing calculation logic or add new math operation without changing input/output integrations and so on.

### Want to contribute? Great!
#### How to import project to Eclipse
`Import` -> `Existing Gradle Project` -> `Next` -> `Finish`

#### How to run project
1. On Eclipse: `Run as` -> `Java Application`
2. On terminal with Gradle: `./gradle run`
3. Using executable JAR:
3.1 Create executing JAR: `./gradle jar`
3.2 Run application: `java -jar build/libs/calculator.jar`

#### Adding new operation
1. Create an enum on `io.calculator.core.operation.enums.OperationEnum`
1.1 `regExp` is responsible for the operation between other input args and operations.
2. Create an operation class on `io.calculator.core.operation` package.
3. Implement required methods from `io.calculator.core.operation.interfaces.Operation`
3.1 `calculate` responsible for math calcultaion  over input args
3.2 `getRegExp` responsible for `regExp` expression of the existing operations. It has to be unique.

#### Adding validation rules
Validation rules are responsible for validating input args. So if you need to limit input args by length, etc you can do it with rules
1. Create an rule on `io.calculator.core.validation.rules` package.
2. Implement the required method from `io.calculator.core.validation.Rule`
2.1 `invalid` method should return` true` if input arg contains invalid structure for current rule and `false` otherwise.
3. Add the created rule to `io.calculator.core.validation.ValidationService.connectionRules` that is filling by constructor.

#### Adding new input/output integration
To start working with `CalculatorEngine` enough to create a new object of this class and start sending new args to `calculate` method. The response engine will send result of a calculation.

Notes: if send wrong arg or operations, `CalculatorEngine` can throw exceptions: `io.calculator.core.exception.CalculationException` and `io.calculator.core.validation.exception.ValidationException`. Those exceptions are responsible to notify about an issue on calculation or vlidation step.

### FYI Things to improve
1. Start using log4j instead of standart output moments
2. Add more mathematic functions
3. Add more unit tests
4. Improve processing clear and print memory
5. Think about some flexible exception process
