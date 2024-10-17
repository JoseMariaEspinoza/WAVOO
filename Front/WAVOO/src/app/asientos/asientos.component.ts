import { Component, OnInit } from '@angular/core';
import { ViajesService } from '../_servicio/viajes.service';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-asientos',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './asientos.component.html',
  styleUrl: './asientos.component.css'
})
export class AsientosComponent implements OnInit{
  idPlaza: number[] = []; // Almacena los IDs de las plazas seleccionadas
  plazas: any[] = []; // Almacena la información de las plazas
  viajeId: number = 0; // ID del viaje (puedes pasarlo como input al componente)

  constructor(private viajeService: ViajesService) { }

  ngOnInit(): void {
    this.viajeService.busquedaCompleta(this.viajeId).subscribe(data => {
      this.plazas = data.id_plaza; // Suponiendo que tienes la lógica para recibir los datos
    });
  }

  seleccionarPlaza(id: number) {
    const index = this.idPlaza.indexOf(id);
    if (index === -1) {
      this.idPlaza.push(id); // Agregar plaza si no está en el array
    } else {
      this.idPlaza.splice(index, 1); // Quitar plaza si ya está seleccionada
    }
  }

  reservarPlazas() {
    const reserva = {
      idPlaza: this.idPlaza,
      dni: 'DNI_DEL_USUARIO', // Asigna el DNI del usuario
      idViaje: this.viajeId
    };

    // Aquí puedes llamar a tu método de reserva
    console.log(reserva);
  }

}
