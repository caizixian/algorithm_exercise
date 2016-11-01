#include <stdio.h>
#include <string.h>
#include <ctype.h>
#include <stdbool.h>
#include <stdlib.h>

char buffer[1000];

int pow(int a, size_t b) //double pow(double, double) -> pow() implemented by math.h
{
    int res = 1;
    for (int i = 1; i <= b; i++)
        res *= a;
    return res;
}

void converse_10_to_26(int a) {
    char temp[100001];
    int i = 100000;
    if (a <= 26) {
        printf("%c", (char) ('A' + a - 1));
        return;
    }
    while (a > 26) {
        if (a % 26 == 0) {
            temp[i] = 'Z';
            i--;
            a /= 26;
            a--;
        }
        else {
            temp[i] = (char) ('A' + a % 26 - 1);
            i--;
            a /= 26;
        }
    }
    if (a == 26)
        temp[i] = 'Z';
    else
        temp[i] = (char) ('A' + a - 1);
    for (; i <= 100000; i++)
        printf("%c", temp[i]);
    return;
}

void converse_26_to_10(char *temp, size_t length) {
    int sum = 0;
    for (int i = 0; i < length; i++) {
        sum += (temp[i] - 'A' + 1) * pow(26, length - i - 1);
    }
    printf("%d", sum);
    return;
}

void first_type_handler(size_t length) {
    /*
     * Looks like BC23
     * BC:column 23:row
     * i=2
     */
    int index = 0;
    char temp[1000];
    for (int i = 0; i < length; i++) {
        if (isdigit(buffer[i])) {
            index = i;
            break;
        }
    }
    strncpy(temp, &buffer[index], length - index);
    temp[length - index] = '\0';
    printf("R%s", temp);
    strncpy(temp, buffer, index);
    temp[index] = '\0';
    printf("C");
    converse_26_to_10(temp, strlen(temp));
    return;
}


void second_type_handler(size_t length, long long index) {
    /*
     * Looks like R23C55
     * and index is the position of 'C'
     * length=6 index=3 length-index-1=2
     * */
    char temp[1000];
    strncpy(temp, &buffer[index + 1], length - index - 1);
    temp[length - index - 1] = '\0';
    converse_10_to_26(atoi(temp));//print the BC part
    for (int i = 1; i < index; i++)
        printf("%c", buffer[i]);//print the 23 part
    return;
}

void identifier(size_t length) {
    bool is_second_type = false;
    long long index = 0;
    for (long long i = 0; i < length; i++) {
        if (0 != i) {
            if ('C' == buffer[i] && isdigit(buffer[i - 1])) {
                is_second_type = true;
                index = i;
                break;
            }
        }
    }
    if (is_second_type)
        second_type_handler(length, index);
    else
        first_type_handler(length);
    return;
}

int main(void) {
    int n;
    scanf("%d", &n);
    for (int i = 1; i <= n; i++) {
        scanf("%s", buffer);
        identifier(strlen(buffer));
        printf("\n");
    }
    return 0;
}