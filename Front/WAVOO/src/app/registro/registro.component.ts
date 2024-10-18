import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Coche } from '../_modelo/Coche';
import { FormularioUsuario } from '../_modelo/FormularioUsuario';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-registro',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './registro.component.html',
  styleUrl: './registro.component.css'
})
export class RegistroComponent {
  usuario: FormularioUsuario = {
    dni: '',
    contrasena: '',
    direccion: '',
    email: '',
    fechaNacimiento: '',
    fotoUsuario: null,
    genero: '',
    nombreCompleto: '',
    permisoConducir: false,
    rPreguntaSeguridad: '',
    telefono: '',
    usuario: '',
    fotoCarnet: null,
    coches: [] // Inicializa como un array vacío
  };

  currentCocheIndex: number = 0; // Inicializa el índice

  // Método para agregar un coche al array
  agregarCoche() {
    this.usuario.coches.push({
      matricula: '',
      marca: '',
      modelo: '',
      carroceria: '',
      anio: null,
      numeroPlazas: null,
      fotoCoche: null
    });
  }

  // Método para eliminar un coche del array
  eliminarCoche(index: number) {
    // Verificar si el usuario tiene permiso de conducir
    if (this.usuario.permisoConducir) {
        // Si tiene permiso de conducir, se permite la eliminación si hay más de un coche
        if (this.usuario.coches.length > 1) {
            this.usuario.coches.splice(index, 1);
        } else {
            alert("Debes tener al menos un coche registrado si tienes permiso de conducir.");
        }
    } else {
        // Si no tiene permiso de conducir, se permite la eliminación de coches sin restricciones
        this.usuario.coches.splice(index, 1);
    }
}

  // Método para manejar el cambio de archivo para la foto del usuario
  onFileChange(event: any) {
    const file: File = event.target.files[0]; // Obtiene el primer archivo del input
    if (file) {
      this.usuario.fotoUsuario = file; // Asigna el archivo a la propiedad fotoUsuario
    } else {
      this.usuario.fotoUsuario = null; // Si no hay archivo, establece null
    }
  }

  // Método para manejar el cambio de archivo para la foto del carnet
  onFileChangeCarnet(event: Event) {
    const input = event.target as HTMLInputElement; // Asegúrate de que event.target sea un HTMLInputElement
    const file = input.files?.[0]; // Obtiene el primer archivo del input

    if (file) {
      this.usuario.fotoCarnet = file; // Almacena el archivo directamente
    } else {
      this.usuario.fotoCarnet = null; // Si no hay archivo, establece null
    }
  }

  // Método para manejar el cambio de archivo para la foto del coche
  onFileChangeCoche(event: any, index: number) {
    const file: File = event.target.files[0]; // Asegúrate de que es un objeto File
    if (file) {
      this.usuario.coches[index].fotoCoche = file; // Asigna el objeto File
    } else {
      this.usuario.coches[index].fotoCoche = null; // Si no hay archivo, establece null
    }
  }

  // Método para guardar el usuario
  guardarUsuario() {
    // Aquí envías los datos al servicio para registrarlo
    console.log(this.usuario); // Solo para verificar que se están recolectando correctamente
  }
}
