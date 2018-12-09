%{
Focus on how to use the major functions we learned like min, max, mean,
size, and how to extract elements of an array (rows and columns),
plotting, for loops, measuring execution time, if and switch, and writing
functions. Officially the final exam covers all the topics we learned, but
the main focus will be on the above mentioned topics.
%}

x = linspace(0, 10);
y = exp(x);

n = rand(10);


%{
For the following data, show using code that calculates which contestant
had the highest score. The first column is the contestant ID #, and the
second column is the scores.
x = [11,  56;
42,  78;
23,  92;
4,   82;
50,  50]
You must use only one built-in function (max) to get the row where that
max is found, then show the corresponding value from the contestant ID
column using an output function.

[a,b]=max(x(:,2)) --> returns the max in a and the location in b.
use disp to show b.
%}


%measuring execution time
start = tic;
%A = rand(12000, 4400);
%B = rand(12000, 4400);
fin1 = toc(start);
%C = A'.*B';
fin2 = toc(start) - fin1;

fprintf('fin1 = %f, fin2 = %f\n', fin1, fin2);



%for loops
for ii=0:10
    fprintf('hi\n');
end

%if and switch
fprintf('my name is ');
if(10 > 5)
    fprintf('swag\n');
else
    fprintf('Nash\n');
end

%n = input('Enter a number: ');
n = 1;

switch n
    case -1
        disp('negative one')
    case 0
        disp('zero')
    case 1
        disp('positive one')
    otherwise
        disp('other value')
end

fprintf('%d\n',swag(2, 3));

%{
Plot the following:
0 ? x ? 10Pi
f(x) = xsin(x)

use a red dashed line type.
%}

x = 0:0.1*pi:10*pi;
fx = x.*sin(x);
figure(1)
plot(x, fx, '--r');

%Set range of t and calculate values of v
t = linspace(0, 10);
v = 10 * exp((-0.2 + 1i*pi).*t); %MATLAB says use 1i for improved robustness

%Plot graph of t vs. real values of v(t)
figure(2)
plot(t, v, 'LineWidth', 2);
title('\bfPlot of Complex Function vs Time');
xlabel('\bf\itt');
ylabel('\bf\itv(t)');
%fprintf('This plot ignores the imaginary parts of the complex number argument.\n');

%Plot graph of real part vs imaginary part of v(t)
figure(3)
plot(v,'b-','LineWidth',2);
title('\bfPlot of Complex Function');
xlabel('\bf\itReal Part');
ylabel('\bf\itImaginary Part');

%Plot polar graph of v(t)
figure(4)
polar(angle(v), abs(v));
title('\bfPolar plot of Complex Function');

%Plot real vs imaginary components of v(t)
figure(5)
plot3(real(v), imag(v), t);
title('\bf3D plot of Complex Function');
xlabel('\bf\itreal');
ylabel('\bf\itimaginary');
zlabel('\bf\ittime')

%Set range of z(x,y) and calculate values of z
[x,y] = meshgrid(-1:0.1:1, -2*pi:0.2*pi:2*pi);
z = exp(x + 1i*y);

%Create 3 figures, one for each type of plot
%Mesh plot
figure(6);
mesh(x, y, real(z));
title('\bfMesh plot of z = e^{x+iy}');

%Surface plot
figure(7);
surf(x, y, real(z));
title('\bfSurface plot of z = e^{x+iy}');

%Contour plot
figure(8);
contour(x, y, real(z));
title('\bfContour plot of z = e^{x+iy}');


%writing functions
function res = swag(x, y)
narginchk(2,2);
res = x + y;
end
