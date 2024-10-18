import { Component, Input} from '@angular/core';
import { ViajesService } from '../_servicio/viajes.service';
import { BusquedaInicial } from '../_modelo/BusquedaInicial';
import { Router, RouterModule} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { BusquedaInicialComponent } from "../busqueda-inicial/busqueda-inicial.component";

@Component({
  selector: 'app-buscador',
  standalone: true,
  imports: [RouterModule, FormsModule, CommonModule, BusquedaInicialComponent],
  templateUrl: './buscador.component.html',
  styleUrls: ['./buscador.component.css']
})
export class BuscadorComponent {
  origen: string = '';
  destino: string = '';
  fInicio: Date = new Date();
  fFin: Date = new Date();
  pDisponibles: number = 0;

  busquedaInicial: BusquedaInicial[] = [];

  constructor(private servicio: ViajesService, private router: Router) {}

  buscar(): void {
    // Verifica si todos los campos están vacíos
    if (!this.origen && !this.destino && !this.fInicio && !this.fFin && !this.pDisponibles) {
      // Si todos los campos están vacíos, llama al método que obtiene todos los viajes
      this.servicio.buscarTodosLosViajes().subscribe(
        datos => {
          this.busquedaInicial = datos;
          console.log(datos);
          this.router.navigate(['/buscador/inicial']);
        },
        error => {
          console.error('Error al obtener todos los viajes', error);
        }
      );
    } else {
      // Si hay filtros aplicados, ejecuta la búsqueda filtrada
      this.servicio.setResultadosBusqueda(this.origen, this.destino, this.fInicio, this.fFin, this.pDisponibles)
      .subscribe(
        datos => {
          this.busquedaInicial = datos;
          console.log(datos);
          this.router.navigate(['/buscador/inicial']);
        },
        error => {
          console.error('Error al buscar viajes filtrados', error);
        }
      );
    }
  }
  
}
