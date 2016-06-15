#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_SIZE 1000000

void merge(int result[], int result_size, int a[], int size_a, int b[],
           int size_b) {
    int i = 0;
    int j = 0;
    for (int k = 0; k < result_size; k++) {

        if (i == size_a && j < size_b) {
            // Reached end of a
            result[k] = b[j];
            j++;
        }
        else if (i < size_a && j == size_b) {
            // Reached end of b
            result[k] = a[i];
            i++;
        }
        else {
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            }
            else {
                result[k] = b[j];
                j++;
            }
        }
    }
    return;
}

void print_array(int a[], int size_a){
    for (int i=0;i<size_a;i++){
        printf("%d ", a[i]);
    }
}

void merge_sort(int a[], int size_a) {

    // Base case of a recursive process
    if (size_a < 2) {
        return;
    }
    int mid_pt = size_a / 2;

    int left_size = mid_pt;
    int right_size = size_a - left_size;

    int *left = (int *) malloc(left_size * sizeof(int));
    int *right = (int *) malloc(right_size * sizeof(int));

    memcpy(left, a, left_size* sizeof(int));
    memcpy(right, a+left_size, right_size* sizeof(int));

    merge_sort(left, left_size);
    merge_sort(right, right_size);

    merge(a, size_a, left, left_size, right, right_size);

    free(left);
    free(right);
}

int main() {
    int numbers_to_sort[MAX_SIZE] = {0};
    int size_of_problem;
    scanf("%d", &size_of_problem);

    // Make sure our array is big enough
    if (size_of_problem > MAX_SIZE) {
        return 0;
    }

    for (int i = 0; i < size_of_problem; i++) {
        scanf("%d", &numbers_to_sort[i]);
    }

    merge_sort(numbers_to_sort, size_of_problem);

    print_array(numbers_to_sort, size_of_problem);
    return 0;
}