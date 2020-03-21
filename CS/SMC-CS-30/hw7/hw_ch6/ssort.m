function out = ssort(a)
    nvals = length(a);
    for ii = 1:nvals-1 
        % Find the minimum value in a(ii) through a(nvals) 
        iptr = ii;
        for jj = ii+1:nvals
            if a(jj) < a(iptr) 
                iptr = jj;
            end
        end
        % iptr now points to the min value, so swap a(iptr) % with a(ii) if iptr ~= ii
        if ii ~= iptr
            temp = a(ii);
            a(ii) = a(iptr);
            a(iptr) = temp;
        end
    end
    out = a;
end