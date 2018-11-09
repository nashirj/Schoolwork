function x = my_fix(n)
    if (n > 0)
        x = floor(n);
    elseif (n < 0)
        x = ceil(n);
    else
        x = 0;
    end
end