import { Coche } from "./Coche";

export interface FormularioUsuario {
    dni: string;
    contrasena: string;
    direccion: string;
    email: string;
    fechaNacimiento: string; // Puede ser string si lo manejas como una fecha en formato ISO
    fotoUsuario: File | null; // Para manejar byte[], se puede usar Uint8Array
    genero: string;
    nombreCompleto: string;
    permisoConducir: boolean; // Cambiado a boolean (no Boolean)
    rPreguntaSeguridad: string; // Asegúrate de que la propiedad se llama así
    telefono: string;
    usuario: string;
    fotoCarnet: File | null; // Lo mismo para fotoCarnet
    coches: Coche[]; // Asumiendo que tienes un modelo Coche
}