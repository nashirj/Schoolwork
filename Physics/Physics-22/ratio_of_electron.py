import numpy as np

def x_i(r):
    d = 16
    del_d = .2
    return r * (4 + (d/r)**2)**1.5


u0 = 4 * np.pi * 10**(-7)

r1 = 0.5 * np.array([29, 30, 30.1, 31])
r1_avg = np.mean(r1)
r1_std = np.std(r1, ddof=1)
print(r1_std)
print(r1_avg)
r2 = 0.5 * np.array([30.6, 28.6, 29.5, 29.4])
r2_avg = np.mean(r2)
r2_std = np.std(r2, ddof=1)
print(r2_std)
print(r2_avg)

x1 = x_i(r1_avg)/100
print("x1 is " + str(x1))

x2 = x_i(r2_avg)/100
print("x2 is " + str(x2))

k = 520 * u0 * (1/x1 + 1/x2)
print("k is " + str(k))


# B_earth
B_earth = k * .02
print("B earth " + str(B_earth))


k = 4.95 * 10**-4


I = np.array([3, 2.75, 2.5, 2.2, 1.9, 1.8, 1.7, 1.54])
B = k * I
B -= (0.476 * 10**-4)

Binv = 1/B
r = [2.5, 2.8, 3.0, 3.5, 4.0, 4.3, 4.5, 5.0]
print(Binv)

coeff = np.polyfit(r, B, 2)

p30 = np.poly1d(np.polyfit(r, Binv, 1))

import matplotlib.pyplot as plt

p = np.poly1d(coeff)
xp = np.linspace(-2, 6, 100)

_ = plt.plot(r, Binv, '.', xp, p(xp), '-')
# plt.show()

def e_m(V, R, k, B):
    return ((2*V)/(B**2)) * (1/R**2)

V = np.array([150, 200, 300, 350, 400, 450, 500])
r = 0.04
I = np.array([1.24, 1.54, 1.94, 2.12, 2.24, 2.38, 2.56])
B = k * I
print(V)
print(e_m(V, r, k, B))




print("\n\n\n\n")
I = 0.02
R = 0.15
d = .16
B = (u0 * I * R**2)/((R**2 + (.25)*(d**2))**1.5)
print(B)
N = int(B_earth/B)
print(N)

print(B_earth)

B = (0.716 * u0 * N * I)/R
print(B)
