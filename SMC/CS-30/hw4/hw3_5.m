%{
3.5
Create a polar plot of the function r(theta) = sin(2theta)cos(theta)
for 0 <= theta <= 2pi.
%}

theta = linspace(0, 2*pi);
r = sin(2.*theta).*cos(theta);
polar(theta, r)
title('sin(2*theta)cos(theta)')