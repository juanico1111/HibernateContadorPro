// Definición de las estrategias
const estrategiaContador = {
    iniciarSesion: function(usuario, contraseña) {
      // Lógica de inicio de sesión para el contador
      console.log(`Iniciando sesión como contador para el usuario: ${usuario}`);
      // Aquí iría la validación y autenticación real
    }
  };
  
  const estrategiaCliente = {
    iniciarSesion: function(usuario, contraseña) {
      // Lógica de inicio de sesión para el cliente
      console.log(`Iniciando sesión como cliente para el usuario: ${usuario}`);
      // Aquí iría la validación y autenticación real
    }
  };
  
  // Contexto que utiliza la estrategia
  const inicioSesion = {
    ejecutar: function(usuario, contraseña, tipoUsuario) {
      if (tipoUsuario === 'contador') {
        estrategiaContador.iniciarSesion(usuario, contraseña);
      } else if (tipoUsuario === 'cliente') {
        estrategiaCliente.iniciarSesion(usuario, contraseña);
      } else {
        console.log('Tipo de usuario no válido.');
      }
    }
  };
  
  // Uso
  inicioSesion.ejecutar('usuario1', 'contraseña123', 'contador');
  inicioSesion.ejecutar('usuario2', 'clave456', 'cliente');