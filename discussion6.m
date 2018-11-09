%loop method
n=1:5; % build array before loop
for ii=1:5
    n(ii) = exp(ii);
end

disp(n);

N = 1:5;
N = exp(N);
disp(N)

%{
x = 1:5;
for ii = 1:5
    x(ii) = x(ii) + 1
end
%Vectorization method
y = 1:5;
y = y + 1;
%}