import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { BusquedaCompleta } from '../_modelo/BusquedaCompleta';
import { ViajesService } from '../_servicio/viajes.service';
import { Plazas } from '../_modelo/Plazas';
import { PlazasService } from '../_servicio/plazas.service';

@Component({
  selector: 'app-busqueda-completa',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './busqueda-completa.component.html',
  styleUrl: './busqueda-completa.component.css'
})
export class BusquedaCompletaComponent {resultadoCompleto!: BusquedaCompleta; // Almacena la búsqueda completa
 // Array para las plazas seleccionadas
selectedPlazas: number[] = []; // Almacena IDs de plazas seleccionadas

constructor(private servicio: ViajesService, private plazasService: PlazasService) {}

ngOnInit(): void {
  this.servicio.getResultadosCompleta().subscribe(datos => {
    this.resultadoCompleto = datos;
    console.log('Resultados de búsqueda completa:', this.resultadoCompleto);
  });
}

togglePlazaSeleccionada(idPlaza: number, event: Event) {
  const isChecked = (event.target as HTMLInputElement).checked;

  if (isChecked) {
    // Agregar plaza a la lista de seleccionadas
    this.selectedPlazas.push(idPlaza);
  } else {
    // Eliminar plaza de la lista de seleccionadas
    this.selectedPlazas = this.selectedPlazas.filter(plaza => plaza !== idPlaza);
  }
}

isPlazaSeleccionada(idPlaza: number): boolean {
  return this.selectedPlazas.includes(idPlaza);
}

// Método para realizar la reserva de las plazas
reservarPlazas(): void {
  const plazas: Plazas = {
    idPlaza: this.selectedPlazas,       // Array de plazas seleccionadas
    dni: this.resultadoCompleto.dni,   // El DNI del usuario logeado
    idViaje: this.resultadoCompleto.idViaje // El ID del viaje
  };

  // Llama al servicio para realizar el PUT
  this.plazasService.putPlazas(plazas)
  .subscribe(
    (response) => {
      console.log('Plazas reservadas con éxito:', response);
    },
    (error) => {
      console.error('Error al reservar plazas:', error);
    }
  );
}

getPlazaNombres(): { id: number, nombre: string }[] {
  const nombresPlazas: { [key: number]: string } = {
    1: 'Piloto',
    2: 'Copiloto',
    3: 'Izquierda',
    4: 'Central',
    5: 'Derecha'
  };

  const plazasNombres = this.resultadoCompleto.plazas
    .map(plaza => ({ id: plaza.id, nombre: nombresPlazas[plaza.id] }))
    .sort((a, b) => a.id - b.id);
  
  console.log('Plazas nombres:', plazasNombres); // Añade esta línea para verificar los datos
  return plazasNombres;
  
  // return this.resultadoCompleto.plazas // Asegúrate de que esto coincida con la propiedad que contiene las plazas.
  //   .map(plaza => ({ id: plaza.id, nombre: nombresPlazas[plaza.id] }))
  //   .sort((a, b) => a.id - b.id);
}

  
}
