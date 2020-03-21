%{
2.18 Energy Stored in a Spring The force required to compress a linear spring is given by the
equation F = kx	(2.24) where F is the force in newtons and k is the spring constant in newtons
per meter. The potential energy stored in the compressed spring is given by the equation E = 0.5*k*x^2
(2.25) 2 where E is the energy in joules.

Determine the compression of each spring and the potential energy stored in each spring. Which
spring has the most energy stored in it?
%}

%given values
forces = [20,30,25,20];
k = [200,250,300,400];

%calculate x values
x = forces./k;
%calculate E for given displacement and spring constant k
E = 0.5*k.*x.^2;
[maxval, index] = max(E);
fprintf('The max value of potential energy is %f, which is in spring %d\n', maxval, index);
