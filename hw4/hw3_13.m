%{
3.13
use the Data from 13 to plot three plots:
1. Average daily high, then show what the max, min and average are for that
    column. Make sure to use disp or fprintf to answer questions.
2. Extreme High, then show same data as in 1.
3. Extreme Low, then show same data as in 1.
%}

avg_daily_high = [66 70 75 84  93 103 105 103  99 88 75 66];
extreme_high = [88 92 100 105 114 122 121 116 116 107 96 87];
extreme_low = [16 24 25 35 39 50 63 61 47 34 27 22];

avg_dh = mean(avg_daily_high);
max_dh = max(avg_daily_high);
min_dh = min(avg_daily_high);
fprintf('Daily highs: the average was %f°F, the max was %d°F, and the min was %d°F.\n', avg_dh, max_dh, min_dh);

avg_eh = mean(extreme_high);
max_eh = max(extreme_high);
min_eh = min(extreme_high);
fprintf('Extreme highs: the average was %f°F, the max was %d°F, and the min was %d°F.\n', avg_eh, max_eh, min_eh);

avg_el = mean(extreme_low);
max_el = max(extreme_low);
min_el = min(extreme_low);
fprintf('Extreme lows: the average was %f°F, the max was %d°F, and the min was %d°F.\n', avg_el, max_el, min_el);

figure(1);
plot(avg_daily_high)
title('Average daily highs in degrees Fahrenheit');
xlabel('Months of the year');
ylabel('Degrees Fahrenheit');
figure(2);
plot(extreme_high)
title('Extreme highs in degrees Fahrenheit');
xlabel('Months of the year');
ylabel('Degrees Fahrenheit');
figure(3);
plot(extreme_low)
title('Extreme lows in degrees Fahrenheit');
xlabel('Months of the year');
ylabel('Degrees Fahrenheit');