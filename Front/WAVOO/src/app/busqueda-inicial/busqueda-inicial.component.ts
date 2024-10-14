import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule, RouterOutlet } from '@angular/router';
import { ViajesService } from '../_servicio/viajes.service';
import { BusquedaInicial } from '../_modelo/BusquedaInicial';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-busqueda-inicial',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './busqueda-inicial.component.html',
  styleUrls: ['./busqueda-inicial.component.css']
})
export class BusquedaInicialComponent implements OnInit {

  busquedaInicial: BusquedaInicial[] = [];

  constructor(private servicio: ViajesService) {}

  ngOnInit(): void {
    
  }

  // navegarABusquedaCompleta(id: number): void {
  //   // Navegar al componente de búsqueda completa
  //   this.router.navigate(['/busqueda-completa', id]);
  // }
}
