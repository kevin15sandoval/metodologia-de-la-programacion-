#!/bin/bash
echo "Listado de archivos modificados"
git st
read -p "ENTER para continuar" ENTER
clear
# ------------------------------------------------------------
echo "Bajando los cambios en el repositorio"
git baja
echo ""
echo "Archivos nuevos descargados"
read -p "ENTER para continuar" ENTER
clear
# ------------------------------------------------------------
echo "Subiendo los cambios a github"
echo ""
echo "Seleccionando todos los ficheros modificados"
git todo
# ------------------------------------------------------------
echo "Añadiendo la nota del push"
git nota $1
# ------------------------------------------------------------
echo "Subiendo a main"
git sube
# ------------------------------------------------------------
git st
