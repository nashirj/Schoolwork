%{
10.3
Create a function that accepts any number of numeric input arguments and
sums up all of individual elements in the arguments. Test your function by
passing it the four arguments a = 10, b = [4;-2;2], c = [1,0,3;-5,1,2;1,2,0],
and d = [1,5,-2].
%}

%{
%interactive version of script
num_args = input('Enter the number of values you would like to enter: ');
vals=cell(num_args,1);
for ii=1:num_args
    fprintf('Enter value #%d\n',ii);
    vals{ii}=input('');
end
%end interactive segment
%}

%static version of script
num_args = 4;
a = 10;
b = [4;-2;2];
c = [1,0,3;-5,1,2;1,2,0];
d = [1,5,-2];

vals=cell(num_args,1);
vals{1,1} = a;
vals{2,1} = b;
vals{3,1} = c;
vals{4,1} = d;
%end static segment

total = 0;
for ii=1:num_args
    total = total + sum(vals{ii});
end

fprintf('The sum of all elements entered is %d.\n', total);