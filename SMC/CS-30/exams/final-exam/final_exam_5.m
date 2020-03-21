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

%{
option 1
[r,c]=size(A)
returns r as rows and c as columns
add one to r to assign it to B
A(r+1,:) = B;
%}

%{
option 2, Easier way is to use ; as new row operator:
%}

C = [A;B];

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

%To find how many elements are > mean(B), 
%sum(find(A>mean(B)))

num_gta = size(find(C > mean(B)));
disp(num_gta);

%excluding B, i.e. original array A without appended row
s = size(B);
avg2 = mean(B)/s(2);
greater_than_avg2 = find(C(1:end-1,:) > avg2);
num_gta2 = size(greater_than_avg2);
disp(num_gta2);