%{
8.14
An ellipsoid of revolution is the solid analog of a two-dimensional
ellipse. The equations for an ellipsoid of revolution rotated around the
x axis are x = acos(phi)cos(theta) y = acos(phi)sin(theta) z = bsin(phi),
where a is the radius along the x-axis, and b is the radius along the y
and z-axes. Plot an ellipsoid of revolution for a = 2 and b = 1.
%}

%Calculate the points on the surface of the ellipse
n = 20;
a = 2;
b = 1;
theta = linspace(-pi,pi,n);
phi = linspace(-pi/2,pi/2,n);
[theta,phi] = meshgrid(theta,phi);

%convert to (x,y,z) values
x = a*cos(phi).*cos(theta);
y = a*cos(phi).*sin(theta);
z = b*sin(phi);

surf(x, y, z);
title('\bfEllipsoid of revolution rotated about x-axis');