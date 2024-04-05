import re

text = input()

regex = r'\b(?:E-?\s?|\b)\d{4}[-\s]?[A-Z]{3}\b'

plates = re.findall(regex, text)

for plate in plates:
    print(plate)
