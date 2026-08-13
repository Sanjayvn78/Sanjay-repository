# Last updated: 8/13/2026, 9:15:06 AM
class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        if len(s) != len(goal):
            return False
        ans=s+s
        if goal in ans:
            return True
        else:
            return False
        