%{
7.5
Plot the function f(x) = 1/sqrt(x) over the range 0.1 <= x <= 10.0 using
function fplot. Be sure to label your plot properly.
%}

fplot(@(x) 1./sqrt(x),[0.1 10.0]);
title('\bfPlot of 1/sqrt(x)');
xlabel('\bfx');
ylabel('\bf1/sqrt(x)');