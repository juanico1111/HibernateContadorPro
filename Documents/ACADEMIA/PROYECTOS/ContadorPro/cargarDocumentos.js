// Clase Observador
class Observador {
    actualizar(evento, sujeto, documento) {
      // Lógica para manejar los eventos
    }
  }
  
  // Clase Sujeto (el contador o cliente)
  class Sujeto {
    constructor() {
      this.observadores = [];
    }
  
    agregarObservador(observador) {
      this.observadores.push(observador);
    }
  
    eliminarObservador(observador) {
      const indice = this.observadores.indexOf(observador);
      if (indice !== -1) {
        this.observadores.splice(indice, 1);
      }
    }
  
    notificar(evento, documento) {
      for (const observador of this.observadores) {
        observador.actualizar(evento, this, documento);
      }
    }
  
    // Métodos para cargar y descargar documentos
    cargarDocumento(documento) {
      // Lógica para cargar un documento
      console.log(`Cargando documento: ${documento}`);
      this.notificar('carga', documento);
    }
  
    descargarDocumento(documento) {
      // Lógica para descargar un documento
      console.log(`Descargando documento: ${documento}`);
      this.notificar('descarga', documento);
    }
  }
  
  // Crear observadores
  const contadorObservador = new Observador();
  const clienteObservador = new Observador();
  
  // Crear sujetos (el contador y el cliente)
  const contador = new Sujeto();
  const cliente = new Sujeto();
  
  // Asignar observadores a los sujetos
  contador.agregarObservador(contadorObservador);
  cliente.agregarObservador(clienteObservador);
  
  // Simular acciones del cliente y el contador
  cliente.cargarDocumento('Recibo de pago 1');
  cliente.descargarDocumento('Informe contable');
  contador.cargarDocumento('Factura de gastos');
  contador.descargarDocumento('Informe de impuestos');
  contador.cargarDocumento('Informe contable');
  
  // Resultado: Los observadores reciben notificaciones cuando se cargan o descargan documentos.
  