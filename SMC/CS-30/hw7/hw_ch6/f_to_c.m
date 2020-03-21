%{
Exercise 6.6
Write a function f_to_c that accepts a temperature in degrees Fahrenheit
and returns the temperature in degrees Celsius. The equation is:
%}
function result = f_to_c(temp)
    result = (5/9) * (temp - 32);
end