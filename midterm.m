%{
%number 1
fprintf('There are %d rows and %d columns in X', size(X));

%number 2
B = 0 : 0.5*pi : 5*pi;

%}

%number 3

mph = linspace(0, 65, 20);
fps = mph .* 5280 ./ 3600;
fprintf('   mph || fps\n');
A = [round(mph(:)), round(fps(:))];
disp(A);


%{
%number 4
%{
plot y = 2x - sin(x) for the range -2pi to +2\pi in 0.1\pi increments.
use dotted red line with star markers.
add the x axis title of 'x' and a y axis title of '2x-sin(x)'
%}
x = -2*pi : 0.1*pi : 2*pi;
y = 2.*x - sin(x);

plot(x, y, 'r--*');
xlabel ('x');
ylabel ('2x - sin(x)');


%}

%number 5
%{
Assume a matrix x, contains data in four columns, where the first 3  represent the scores of 3 quizzes
as in the first column is the score of quiz 1, the second column is the score of quiz 2 and the third
column is the score of quiz 3. Assume the forth column is the ID# of the students in the class.

1. Show using fprintf the ID# of the student who got the highest score in the second quiz using MATLAB
commands (do not create sample data).

2. Show for each student their average score of the three quizzes. Code must use a built in function to
calculate the average.
%}
%{
x = [
    100 90 80 12345
    90 95 80 14325
    100 60 100 14325
    ];

quiz1 = x(:, 1);
quiz2 = x(:, 2);
quiz3 = x(:, 3);

[max2, index2] = max(quiz2);

fprintf('The top score on quiz 2 was %d and was achieved by student %d\n', max2, x(index2, 4));

fprintf('The average of quiz 1 was %f\n', mean(quiz1));
fprintf('The average of quiz 2 was %f\n', mean(quiz2));
fprintf('The average of quiz 3 was %f\n', mean(quiz3));

%}