def remove_values_from_list(the_list, val):
   return [value for value in the_list if value != val]

if __name__ == '__main__':
    x = [1, 2, 3, 4, 2, 2, 3]
    x = remove_values_from_list(x, 2)
    print x