%{
7.8
Create an array of 100,000 samples from function randn, the built-in MATLAB
Gaussian random number generator. Plot a histogram of these samples over 21
bins.
%}
f = randn(100000, 1);
hist(f, 21);
title('\bfRandom sample histogram');