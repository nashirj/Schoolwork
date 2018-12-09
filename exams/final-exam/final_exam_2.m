%{
The Net Present Value is an index used to figure out the time it takes for
an investment to become profitable. A simple formula is this:

The first year the investment is made, the Present Value, PV is -X, where
X is the amount of money invested. Each year after that, the PV is the
(revenue of that year)/(1+ the profit rate) to the power of the year.

For example, for year 2, the PV is:

(Revenue)/(1+ profit rate at year 2)2

For year y, PV is: (Revenue)/(1+Profit rate at year y)y

Assume the profit rate is: [2, 4, 3, 6, 2, 7, 5]
Assume the revenue each year is Z (a constant).

Calculate for each year what the PV is, starting from year 1 using the
following steps:
1. Create a zeros matrix named PV, that is the same size of the profit
    rate matrix. Do not count manually. (2 points)
2. Use a for loop to calculate each element of PV at each year. (5 points)
3. Once you complete the calculation, what is the NPV? It's the sum of all
    the elements of PV +  -X. (1 point)
%}

Z = 10;
X = 1; %initial investment
%1
PV = zeros(1, 7);
PR = [2, 4, 3, 6, 2, 7, 5];

%2
for y=1:7
    PV(y) = Z/((1+PR(y))^y);
end

%3
NPV = sum(PV) - X;