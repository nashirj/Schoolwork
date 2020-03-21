%{
Plot the function y(x) = e^(-0.5x)*sin(2x) for 100 values of x between 0 and
10. Use a 2-point-wide solid blue line for this function. Then plot the
function e^(-0.5x)*cos(2x) on the same axes. Use a 3-point-wide dashed
red line for this function. Be sure to include a legend, title, axis
labels, and grid on the plots.
%}

y = linspace(0,10);
y1 = sin(2.*x).*exp(-0.5.*x);
plot(x,y1, 'b-', 'LineWidth', 2.0)
title('sin(2x)/sqrt(e) vs. cos(2x)/sqrt(e)')
xlabel('x');
ylabel('y');
grid on;

hold on

y2 = cos(2.*x).*exp(-0.5.*x);
plot(x,y2, 'r--', 'LineWidth', 3.0)

legend('sin(2x)/sqrt(e)', 'cos(2x)/sqrt(e)');

hold off