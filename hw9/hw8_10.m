%{
8.10
Plot the function v(t) = 10*e^((-0.2 + j*pi)t) for 0 <= t <= 10 using
function plot3, where the three dimensions to plot are the real part
of the function, the imaginary part of the function, and time.
%}

%Set range of t and calculate values of v
t = linspace(0, 10);
v = 10 * exp((-0.2 + 1i*pi).*t); %MATLAB says use 1i for improved robustness

%Plot real vs imaginary components of v(t)
plot3(real(v), imag(v), t);
title('\bf3D plot of Complex Function');
xlabel('\bf\itreal');
ylabel('\bf\itimaginary');
zlabel('\bf\ittime')