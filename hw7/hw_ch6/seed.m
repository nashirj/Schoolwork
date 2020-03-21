function seed(new_seed)
    global ISEED
    message = nargchk(1,1,nargin);
    error(message);
    new_seed = round(new_seed);
	ISEED = abs(new_seed);
end