%{
Write a program that calculates the resonant frequency of this radio set
given specific values of L and C. Test your program by calculating the
frequency of the radio when L 5 0.25 mH and C 5 0.10 nF.
%}

l = .25 * 10^-3;
c = .1 * 10^-9;
f = 1/(2*pi*(l*c)^.5);
fprintf('The resonant frequency of the circuit is %e\n', f);