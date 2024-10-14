import { Component, OnInit } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { BuscadorComponent } from '../buscador/buscador.component';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [RouterOutlet,RouterModule,BuscadorComponent],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css'
})
export class InicioComponent {

  
}
