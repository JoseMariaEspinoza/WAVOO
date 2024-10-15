import { Component, Input, OnInit} from '@angular/core';
import { Router, RouterModule} from '@angular/router';
import { ViajesService } from '../_servicio/viajes.service';
import { BusquedaInicial } from '../_modelo/BusquedaInicial';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { BusquedaCompleta } from '../_modelo/BusquedaCompleta';

@Component({
  selector: 'app-busqueda-inicial',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './busqueda-inicial.component.html',
  styleUrls: ['./busqueda-inicial.component.css']
})
export class BusquedaInicialComponent implements OnInit{
  resultado: BusquedaInicial[] = []; // Atributo público para acceder desde el HTML

  constructor(private servicio: ViajesService, private router: Router) {}

  ngOnInit(): void {
    // Recupera los resultados de búsqueda desde el servicio
    this.servicio.getResultadosBusqueda().subscribe(datos => {
      this.resultado = datos;
      console.log('Resultados de búsqueda inicial:', this.resultado);
    });
  }

  busquedaCompleta!: BusquedaCompleta;

  detalle(id:number): void {
    this.servicio.busquedaCompleta(id)
    .subscribe(datos => {
      this.busquedaCompleta = datos
      console.log(datos)
      this.router.navigate(['/buscador/completa']);
    });
  }
}
