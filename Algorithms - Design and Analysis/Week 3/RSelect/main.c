#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

int partition(int *arr, int lo, int hi);

void exchange_member(int *arr, int a, int b);

void choose_pivot(int *arr, int start, int end);

int rselect(int *arr, int lo, int hi, int nth);

int partition(int *arr, int lo, int hi) {
    choose_pivot(arr, lo, hi);
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

void exchange_member(int *arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
    return;
}


void choose_pivot(int *arr, int start, int end) {
    int random_pos = start + (int) round(
            (double) (end - start) * (double) rand() / (double) RAND_MAX);
    exchange_member(arr, start, random_pos);
    return;
}

int rselect(int *arr, int lo, int hi, int nth) {
    int pivot_pos = partition(arr, lo, hi);
    if (nth == pivot_pos) {
        return arr[pivot_pos];
    }
    else if (nth < pivot_pos) {
        return rselect(arr, lo, pivot_pos - 2, nth);
    }
    else {
        return rselect(arr, pivot_pos , hi, nth);
    }


}

int main() {
    srand(time(NULL));

    int size_of_problem, nth;
    scanf("%d", &size_of_problem);
    scanf("%d", &nth);

    int *numbers_to_select = (int *) malloc(size_of_problem * sizeof(int));

    for (int i = 0; i < size_of_problem; i++) {
        scanf("%d", &numbers_to_select[i]);
    }

    printf("%d", rselect(numbers_to_select, 0, size_of_problem - 1, nth));

    free(numbers_to_select);

    return 0;
}