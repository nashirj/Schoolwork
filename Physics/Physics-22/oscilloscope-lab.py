def voltage(volts_per_div, num_of_divs):
    return volts_per_div * num_of_divs

def d_z(x, d_x, y, d_y):
    return x * d_y + y * d_x

def calc_period(time_per_div, num_of_divs):
    return time_per_div * num_of_divs

def calc_frequency(period):
    return 1/period

def d_calc_frequency(period, d_period):
    return d_period/(period**2)

def percent_error(expected, measured):
    return (abs(expected-measured)/expected) * 100

# 1200
volts_per_div = 1
d_volts_per_div = 0.03
num_of_divs = 6.1
d_num_of_divs = 0.1
voltage_1200 = d_z(volts_per_div, d_volts_per_div, num_of_divs, d_num_of_divs)
# print(voltage_1200)

# other
num_of_divs = 6
voltage_other = d_z(volts_per_div, d_volts_per_div, num_of_divs, d_num_of_divs)
# print(voltage_other)

# mystery
num_of_divs = 5.8
voltage_myst = d_z(volts_per_div, d_volts_per_div, num_of_divs, d_num_of_divs)
# print(voltage_myst)

# dry cell
volts_per_div = 0.50
d_volts_per_div = 0.015
num_of_divs = 2.8
d_num_of_divs = 0.1
dry_cell_voltage = voltage(volts_per_div, num_of_divs)
# print(d_z(volts_per_div, d_volts_per_div, num_of_divs, d_num_of_divs))

# calculate frequencies

# 1200
time_per_div = .0005 # 1 ms/div
d_time_per_div = 0.0000015 # 0.03 ms/div
num_of_divs = 1.6
d_num_of_divs = 0.1
period = calc_period(time_per_div, num_of_divs)
frequency_1200 = calc_frequency(period)
print(frequency_1200)
d_period = d_z(time_per_div, d_time_per_div, num_of_divs, d_num_of_divs)
print(d_calc_frequency(period, d_period))

# other
time_per_div = 0.00005 # 1 ms/div
d_time_per_div = 0.0000015 # 0.03 ms/div
num_of_divs = 1.5
d_num_of_divs = 0.1
period = calc_period(time_per_div, num_of_divs)
frequency_other = calc_frequency(period)
# print(frequency_other)
d_period = d_z(time_per_div, d_time_per_div, num_of_divs, d_num_of_divs)
# print(d_calc_frequency(period, d_period))

# mystery
time_per_div = .001 # 1 ms/div
d_time_per_div = 0.00003 # 0.03 ms/div
num_of_divs = 1.5
d_num_of_divs = 0.1
period = calc_period(time_per_div, num_of_divs)
frequency_myst = calc_frequency(period)
# print(frequency_myst)
d_period = d_z(time_per_div, d_time_per_div, num_of_divs, d_num_of_divs)
# print(d_calc_frequency(period, d_period))


print(percent_error(1200, frequency_1200))
# print(percent_error(12400, frequency_other))
# print(percent_error(567, frequency_myst))
# print(percent_error(1.5, dry_cell_voltage))