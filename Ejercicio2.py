import re

# Texto de ejemplo
text = "Las matrículas E-2022ABC, E1337ZZZ y 0000-XYZ están presentes en el texto."

# Expresión regular para encontrar matrículas
regex = r'\b(?:E-?\s?|\b)\d{4}[-\s]?[A-Z]{3}\b'

# Buscar todas las matrículas en el texto
plates = re.findall(regex, text)

# Imprimir las matrículas encontradas en orden de aparición
for plate in plates:
    print(plate)
