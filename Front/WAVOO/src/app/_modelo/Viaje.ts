export interface Viaje {
    idViaje: number;       // ID del viaje
    origen: string;        // Origen del viaje
    destino: string;       // Destino del viaje
    precio: number;        // Precio del viaje
    fecha: Date;         // Fecha del viaje en formato ISO (ejemplo: '2024-10-18')
    hora: string;          // Hora del viaje en formato ISO (ejemplo: '14:30:00')
    matricula: string;     // Matrícula del coche
}