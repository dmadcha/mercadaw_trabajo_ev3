#!/bin/bash

FECHA=$(date +"%Y_%m_%d_%H")
BACKUP="copiaoficial_$FECHA.txt" 

cp "$1" "$2/$BACKUP"


if [ $? -eq 0 ]; then
    echo "Copia de seguridad creada: ${RUTA_COLOCAR}/${BACKUP}"
else
    echo "Error al realizar copia de seguridad"
    exit 1
fi
