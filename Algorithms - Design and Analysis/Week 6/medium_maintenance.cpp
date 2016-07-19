#include <cmath>
#include <iostream>
#include <queue>
using namespace std;

int calc_medium(priority_queue<int, vector<int>, greater<int> > min_heap,
                priority_queue<int> max_heap) {
  if (min_heap.size() == max_heap.size()) {
    return max_heap.top();  // if k is even, then mk is the (k/2)th smallest
                            // number among x1,…,xk
  } else if (min_heap.size() > max_heap.size()) {
    return min_heap.top();
  } else {
    return max_heap.top();
  }
}

int main() {
  priority_queue<int, vector<int>, greater<int> > min_heap;
  priority_queue<int> max_heap;
  int medium_sum = 0;
  int number, number_1st, number_2nd;
  // Init heap
  scanf("%d", &number_1st);
  medium_sum += number_1st;
  scanf("%d", &number_2nd);
  if (number_1st < number_2nd) {
    max_heap.push(number_1st);
    min_heap.push(number_2nd);
    medium_sum += number_1st;
  } else {
    max_heap.push(number_2nd);
    min_heap.push(number_1st);
    medium_sum += number_2nd;
  }
  while (scanf("%d", &number) != EOF) {
    if (number < max_heap.top()) {  // Add new element
      max_heap.push(number);
    } else {
      min_heap.push(number);
    }

    if (fabs(max_heap.size() - min_heap.size()) > 1.0) {  // Rebalance
      if (max_heap.size() > min_heap.size()) {
        min_heap.push(max_heap.top());
        max_heap.pop();
      } else {
        max_heap.push(min_heap.top());
        min_heap.pop();
      }
    }
    medium_sum += calc_medium(min_heap, max_heap);
  }
  printf("%d", medium_sum % 10000);
  return 0;
}