%{
3.12
Create an array of 100 input samples in the range 1 to 100 using the
linspace function, and plot the equation: y(x) = 20log_10(2x) on a semilogx
plot. Draw a solid blue line of width 2, and label each point with a red
circle. Now create an array of 100 input samples in the range 1 to 100
using the logspace function, and plot Equation (3.5) on a semilogx plot.
Draw a solid red line of width 2, and label each point with a black star.
How does the spacing of the points on the plot compare when using linspace
and logspace?
%}

x = linspace(1, 100);
y = 20*log10(2*x);
figure(1);
semilogx(x, y, 'b-', 'LineWidth', 2.0)
hold on;
semilogx(x, y, 'ro')
hold off;

x1 = logspace(1, 100);
y1 = 20*log10(2*x1);
figure(2);
semilogx(x1, y1, 'r-', 'LineWidth', 2.0)
hold on;
semilogx(x1, y1, 'k*')
hold off;

fprintf('The distribution of points is much better when for semilogx when using logspace\n');