#language: es
#encoding: iso-8859-1
#Author: jbuiles@qvision.com.co

Caracter�stica: Consulta en google
  Yo como usuario
  Quiero realizar una consulta en google
  Para evaluar el resultado

  Esquema del escenario: Realizar b�squeda
    Dado que el usuario se encuentre en google
    Cuando busque realice la b�squeda del t�rmino '<termino>'
    Entonces ver� el t�rmino en la b�squeda de google '<termino>'
    @local @laboratorio
    Ejemplos: Datos de entrada
      | termino |
      | F�tbol  |