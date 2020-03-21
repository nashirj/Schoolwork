%{
Exercise 6.8
calculate determinant of a triangle
%}
function result = area2d(x1, y1, x2, y2, x3, y3)
    result = 0.5 * (x1 * (y2 - y3) - x2 * (y1 - y3) + x3 * (y1 - y2));
end