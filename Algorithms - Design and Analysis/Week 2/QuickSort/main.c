#include <stdio.h>
#include <stdlib.h>

void exchange_member(int *arr, int x, int y) {
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
    return;
}


int partition(int *arr, int lo, int hi) {
    int pivot = arr[hi];
    int i = lo - 1;
    for (int j = lo; j < hi - 1; j++) {
        if (arr[j] <= pivot) {
            i++;
            exchange_member(arr, i, j);
        }

    }
    exchange_member(arr, i + 1, hi);
    return i + 1;
}

void quick_sort(int *arr, int lo, int hi) {
    if (lo < hi) {
        int mid = partition(arr, lo, hi);
        quick_sort(arr, lo, mid - 1);
        quick_sort(arr, mid + 1, hi);
    }

    return;
}

int main() {
    int size_of_problem;
    scanf("%d", &size_of_problem);
    int *numbers_to_sort = (int *) malloc(size_of_problem * sizeof(int));

    for (int i = 0; i < size_of_problem; i++) {
        scanf("%d", &numbers_to_sort[i]);
    }

    quick_sort(numbers_to_sort, 0, size_of_problem-1);

    for (int i = 0; i < size_of_problem; i++) {
        printf("%d ", numbers_to_sort[i]);
    }

    free(numbers_to_sort);

    return 0;
}