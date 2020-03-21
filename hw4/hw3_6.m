%{
3.6
Plot the function f(x) = x^4 - 3x^3 +10x^2 - x - 2 for -6 <= x <= 6. Draw
the function as a solid black 2-point-wide line, and turn on the grid. Be
sure to include a title and axis labels, and include the equation for the
function being plotted in the title string. (Note that you will need steam
modifiers to get the italics and the superscripts in the title string.)
%}

x = linspace(-6, 6);
f = x.^4 - 3.*x.^3 + 10.*x.^2 - x - 2;
plot(x, f, 'k-', 'LineWidth', 2.0)
title('\itx\rm^{4}-3\itx\rm^{3}+10\itx\rm^{2}-\itx\rm-2 for -6 \leq \itx\rm \leq 6')
grid on
xlabel('x')
ylabel('f(x)')
