%{
x1 = input('Enter a value for x1:');
y1 = input('Enter a value for y1:');
z1 = input('Enter a value for z1:');
x2 = input('Enter a value for x2:');
y2 = input('Enter a value for y2:');
z2 = input('Enter a value for z2:');
%}

%Use the program to calculate the distance between the points (-3, 2, 5) and (3, -6, -5).

x1 = -3;
y1 = 2;
z1 = 5;
x2 = 3;
y2 = -6;
z2 = -5;

d = ((x2-x1)^2+(y2-y1)^2+(z2-z1)^2)^.5;
fprintf('The distance between (%d, %d, %d) and (%d, %d, %d) is %f\n', x1, y1, z1, x2, y2, z2, d);