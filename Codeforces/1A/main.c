#include <stdio.h>
#include <inttypes.h>

int main(void) {
    unsigned long long n, m, a, n_need, m_need;
    scanf("%"PRIu64"%"PRIu64"%"PRIu64"", &n, &m, &a);
    if (0 == n % a) {
        n_need = n / a;
    } else {
        n_need = n / a + 1;
    }
    if (0 == m % a) {
        m_need = m / a;
    } else {
        m_need = m / a + 1;
    }
    printf("%"PRIu64"", n_need * m_need);
    return 0;
}