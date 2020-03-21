%{
3.8
Suppose that George, Sam, Betty, Charlie, and Suzie contributed $15, $5,
$10, $5, and $15 respectively to a colleague’s going-away present. Create
a pie chart of their contributions. What percentage of the cost was paid
by Sam?
%}

george = 15;
sam = 5;
betty = 10;
charlie = 5;
suzie = 15;
explode = ([0 1 0 0 0]);
pie([george sam betty charlie suzie], explode);
legend('George', 'Sam', 'Betty', 'Charlie', 'Suzie');
fprintf('As indicated on the chart, Sam paid 10%%\n');