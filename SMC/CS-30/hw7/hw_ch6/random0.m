function rand = random0 ( m, n )
    global ISEED
    message = nargchk(1, 2, nargin);
    error(message);
    if nargin < 2
        n = m;
    end
    rand = zeros(m, n);
    for ii = 1:m
        for jj = 1:n
            ISEED = mod (8121 * ISEED + 28411, 134456);
            rand(ii,jj) = ISEED / 134456;
        end
    end
end