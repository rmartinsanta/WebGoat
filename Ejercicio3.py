import re

def transform_date(match):
    date = match.group(0)
    date_parts = date.split("-")
    return f"{date_parts[2]}.{date_parts[1]}.{date_parts[0]}"

text = input()

regex_date = r"\b\d{4}-\d{2}-\d{2}\b"

new_text = re.sub(regex_date, transform_date, text)

print(new_text)



