Feature: Login

Scenario: login con usuario existente
  Given el usuario selecciona chrome
  Given ingresar a la URL de https://demoweb.clarovideo.net/mexico/landing y da clic en Inicio
  When cuando el usario ingresa con el usuario prueba.amco1@gmail.com
  And hace clic en el boton de ingresar
  And ingresa la contraseña LJAnet87
  And se muestran los perfiles y seleecciona el admin
  Then se muestra el home user
  
 