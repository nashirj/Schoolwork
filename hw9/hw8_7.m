%{
8.7
Plot the function v(t) = 10*e^((-0.2 + j*pi)t) for 0 <= t <= 10 using the
function plot(t,v). What is displayed on the plot?
%}

%Set range of t and calculate values of v
t = linspace(0, 10);
v = 10 * exp((-0.2 + 1i*pi).*t); %MATLAB says use 1i for improved robustness

%Plot graph of t vs. real values of v(t)
plot(t, v, 'LineWidth', 2);
title('\bfPlot of Complex Function vs Time');
xlabel('\bf\itt');
ylabel('\bf\itv(t)');
fprintf('This plot ignores the imaginary parts of the complex number argument.\n');