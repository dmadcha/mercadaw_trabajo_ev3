#!/bin/bash

RUTA_ARCHIVO="archivo/export.txt"
RUTA_COLOCAR="backups"
FECHA=$(date +"%Y_%m_%d_%H")
BACKUP="copiaoficial_$FECHA.txt" 

cp $RUTA_ARCHIVO  $RUTA_COLOCAR/$BACKUP

if [ $? -eq 0 ]; then
        echo "Copia de seguridad creada ${BACKUP}"
else
        echo "Error al realizar copia de seguridad"
        exit 1
fi


