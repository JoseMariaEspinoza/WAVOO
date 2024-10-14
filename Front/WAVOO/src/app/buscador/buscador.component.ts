import { Component, Input, OnInit } from '@angular/core';
import { ViajesService } from '../_servicio/viajes.service';
import { BusquedaInicial } from '../_modelo/BusquedaInicial';
import { RouterModule} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-buscador',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './buscador.component.html',
  styleUrls: ['./buscador.component.css']
})
export class BuscadorComponent implements OnInit {
  @Input() origen: string = '';
  @Input() destino: string = '';
  @Input() fInicio: Date = new Date();
  @Input() fFin: Date = new Date();
  @Input() pDisponibles: number = 0;

  busquedaInicial: BusquedaInicial[] = [];

  constructor(private servicio: ViajesService) { }

  ngOnInit(): void {
    this.servicio.busquedaInicial(this.origen, this.destino, this.fInicio, this.fFin, this.pDisponibles)
      .subscribe(datos => {
        this.busquedaInicial = datos;
      });
    
  }
}
