%{
Using array1 shown below, show the max, min and average values of each
column, of each row, and of the entire array. For each max, min show what
row or column does that value occur at.
%}

array1 = [1.1 0.0 -2.1 -3.5 6.0
    0.0 -3.0 -5.6 2.8 4.3
    2.1 0.3 0.1 -0.4 1.3
    -1.4 5.1 0.0 1.1 -3.0];
[col_max, col_max_loc] = max(array1);
[row_max, row_max_loc] = max(array1, [], 2); %same as max(array') -> gives an error warning
[col_min, col_min_loc] = min(array1);
[row_min, row_min_loc] = min(array1, [], 2); %same as min(array') -> gives an error warning
col_avg = mean(array1);
row_avg = mean(array1, 2); %same as mean(array') -> gives an error warning
arr_avg = mean(array1, 'all');
arr_max, max_loc = max(array1, [], 'all');
arr_min, min_loc = min(array1, [], 'all');
for n = 1:5
    fprintf('max of column %d (at index %d) is %f\n', n, col_max_loc(n), col_max(n));
end
for m = 1:4
    fprintf('max of row %d (at index %d) is %f\n', m, row_max_loc(m), row_max(m));
end
for n = 1:5
    fprintf('min of column %d (at index %d) is %f\n', n, col_min_loc(n), col_min(n));
end
for m = 1:4
    fprintf('min of row %d (at index %d) is %f\n', m, row_min_loc(m), row_min(m));
end
for n = 1:5
    fprintf('avg of column %d is %f\n', n, col_avg(n));
end
for m = 1:4
    fprintf('avg of row %d is %f\n', m, row_avg(m));
end
fprintf('max of the entire array is %f\n', arr_max);
fprintf('min of the entire array is %f\n', arr_min);
fprintf('avg of the entire array is %f\n', arr_avg);