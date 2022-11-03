Feature: Login

@Prueba
Scenario: login con usuario existente
  Given el usuario selecciona firefox
  Given ingresar a la URL de https://demoweb.clarovideo.net/mexico/landing y hace clic
  When cuando el usario ingresa con el usuario prueba.amco1@gmail.com
  And hace clic en el boton de ingresar
  And ingresa la contraseña LJAnet87
  And se muestran los perfiles y seleecciona el admin
  And se muestra el home user
  Then cierro la sesion

  @pruebaDos
  Scenario: login de prueba
    Given el usuario selecciona safari
    Then se cierra el explorador

  @pruebaTres
  Scenario: login de prueba
    Given el usuario selecciona firefox
    Then se cierra el explorador