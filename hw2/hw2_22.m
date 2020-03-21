%a = v^2/r;

%part a)
mach = 340;
g = 9.81;
v = mach*.85;
a = 2*g;
r = v^2/a;
fprintf('The turning radius of the aircraft is %f meters\n', r);

%part b)
v = mach * 1.5;
r = v^2/a;
fprintf('The turning radius of the aircraft is %f meters\n', r);

%part c)
%{
Plot the turning radius as a function of aircraft speed for speeds between
Mach 0.5 and Mach 2.0, assuming that the acceleration remains 2 g.
%}
a = 2*g;
speeds = mach * 0.5 : mach * 0.1 : mach * 2.0;
radii = speeds.^2/a;
plot(speeds, radii);
title ('Plot of r(v) for Mach 0.5 <= v <= Mach 2.0, with constant g');
xlabel('speed');
ylabel('radius');

%part d)
%{
Suppose that the maximum acceleration that the pilot can stand is 7 g. What
is the minimum possible turning radius of the aircraft at Mach 1.5?
%}
a = 7 * g;
v = 1.5 * mach;
r = v^2/a;
fprintf('The minimum possible turning radius of the aircraft at Mach 1.5 is %f meters\n', r);

%part e)
%{
Plot the turning radius as a function of centripetal acceleration for
accelerations between 2 g and 8 g, assuming a constant speed of Mach 0.85.
%}
v = mach * 0.85;
acceleration = 2 * g : 0.1 * g : 8 * g;
radii2 = v^2 ./ acceleration;
plot(acceleration, radii2);
title ('Plot of r(a) for 2g <= a <= 8g, with constant v');
xlabel('acceleration');
ylabel('radius');
