#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_SIZE 1000000

void merge(long long *count, long long result[], long long result_size, long long a[], long long size_a,
           long long b[],
           long long size_b) {
    long long i = 0;
    long long j = 0;
    for (long long k = 0; k < result_size; k++) {

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
            if (a[i] <= b[j]) {
                result[k] = a[i];
                i++;
            }
            else {
                result[k] = b[j];
                *count +=
                        size_a - i; // i: numbers of elements already in result
                j++;
            }
        }
    }
    return;
}

void count_and_merge_sort(long long *result, long long a[], long long size_a) {

    // Base case of a recursive process
    if (size_a < 2) {
        return;
    }
    long long mid_pt = size_a / 2;

    long long left_size = mid_pt;
    long long right_size = size_a - left_size;

    long long *left = (long long *) malloc(left_size * sizeof(long long));
    long long *right = (long long *) malloc(right_size * sizeof(long long));

    memcpy(left, a, left_size * sizeof(long long));
    memcpy(right, a + left_size, right_size * sizeof(long long));

    count_and_merge_sort(result, left, left_size);
    count_and_merge_sort(result, right, right_size);

    merge(result, a, size_a, left, left_size, right, right_size);

    free(left);
    free(right);
}


int main() {
    long long numbers_to_count[MAX_SIZE] = {0};
    long long size_of_problem;
    long long result;
    long long case_count;
    scanf("%lld", &case_count);
    
    for (int count=0;count<case_count;count++)
   {
        scanf("%lld", &size_of_problem);
        // Make sure our array is big enough
        if (size_of_problem > MAX_SIZE) {
            return 0;
        }

        for (long long i = 0; i < size_of_problem; i++) {
            scanf("%lld", &numbers_to_count[i]);
        }

        result = 0;

        count_and_merge_sort(&result, numbers_to_count, size_of_problem);

        printf("%lld\n", result);
    }

    return 0;
}