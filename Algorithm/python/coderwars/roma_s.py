from collections import OrderedDict


class RomanNumerals:
    mapper = OrderedDict([('M', 1000), ('CM', 900), ('D', 500), ('CD', 400), ('C', 100), ('XC', 90), ('L', 50), ('XL', 40),
                          ('X', 10), ('IX', 9), ('V', 5), ('IV', 4), ('I', 1)])

    @classmethod
    def to_roman(cls, val):
        ans = ''
        for k, v in cls.mapper.items():
            while val >= v:
                val -= v
                ans += k
        return ans

    @classmethod
    def from_roman(cls, roman_num):
        ans = 0

        for i in range(len(roman_num)):
            if i < len(roman_num) - 1 and cls.mapper[roman_num[i]] < cls.mapper[roman_num[i + 1]]:
                ans -= cls.mapper[roman_num[i]]
            else:
                ans += cls.mapper[roman_num[i]]
        return ans


ans = RomanNumerals.to_roman(1)
print(ans)

ans = RomanNumerals.from_roman("IV")
print(ans)
