import re

text = "Las matrículas E-2022ABC, E1337ZZZ y 0000-XYZ están presentes en el texto."

regex = r'\b(?:E-?\s?|\b)\d{4}[-\s]?[A-Z]{3}\b'

plates = re.findall(regex, text)

for plate in plates:
    print(plate)
