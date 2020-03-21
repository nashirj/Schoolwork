%{
0 ? x ? 10pi, with increments of 0.1pi
f(x) = x^2*sin(x)

Use a green dashed line type with square markers. 
Add x and y axis titles of 'x axis' and 'x2sin(x)'.
Do not add a title to the plot.
%}

x = 0:0.1*pi:10*pi;
f = x.^2.*sin(x);

plot(x, f, '--gs');

xlabel('\bfx axis');
ylabel('\bfx^{2}sin(x)');