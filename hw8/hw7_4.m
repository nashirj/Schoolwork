%{
7.4
Write a program that creates three anonymous functions representing the
functions f(x) = 10cosx, g(x) = 5sinx, and h(a, b) = sqrt(a^2 + b^2). Plot
f, g, and h over the range -10 <= x <= 10
%}
function res = hw7_4(x)
f = @(x) 10.*cos(x);
g = @(x) 5.*sin(x);
a = f(x);
b = g(x);
h = @(a, b) sqrt(a.^2 + b.^2);
res = h(a, b);
end
