## 1.2.3 Preguntas

### 1. ¿Cuantas vulnerabilidades, bugs y code smells ha detectado SonarCloud en el proyecto entero?

Estos son los datos que ha arrojado SonarCloud:

- Vulnerabilidades: 30
- Bugs: 32
- Code smells: 565

### 2. Haz click sobre el proyecto para abrir la vista de detalle. Revisa las vulnerabilidades detectadas y la lista de Security Hotspots. ¿Qué diferencia crees que existe entre las vulnerabilidades y los Security Hotspots?

La diferencia es que las **vulnerabilidades** hacen referencia a código que se ha detectado que puede ser explotado, mientras que los **Security Hotspots** son fragmentos de código que deben ser revisados, ya que aunque no se haya podido determinar a priori si son una vulnerabilidad o no en el escaneo, podrían serlo por lo que deben analizarse de forma manual para determinarlo.

### 3. Haz cualquier commit para forzar un reanalisis (por ejemplo editando el README.md). Espera a que finalice y vuelve a Sonar. ¿Cual es el estado del proyecto (Passed/Failed)?. ¿A qué crees que se debe? ¿Crees que el numero de vulnerabilidades afecta a dicho veredicto?



