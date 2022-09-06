Feature: Loogin

Scenario: login con usuario existente
  Given el usuario selecciona chrome
  When cuando el usario ingresa con el usuario prueba.amco1@gmail.com
  And hace clic en el boton de ingresar
  And ingresa la contraseña LJAnet87
  And se muestran los perfiles y seleecciona el admmin
  Then se muestra el home user
  
 