import re

text = input()

regex = r"\b\d{4}\b"

years = re.findall(regex, text)

for year in years:
    print(year)
