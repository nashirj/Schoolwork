num_vals = 20;
%num_vals = 100000;
num = 1:num_vals;
x = [-4.91, -3.84, -2.41, -2.62, -3.78, -0.52, -1.83, 2.01, 0.28, 1.08, -0.94, 0.59, 0.69, 3.04, 1.01, 3.60, 4.53, 6.13, 4.43, 4.12];
y = [-8.18, -7.49, -7.11, -6.15, -6.62, -3.30, -2.05, -2.83, -1.16, 0.52, 0.21, 1.73, 3.96, 4.26, 6.75, 6.67, 7.70, 7.31, 9.05, 10.95];
%x = random0(1, num_vals);
%y = random0(1, num_vals);
data = [num(:), x(:), y(:)];
%method 1
tic
sorted = sort(data);
min1 = sorted(1,:);
max1 = sorted(num_vals,:);

t1 = toc;
%method 2
tic
max2 = max(data);
min2 = min(data);
t2 = toc;
%results
fprintf('METHOD 1:\n');
fprintf(['    maximum = ' num2str(max1(2:3))]);
fprintf('\n');
fprintf(['    minimum = ' num2str(min1(2:3))]);
fprintf('\n');
fprintf(['    the time for sorting then displaying vals was: ' num2str(t1)]);
fprintf(' seconds\n');

fprintf('METHOD 2:\n');
fprintf(['    maximum = ' num2str(max2(2:3))]);
fprintf('\n');
fprintf(['    minimum = ' num2str(min2(2:3))]);
fprintf('\n');
fprintf(['    the time for using built in MATLAB function was: ' num2str(t2)]);
fprintf(' seconds\n');
