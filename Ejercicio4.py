import re

# Función comprobar correo electrónico -> alumno o -> profesor
def determinar_tipo_correo(correo):
    if correo.endswith("@alumnos.urjc.es"):
        return "alumno"
    elif correo.endswith("@urjc.es"):
        return "profesor"
    else:
        return None

# Función correo alumno
def extraer_info_alumno(correo):
    match = re.match(r"([a-z]+)\.([a-z]+)\.(\d{4})@alumnos\.urjc\.es", correo)
    if match:
        apellido = match.group(2)
        nombre_usuario = match.group(1)
        fecha_matriculacion = match.group(3)
        return f"alumno {apellido} matriculado en {fecha_matriculacion}"
    else:
        return None

# Función correo profesor
def extraer_info_profesor(correo):
    match = re.match(r"([a-z]+)\.([a-z]+)@urjc\.es", correo)
    if match:
        nombre_profesor = match.group(1)
        apellido_profesor = match.group(2)
        return f"profesor {nombre_profesor} apellido {apellido_profesor}"
    else:
        return None

texto = input()
regex_correo = r"\b[a-z]+\.[a-z]+\.\d{4}@alumnos\.urjc\.es\b|\b[a-z]+\.[a-z]+@urjc\.es\b"

correos_encontrados = re.findall(regex_correo, texto)

for correo in correos_encontrados:
    tipo = determinar_tipo_correo(correo)
    if tipo == "alumno":
        info = extraer_info_alumno(correo)
    elif tipo == "profesor":
        info = extraer_info_profesor(correo)
    if info:
        print(info)
