import re

def find_addresses(text):
    pattern = r'\b(?:Calle|C\/)\s([A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)\s*(?:Nº|nº|N|n)?\s*(\d+)\s*,\s*(\d{5})\b'
    matches = re.finditer(pattern, text, re.IGNORECASE)

    formatted_addresses = []
    for match in matches:
        street = match.group(1).title().replace(' ', '-')
        number = match.group(2)
        postal_code = match.group(3)
        formatted_address = f"{postal_code}-{street}-{number}"
        formatted_addresses.append(formatted_address)

    return formatted_addresses

text = input()
addresses = find_addresses(text)

for address in addresses:
    print(address)
