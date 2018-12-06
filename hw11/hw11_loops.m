%{
VERSION WITH LOOP

From provided file, and using the assignment specs from last week, show the
first and last name of the student with the highest score. Show the list
of students (first and last name) and the count of those students who's
final score is above the average.
%}

student = struct('fN',[],'lN',[],'a1',[],'a2',[],'a3',[],'a4',[], ...
    'disc',[],'f',[],'m1',[]);

%{
b. Calculate the final score using the formula: 
(max 4 assignments - i.e. drop the lowest) + (add the midterm) +
Final exam + Discussion. Add a column to show the final score.
%}

student_names = table2array(names);
n = size(names, 1);

for ii=1:n
    student(ii).fN = student_names(ii, 1);
    student(ii).lN = student_names(ii, 2);
    student(ii).fScore = sum(grades{ii,1:4}) - min(grades{ii,1:4}) ...
        + sum(grades{ii,5:7});
end

%show the first and last name of the student with the highest score
[val, index] = max([student.fScore]);
fprintf("%s %s had the high score of %.2f.\n", ...
            student(index).fN, student(index).lN, student(index).fScore);

%Show the list of students (first and last name)
fprintf('List of enrolled students:\n');
fprintf("%s %s\n", student.fN, student.lN);

%show the count of those students who's final score is above the average
avg = sum([student.fScore])/n;
for ii=1:n
    if student(ii).fScore > avg
        fprintf("%s %s's score (%.2f) is above average\n", ...
            student(ii).fN, student(ii).lN, student(ii).fScore);
    end
end
