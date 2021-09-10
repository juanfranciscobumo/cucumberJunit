#language: es
#encoding: iso-8859-1
#Author: jbuiles@qvision.com.co

Característica: Consulta en google
  Yo como usuario
  Quiero realizar una consulta en google
  Para evaluar el resultado

  Esquema del escenario: Realizar búsqueda
    Dado que el usuario se encuentre en google
    Cuando busque realice la búsqueda del término '<termino>'
    Entonces verá el término en la búsqueda de google '<termino>'
    @local @laboratorio
    Ejemplos: Datos de entrada
      | termino |
      | Fútbol  |