%{
7.3
Write a single MATLAB function hyperbolic to calculate the hyperbolic sine,
cosine, and tangent functions as defined in Exercise 6.20. The function
should have two arguments. The first argument will be a string containing
the function names 'sinh', 'cosh', or 'tanh', and the second argument will
be the value of x at which to evaluate the function. The file should also
contain three local functions sinh1, cosh1, and tanh1 to perform the actual
calculations, and the primary function should call the proper local
function depending on the value in the string. (Note: Be sure to handle the
case of an incorrect number of arguments and also the case of an invalid
string. In either case, the function should generate an error.)
%}
function res = hyperbolic(fun, x)
msg = nargchk(2,2,nargin);
error(msg);
    %sinh implementation
    function res = sinh1(x)
        res = (exp(x)-exp(-x))/2;
    end
    %cosh implementation
    function res = cosh1(x)
        res = (exp(x)+exp(-x))/2;
    end
    %tanh implementation
    function res = tanh1(x)
        res = (exp(x)-exp(-x))/(exp(x)+exp(-x));
    end

    %main function
    if (strcmp(fun, 'sinh') == 1)
        res = sinh1(x);
    elseif (strcmp(fun, 'cosh') == 1)
        res = cosh1(x);
    elseif (strcmp(fun, 'tanh') == 1)
        res = tanh1(x);
    else
        error('invalid function');
    end
end
