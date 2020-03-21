%{
Assume there are two functions; one function is named fun1, and the other
    function is named fun2. They both take an input matrix and result the
    same logical output.

Write code to compare the time it takes each function to produce its
    result, and show using fprintf which function is faster and the time
    difference is. Assume the input matrix is X, and that is it already
    filled with data.
%}

X = rand(10);
start1 = tic;
res1 = fun1(X);
fin1 = toc(start1);

start2 = tic;
res2 = fun2(X);
fin2 = toc(start2);

fprintf('The difference between the runtimes of function 1 and function 2 is %f\n', abs(fin2 - fin1));
if (fin1 < fin2)
    fprintf('Function 1 is faster than function 2\n');
elseif (fin1 > fin2)
    fprintf('Function 2 is faster than function 1\n');
else
    fprintf('Function 1 and function 2 have the same runtime\n');
end