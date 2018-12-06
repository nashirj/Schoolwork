%{
8.8
Plot the function v(t) = 10*e^((-0.2 + j*pi)t) for 0 <= t <= 10 using the
function plot(v). What is displayed on the plot this time?
%}

%Set range of t and calculate values of v
t = linspace(0, 10);
v = 10 * exp((-0.2 + 1i*pi).*t); %MATLAB says use 1i for improved robustness

%Plot graph of real part vs imaginary part of v(t)
plot(v,'b-','LineWidth',2);
title('\bfPlot of Complex Function');
xlabel('\bf\itReal Part');
ylabel('\bf\itImaginary Part');

fprintf('This a plot of the real part versus the imaginary part of the data.\n');

