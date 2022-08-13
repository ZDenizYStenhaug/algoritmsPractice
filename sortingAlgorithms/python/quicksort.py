# quicksort

arr = [0, 2, 12, 3, 6, 5, 30, 20, 13]

def quicksort(arr):
    if len(arr) < 2:
        return arr
    if len(arr) == 2:
        if arr[0] < arr[1]:
            return arr
        else:
            arr[0], arr[1] = arr[1], arr[0]
            return arr
    pivotIndex = int(len(arr) / 2)
    pivot = arr.pop(pivotIndex)
    lesser = [i for i in arr if i < pivot]
    greater = [i for i in arr if i > pivot]
    return quicksort(lesser) + [pivot] + quicksort(greater)


print(quicksort(arr))
