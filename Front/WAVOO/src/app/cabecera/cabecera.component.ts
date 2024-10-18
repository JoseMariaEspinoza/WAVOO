import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Usuario } from '../_modelo/Usuario';
import { UsuarioService } from '../_servicio/usuario.service';

@Component({
  selector: 'app-cabecera',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './cabecera.component.html',
  styleUrl: './cabecera.component.css'
})
export class CabeceraComponent implements OnInit {
  usuario: Usuario | null = null;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    // Suscribirse al observable para obtener la información del usuario
    this.usuarioService.usuario$.subscribe(usuario => {
      this.usuario = usuario; // Actualiza la variable local cuando hay cambios
    });

    // Cargar el usuario desde localStorage
    this.usuarioService.loadUserFromLocalStorage();
  }
}
