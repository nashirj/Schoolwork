%{
The distance between two points x1, y1 and x2, y2 on a Cartesian coordinate plane is given by the equation 
(2.12) (See Figure 2-16). Write a program to calculate the distance between any two
points sx1, y1d and sx2, y2d specified by the user. Use good programming practices in your program.
%}

%{
x1 = input('Enter a value for x1:');
y1 = input('Enter a value for y1:');
x2 = input('Enter a value for x2:');
y2 = input('Enter a value for y2:');
%}

%Use the program to calculate the distance between the points (-3, 2) and (3, -6).

x1 = -3;
y1 = 2;
x2 = 3;
y2 = -6;

d = ((x2-x1)^2+(y2-y1)^2)^.5;
fprintf('The distance between (%d, %d) and (%d, %d) is %d\n', x1, y1, x2, y2, d);