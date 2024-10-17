import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { BuscadorComponent } from './buscador/buscador.component';
import { CabeceraComponent } from './cabecera/cabecera.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,RouterModule,BuscadorComponent,CabeceraComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'WAVOO';
}
