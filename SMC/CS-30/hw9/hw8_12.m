%{
8.12
Create a mesh, surface plot, and contour plot of the function z = e^(x+iy)
for the interval –1 <= x <= 1 and -2pi <= y <= 2pi. In each case, plot the
real part of z versus x and y.
%}

%Set range of z(x,y) and calculate values of z
[x,y] = meshgrid(-1:0.1:1, -2*pi:0.2*pi:2*pi);
z = exp(x + 1i*y);

%Create 3 figures, one for each type of plot
%Mesh plot
figure();
mesh(x, y, real(z));
title('\bfMesh plot of z = e^{x+iy}');

%Surface plot
figure();
surf(x, y, real(z));
title('\bfSurface plot of z = e^{x+iy}');

%Contour plot
figure();
contour(x, y, real(z));
title('\bfContour plot of z = e^{x+iy}');