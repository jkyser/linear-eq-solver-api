# Linear Equation Solver Microservice

This microservice is used to solve very basic linear equations. As of now, the only linear equations it can solve are
equations that contain only addition and subtraction. The solver communicates via HTTP POST requests and responds
with a JSON body giving a solved equation, the slope, and the y-intercept of the equation.

# Tech Used to Build Microservice

* Java
* Spring Boot
* JUnit
* Git
* Heroku (for deployment of microservice)

# Highlights for Building Project

The biggest highlight for this project is utilizing Test-Driven Development. The first iteration of this project I solely
used string processing for everything. This caused a lot of code redundancy, so I refactored into a much more Object-Oriented
approach to the problem. Because I didn't follow any development process, I still had a lot of code repetition and weird
problems I had a hard time finding. So I refactored a third time using Test-Driven Development. I created unit tests with JUnit
for all of my public methods and ensured they were functioning to a level I agreed with. I still have more testing to integrate,
but utilizing the TDD approach made my code more modular, robust, and easier to maintain.

# Usage

The front-end of the poject is hosted through GitHub at: [Math-Grapher](https://jkyser.github.io/mathgrapher-frontend/)

The front-end also uses a graphing microservice created using JFreeChart. The repo for that microservice can be found
at: [Graphing-Microservice](https://github.com/jkyser/graphing-microservice)


### Image of homescreen for equation solving

![image](https://github.com/jkyser/linear-eq-solver-microservice/tree/main/src/main/resources/homepage.png?raw=true)

### Image of the solved equation

![image](https://github.com/jkyser/linear-eq-solver-microservice/tree/main/src/main/resources/solvedEquation.png?raw=true)

You can notice that the graphing microservice is utilized after hitting submit also (through a second HTTP POST request
to that microservice).

### Image of response body

![image](https://github.com/jkyser/linear-eq-solver-microservice/tree/main/src/main/resources/response.png?raw=true)

# Future of microservice

I have a lot of improvements I want to make on this project. They are listed as follows (in no particular order):

* More testing (integration tests, random testing, etc.)
* Validation on the given equations (there is some very minor '=' symbol validation right now)
* Handling of multiplication and division in linear equations
* Pure equation solving for x (no graphing)
* Handling of higher order equations (polynomial, trigonometric functions, calculus, etc.)