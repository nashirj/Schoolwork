%{
8.9
Create a polar plot of the function v(t) = 10*e^((-0.2 + j*pi)t) for 0 <= t <= 10.
%}

%Set range of t and calculate values of v
t = linspace(0, 10);
v = 10 * exp((-0.2 + 1i*pi).*t); %MATLAB says use 1i for improved robustness

%Plot polar graph of v(t)
polar(angle(v), abs(v));
title('\bfPolar plot of Complex Function');