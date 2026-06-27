from collections import Counter
from typing import List


class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        count_p = Counter(p)
        count_s = Counter()
        res = []

        for i, ch in enumerate(s):
            count_s[ch] += 1

            if i < len(p) - 1:
                continue

            left = i - len(p) + 1
            if count_p == count_s:
                res.append(left)

            count_s[s[left]] -= 1

        return res


if __name__ == '__main__':
    solution = Solution()
    print(solution.findAnagrams("cbaebabacd", "abc"))
