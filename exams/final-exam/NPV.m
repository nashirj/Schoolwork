%{
For the above question, write a function that takes the initial investment
amount, X, the revenue, Z, and the profit rate matrix PR as input to the
function. The function calculates the total Net Present Value (which you
did in the previous question step 3) and returns that value.
%}

function res = NPV(X, Z, PR)
narginchk(3, 3);
PV = zeros(1, 7);
for y=1:7
    PV(y) = Z/((1+PR(y))^y);
end
res = sum(PV) - X;
end