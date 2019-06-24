import LeetCode_726_3_v1
import LeetCode_726_3_v2

# Solution = LeetCode_726_3_v1.Solution
Solution = LeetCode_726_3_v2.Solution

s1 = Solution()
print(s1.countOfAtoms('H2O') == 'H2O')
print(s1.countOfAtoms('Mg(OH)2') == 'H2MgO2')
print(s1.countOfAtoms('K4(ON(SO3)2)2') == 'K4N2O14S4')
