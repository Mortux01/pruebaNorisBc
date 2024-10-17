# pruebaTecNorisBci

Para realizar la prueba de este proyecto, primero se debe levantar y luego ir a la url  http://localhost:8080/swagger-ui/index.html
para poder probar desde el swagger.


Para la Base de datos se utilizo el banco de datos en memoria H2. Para realizar la creacion de las tablas que se utilizaron se debe ir
al archivo createTable.sql que se encuentra en Resources y la configuración de esta Base de datos se
encuentra en el archivo application.properties donde deberan configurar los datos para su nueva base de datos.

Este es el json con el que se puede probar el endpoint /users/insert:

{
  "name": "Eduardo Nunez",
  "email": "eduardo.nunez.p@gmail.com",
  "password": "prunorisb3",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "countrycode": "57"
    }
  ]
}

la respuesta con el json anterior deberia dar la siguiente respuesta:

{
  "id": "76d5635a-a7eb-4314-973a-761bad3a9d35",
  "name": "Eduardo Nunez",
  "email": "eduardo.nunez.p@gmail.com",
  "password": "prunorisb3",
  "phones": [
    {
      "id": 654,
      "number": "1234567",
      "citycode": "1",
      "countrycode": "57"
    }
  ],
  "created": "2024-10-17T00:00:47.2156138",
  "modified": "2024-10-17T00:00:47.2156138",
  "last_login": "2024-10-17T00:00:47.2156138",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlZHVhcmRvLm51bmV6LnBAZ21haWwuY29tIiwiaWF0IjoxNzI5MTM0MDQ3fQ.v0J3T1l4M34Aw_a7J-9_aBtm-MIq_XKu1rgNIbo7Cak",
  "isactive": true
}

En aso que se quieran probar los mensajes de error se puede volve a lanzar el json inicial o modificar la contraseña por "prunoris".

Para el endpoint /users/update se utiliza el siguiente json con el que se puede probar:

{
  "name": "Eduardo Nunez",
  "email": "eduardo.nunez@gmail.com",
  "password": "prunorisb3",
  "isactive": false

}

la respuesta con el json anterior deberia dar la siguiente respuesta:

{
  "id": "76d5635a-a7eb-4314-973a-761bad3a9d35",
  "name": "Eduardo Nunez",
  "email": "eduardo.nunez.p@gmail.com",
  "password": "prunorisb3",
  "phones": [
    {
      "id": 654,
      "number": "1234567",
      "citycode": "1",
      "countrycode": "57"
    }
  ],
  "created": "2024-10-17T00:00:47.215614",
  "modified": "2024-10-17T00:01:52.1530577",
  "last_login": "2024-10-17T00:00:47.215614",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJlZHVhcmRvLm51bmV6LnBAZ21haWwuY29tIiwiaWF0IjoxNzI5MTM0MDQ3fQ.v0J3T1l4M34Aw_a7J-9_aBtm-MIq_XKu1rgNIbo7Cak",
  "isactive": false
}

Como se puede apreciar en el Json se modifica correctamente los campos "modified" y "isactive".
