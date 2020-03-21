%{
Use function random0 to generate a set of 100,000 random values. Sort this
data set twice, once with the ssort function of Example 6.2, and once with
MATLAB’s built-in sort function. Use tic and toc to time the two sort
functions. How do the sort times compare? (Note: Be sure to copy the
original array and present the same data to each sort function. To have a
fair comparison, both functions must get the same input data set.)
%}
arr = random0(1, 100000);
to_sort = arr;
%user defined sort
tic
ssort(to_sort);
t1 = toc;
to_sort = arr;
%MATLAB built-in sort
tic
sort(to_sort);
t2 = toc;
%results
fprintf(['using ssort = ' num2str(t1)]);
fprintf('\n');
disp(['using MATLAB sort = ' num2str(t2)]);
fprintf('\n');