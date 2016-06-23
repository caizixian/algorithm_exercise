#include <stdio.h>
#include <stdlib.h>

int global_count = 0;

void exchange_member(int *arr, int x, int y) {
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
    return;
}

void select_pivot_first(int *arr, int lo, int hi){
    return;
}

void select_pivot_last(int *arr, int lo, int hi){
    exchange_member(arr, lo, hi);
    return;
}

void select_pivot_medium(int *arr, int lo, int hi){
    int mid = (hi-lo)/2+lo;
    if (((arr[lo]<arr[mid])&&(arr[mid]<arr[hi]))||((arr[hi]<arr[mid])&&(arr[mid]<arr[lo]))) {
        exchange_member(arr, lo, mid);
    }
    else if (((arr[lo]<arr[hi])&&(arr[hi]<arr[mid]))||((arr[mid]<arr[hi])&&(arr[hi]<arr[lo]))){
        exchange_member(arr, lo, hi);
    }
    return;
}

int partition(int *arr, int lo, int hi) {
    select_pivot_medium(arr, lo, hi);
    int pivot = arr[lo];
    int i = lo + 1;
    for (int j = lo + 1; j <= hi; j++) {
        if (arr[j] < pivot) {
            exchange_member(arr, j, i);
            i++;
        }
    }
    exchange_member(arr, lo, i - 1);
    return i;
}

void quick_sort(int *arr, int lo, int hi) {
    if (lo < hi) {
        int mid = partition(arr, lo, hi);
        quick_sort(arr, lo, mid - 2);
        global_count += mid - lo;
        quick_sort(arr, mid, hi);
        global_count += hi - mid;
    }

    return;
}

int main() {
    int size_of_problem = 10000;
    int *numbers_to_sort = (int *) malloc(size_of_problem * sizeof(int));

    for (int i = 0; i < size_of_problem; i++) {
        scanf("%d", &numbers_to_sort[i]);
    }

    quick_sort(numbers_to_sort, 0, size_of_problem - 1);

    for (int i = 0; i < size_of_problem; i++) {
        printf("%d ", numbers_to_sort[i]);
    }
    printf("\n%d", global_count);
    free(numbers_to_sort);

    return 0;
}