import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BusquedaCompleta } from '../_modelo/BusquedaCompleta';
import { ViajesService } from '../_servicio/viajes.service';
import { AsientosComponent } from '../asientos/asientos.component';

@Component({
  selector: 'app-busqueda-completa',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule,AsientosComponent],
  templateUrl: './busqueda-completa.component.html',
  styleUrl: './busqueda-completa.component.css'
})
export class BusquedaCompletaComponent {

  resultadoCompleto!: BusquedaCompleta; // Almacena la búsqueda completa

  constructor(private servicio: ViajesService) {}

  ngOnInit(): void {
    this.servicio.getResultadosCompleta().subscribe(datos => {
      this.resultadoCompleto = datos;
      console.log('Resultados de búsqueda completa:', this.resultadoCompleto);
  });
  }
}
