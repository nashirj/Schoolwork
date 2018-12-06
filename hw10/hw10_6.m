%{
10.6
Define a structure point containing two fields x and y. The x field will
contain the x-position of the point, and the y field will contain the
y-position of the point. Then write a function dist3 that accepts two
points and returns the distance between the two points on the Cartesian
plane. Be sure to check the number of input arguments in your function.
%}

point(2) = struct('x',[],'y',[]);

point(1).x = 5;
point(1).y = 6;
point(2).x = 2;
point(2).y = 2;

res = dist3(point(1), point(2));

fprintf('The distance between point 1 and point 2 is %f\n', res);

function result = dist3(a, b)
narginchk(2, 2);
result = sqrt((b.x-a.x)^2 + (b.y-a.y)^2);
end