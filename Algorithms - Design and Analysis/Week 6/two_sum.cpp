#include <iostream>
#include <unordered_map>
using namespace std;
int main() {
  unordered_map<long long, bool> numbers_to_use;
  long long number;
  int target_count = 0;
  while (scanf("%lld", &number) != EOF) {
    numbers_to_use[number] = true;
  }
  for (int target = -10000; target <= 10000; target++) {
    for (auto& kv : numbers_to_use) {
      long long number_to_use = kv.first;
      if (target - number_to_use != number_to_use &&
          numbers_to_use.find(target - number_to_use) != numbers_to_use.end()) {
        target_count++;
        cout << "Find target number " << target << endl;
        break;
      }
    }
  }
  cout << "Total " << target_count << " valid targer numbers";
  // Answer 427
}
