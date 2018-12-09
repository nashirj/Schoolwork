%{
Assume we have data in a two-dimensional matrix named A.

1. Write code that totals each column using one built-in function (no
    loop) and appends that total after the last row of the array. (2 points)

2. Show using fprintf the value of and where the total is highest and
    lowest e.g. if the highest total is at columns 7, show that highest
    value and what column it occurs at.  Do the same for the smallest
    value.  (2 point).

3. Calculate the average of the total, then how many values in the entire
original array A are above the average. (4 points).

Your code must be general enough so any 2-D array would fit in the code.
The code must also be automated so no manual counting is accepted, and
efficiency based on using array processing vs. loop is applied.
%}



N = 10;
A = rand(N);

%{
1. Write code that totals each column using one built-in function (no
    loop) and appends that total after the last row of the array. (2 points)
%}

B = sum(A);
s = size(A);
A(s(1),:) = B;


%{
2. Show using fprintf the value of and where the total is highest and
    lowest e.g. if the highest total is at columns 7, show that highest
    value and what column it occurs at.  Do the same for the smallest
    value.  (2 point).
%}
[total_max, max_ind] = max(B);
fprintf('The max total is %f and it occurs in column %d\n', total_max, max_ind);
[total_min, min_ind] = min(B);
fprintf('The min total is %f and it occurs in column %d\n', total_min, min_ind);


%{
3. Calculate the average of the total, then how many values in the entire
original array A are above the average. (4 points).
%}
avg = mean(B);
greater_than_avg = find(A > avg);
num_gta = size(greater_than_avg);
disp(num_gta);

%excluding B, i.e. original array A without appended row
avg2 = mean(B)/s(1);
greater_than_avg2 = find(A(1:end-1,:) > avg2);
num_gta2 = size(greater_than_avg2);
disp(num_gta2);