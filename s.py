def gen_y(n):
    for i in range(n):
        yield 2**i

g = gen_y(5)
print(next(g))
print(next(g))
print(next(g))