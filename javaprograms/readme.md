# Code explanation

Project 02

Test cases

## Project 04

This code calculates the nth hexagonal number.

It takes a single integer argument from the command line and returns the corresponding hexagonal number.

Here's a step-by-step breakdown of the code:

1. Check the number of arguments passed to the program:
2. The program expects a single argument to be passed, which represents the value of n for the calculation of the hexagonal number.
3. If the number of arguments is not equal to 1, the program prints a message indicating that a single integer argument is required, and then exits.
4. Parse the argument to an integer. The argument is converted from a string to an integer and stored in the n variable.
5. Calculate the hexagonal number: The hexagonal number is calculated using the formula `n * (2 * n - 1)`. (cited source [https://en.wikipedia.org/wiki/Hexagonal_number](https://))
6. The result is printed to the console, indicating the nth hexagonal number calculated.

### Test cases

I wrote four tests to ensure that the `hexagonalNumber` method correctly calculates the nth hexagonal number for positive input, and correctly throws an exception for negative or zero input.

In this example, I refactored the code into a static method `hexagonalNumber` that takes `n` as an argument and returns the result, since the main method is not suitable for testing.
