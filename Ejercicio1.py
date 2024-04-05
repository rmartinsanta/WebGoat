import re

text = "Este es un texto con algunos años como 2022 y 2024, pero también tiene 2023, 1000, 0020, 30, 2020, 0000"

regex = r"\b\d{4}\b"

years = re.findall(regex, text)

for year in years:
    print(year)
