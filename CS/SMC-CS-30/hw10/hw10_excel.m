%{
hw10_excel

Using the 'matlabtext.xls' file, import the data using the uiimport wizard.

a. Using comments show which rows/columns were not included in the import.
    What data replacement was used?
b. Calculate the final score using the formula: 
    (max 10 assignments - i.e. drop the lowest) + (add the two midterms) + 
    Final exam  + Discussion. Add a column to show the final score.
c. Calculate the final grade based on 90-100 = A, 80- < 90 B, 70 - < 80 C,
    60 - < 70 D, and < 60 F. Add a column to show the final grade.
d. Using fprintf, show a table of the final score and grade.
e. Sort the table by the final score, and show the result.
f. Show the min, max and average final score.
%}

%{
a. Using comments show which rows/columns were not included in the import.
    What data replacement was used?
%}
%the first row which indicated the values in each column was of mixed
%format, containing both text and number values.
student = struct('fN',[],'lN',[],'a1',[],'a2',[],'a3',[],'a4',[],'a5',[], ...
    'a6',[],'a7',[],'a8',[],'a9',[],'a10',[],'a11',[],'disc',[], ...
    'f',[],'m1',[],'m2',[]);


%{
b. Calculate the final score using the formula: 
(max 10 assignments - i.e. drop the lowest) + (add the two midterms) +
Final exam  + Discussion. Add a column to show the final score.
%}

n = size(names, 1);
for ii=1:n
    temp = sort(assignments{ii,:});
    total = sum(temp(2:end)) + sum(exam_and_disc{ii,:});
    student(ii).fScore = total;
end
%{
c. Calculate the final grade based on 90-100 = A, 80- < 90 B, 70 - < 80 C,
    60 - < 70 D, and < 60 F. Add a column to show the final grade.
%}

for ii=1:n
    if student(ii).fScore > 90
        grade = 'A';
    elseif student(ii).fScore > 80
        grade = 'B';
    elseif student(ii).fScore > 70
        grade = 'C';
    elseif student(ii).fScore > 60
        grade = 'D';
    else
        grade = 'F';
    end
    student(ii).fGrade = grade;
end

%{
d. Using fprintf, show a table of the final score and grade.
%}
for ii=1:n
    fprintf('%.2f, %c\n', student(ii).fScore, student(ii).fGrade);
end

%{
e. Sort the table by the final score, and show the result.
%}

sorted = sort([student.fScore]);

%{
f. Show the min, max and average final score.
%}
%after sorting by final score, the following statement would be correct
fprintf('The min is %.2f, the max is %.2f, and the average is %.2f.\n', ...
    sorted(1), sorted(end), mean(sorted));
