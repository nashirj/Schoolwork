%{
8.15
Plot a sphere of radius 2 and an ellipsoid of revolution for a = 1 and
b = 0.5 on the same axes. Make the sphere partially transparent so that
the ellipsoid can be seen inside it.
%}

%Calculate the points on the surface of the ellipse and sphere
n = 20;
a = 1;
b = 0.5;
r = 2;
theta = linspace(-pi,pi,n);
phi = linspace(-pi/2,pi/2,n);
[theta,phi] = meshgrid(theta,phi);

%convert to (x,y,z) values for ellipse
xe = a*cos(phi).*cos(theta);
ye = a*cos(phi).*sin(theta);
ze = b*sin(phi);

%convert to (x,y,z) values for sphere
xs = r * cos(phi) .* cos(theta);
ys = r * cos(phi) .* sin(theta);
zs = r * sin(phi);

%plot sphere and ellipse
surf(xe, ye, ze);
hold on;
surf(xs, ys, zs);
hold off;
title('\bfEllipsoid of revolution enclosed by sphere of revolution.');
alpha(0.5);