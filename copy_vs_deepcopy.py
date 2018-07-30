import copy
# from copy import deepcopy # use this import statement if doing sorted_lst = deepcopy(lst)

#    sorted_lst = []
#    for i in lst:
#        sorted_lst.append(i)
#    sorted_lst = lst.copy() # worked on my computer, but man says that this gives a shallow copy - is this valid?
    sorted_lst = copy.deepcopy(lst)
#    sorted_lst = deepcopy(lst)
    sorted_lst.sort()
    if lst == sorted_lst:
        return 'ascending order'
