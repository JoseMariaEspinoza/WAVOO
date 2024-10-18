import { Component } from '@angular/core';
import { Router, RouterModule } from '@angular/router';
import { Usuario } from '../_modelo/Usuario';
import { UsuarioService } from '../_servicio/usuario.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  dni = '';
  contrasena = '';
  usuario: Usuario = {
    dni: '',
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

  constructor(private usuarioService: UsuarioService, private router: Router) { }

  acceder() {
    this.usuarioService.identificarUsuario(this.dni, this.contrasena)
      .subscribe(
        response => {
          // Asigna todos los campos de la respuesta al objeto `usuario`
          this.usuario = {
            dni: response.dni,
            direccion: response.direccion,
            email: response.email,
            fechaNacimiento: response.fechaNacimiento,
            fotoUsuario: response.fotoUsuario ? new File([response.fotoUsuario], "fotoUsuario") : null,
            genero: response.genero,
            nombreCompleto: response.nombreCompleto,
            permisoConducir: response.permisoConducir,
            rPreguntaSeguridad: response.rPreguntaSeguridad,
            telefono: response.telefono,
            usuario: response.usuario,
            fotoCarnet: response.fotoCarnet ? new File([response.fotoCarnet], "fotoCarnet") : null,
            coches: response.coches || [] // Asegúrate de que la lista de coches esté definida o vacía
          };

          // Log de autenticación exitosa
          console.log('Usuario autenticado:', this.usuario);

          // Redirigir a la página de inicio después de la autenticación exitosa
          this.router.navigate(['inicio']);
        },
        error => {
          // Manejo de errores
          console.error('Error de autenticación:', error);
          alert('DNI o contraseña incorrectos.');
        }
      );
  }

}

