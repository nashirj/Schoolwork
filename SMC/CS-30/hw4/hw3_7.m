%{
3.7
Plot the function f(x) = (x^2 - 6x + 5)/(x - 3) using 200 points over the
range -2 <= x <= 8. Note that there is an asymptote at x = 3, so the
function will tend to infinity near to that point. In order to see the rest
of the plot properly, you will need to limit the y-axis to a reasonable
size, so use the axis command to limit the y-axis to the range -10 to 10.
%}

x = linspace(-2, 8);
f = (x.^2 - 6.*x + 5)./(x - 3);
plot(x, f)
axis([-2 8 -10 10])
title('(x^2 - 6x + 5)/(x - 3)');