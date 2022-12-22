App displays characteristics of given geometric figure.
Input parameters are given by command line arguments: 
- Path to file with type and init parameters of figure;
- Flag for result output:
  - -f for write result in file;
  - -c for write result in console.

App supports 3 type of figures: circle, rectangle and triangle.
Table with init parameters and output characteristics:

| Type of figure | Init parameters                 | Output                                         |
|----------------|---------------------------------|------------------------------------------------|
| CIRCLE         | Radius                          | Radius<br/>Diameter                            |
| RECTANGLE      | Lengths of the sides (2 values) | Length of diagonal<br/>Length<br/>Width        |
| TRIANGLE       | Lengths of the sides (3 values) | Side length and opposite angle (for each side) |
Also, for each figure output contains Figure type, Area and Perimeter.

App includes logging and unit test coverage.
___
**Example**

We have file test.txt with next contain:

    CIRCLE
    5
in command line we write following arguments:

    test.txt -c
and in result we have:

    Figure type: Circle
    Area: 78.53981633974483 cm2
    Perimeter: 31.41592653589793 cm
    Radius:  5.0 cm
    Diameter:  10.0 cm