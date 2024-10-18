export interface Coche {
    matricula: string;
    marca: string;
    modelo: string;
    carroceria: string;
    anio: number | null;  // Cambié a number porque el año no debería ser null en su tipo
    numeroPlazas: number | null; // Cambié a number porque el número de plazas no debería ser null en su tipo
    fotoCoche: File | null; // Cambiado a File para aceptar un archivo
  }