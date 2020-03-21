%{
For the above function, write code to get the input from the user,
for the initial investment X, the revenue Z, and uses a PR matrix of
    [2, 4, 3, 6, 2, 7, 5]
and call the function from above, then show the output using fprintf.
%}

X = input('Please input the initial investment (a scalar): ');
Z = input('Please input the revenue (a scalar): ');
PR = [2, 4, 3, 6, 2, 7, 5];

answer = final_exam_3(X, Z, PR);
fprintf('The NPV is %f\n', answer);