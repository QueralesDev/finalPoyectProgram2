# finalPoyectProgram2
##Repositorio del proyecto final de programación 2
Este repositorio fue creado con la finalidad de registra tod sloa avances acerca del proyecto final de la materia programacion 2, a continuacion se describen una serie de pasos a cumplir antes de comenzar a trabar en el proyecto con la finalidad de mantener un buen flujo de trabajo.

###Para mantener un flujo de trabajo organizado y evitar la creación de ramas innecesarias, utilizamos la siguiente convención de nombres para las ramas:

> Development/tu-nombre

¿Cómo Funciona?
- Crea tu Rama: Al iniciar tu trabajo, crea una rama con el formato Development/tu-nombre. Esta será tu espacio de trabajo personal dentro del proyecto.
- Trabaja en tu Rama: Realiza todos los cambios y mejoras en esta rama. Es una buena práctica hacer commits frecuentes y significativos.
- Pull Requests: Una vez que hayas completado una característica o corrección, abre un Pull Request (PR) desde tu rama Development/tu-nombre hacia la rama principal. Asegúrate de que el código esté completamente revisado y probado antes de realizar el merge.

Crear una rama en GitHub

1) Dentro del proyecto en GitHub, hacé click en el nombre de la rama actual.
2) Seleccioná "Ver todas las ramas"
3) Hacé click en el botón "Nueva rama".

Cloná el repositorio

- En tu consola, navegá a la carpeta donde querés copiar el proyecto y usá el siguiente comando:

> git clone [link del repositorio]

Por ejemplo para este repositorio:

> git clone

Crea una rama local

- Estando sobre la carpeta donde tenés tu repositorio, crea una rama local con el mismo nombre que tu rama remota en GitHub (Development/tu_nombre)

> git checkout -b Development/tu_nombre

Este comando crea una nueva rama y te cambia a ella automáticamente

- En esta rama podés hacer tus cambios y hacer commits en tu git local.

Subí tus cambios a Github

- Cuando estés listo para enviar todos tus cambios a GitHub, tenés que subirlos a la rama remota con el siguiente comando:

> git push origin Development/tu_nombre

Los cambios se subirán a tu rama personal en GitHub. Si el código está listo para hacer el merge a la rama de main, abrí una Pull Request.
