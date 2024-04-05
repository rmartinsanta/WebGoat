import re

# Texto de ejemplo
text = "Este es un texto con algunos años como 2022 y 2024, pero también tiene 2023, 1000, 0020, 30, 2020, 0000"

# Expresión regular para encontrar años de 4 dígitos
regex = r"\b\d{4}\b"

# Buscar todos los años en el texto
years = re.findall(regex, text)

# Imprimir los años encontrados en orden de aparición
for year in years:
    print(year)