import { Component, OnInit } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { BuscadorComponent } from '../buscador/buscador.component';
import { Usuario } from '../_modelo/Usuario';
import { UsuarioService } from '../_servicio/usuario.service';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [RouterOutlet,RouterModule,BuscadorComponent],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css'
})
export class InicioComponent implements OnInit {
  usuario: Usuario | null = null;

  constructor(private usuarioService: UsuarioService) {}

  ngOnInit(): void {
    // Suscribirse al observable para obtener la información del usuario
    this.usuarioService.usuario$.subscribe(usuario => {
      this.usuario = usuario; // Actualiza la variable local cuando hay cambios
    });
  }
}
