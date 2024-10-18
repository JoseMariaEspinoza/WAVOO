import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { Viaje } from '../_modelo/Viaje';
import { ViajesService } from '../_servicio/viajes.service';

@Component({
  selector: 'app-publicar',
  standalone: true,
  imports: [RouterModule,FormsModule,CommonModule],
  templateUrl: './publicar.component.html',
  styleUrl: './publicar.component.css'
})
export class PublicarComponent {

  viaje: Viaje = {
    idViaje: 0,
    origen: '',
    destino: '',
    precio: 0,
    fecha: new Date,
    hora: '',
    matricula: ''
  };

  constructor(private viajeService: ViajesService) {}

  guardarViaje() {
    this.viajeService.insertarViaje(this.viaje)
    .subscribe(response => {
      console.log('Viaje creado:', response);
      // Manejar la respuesta (puedes redirigir a otra página o mostrar un mensaje)
    }, error => {
      console.error('Error al crear viaje:', error);
      // Manejar el error
    });
  }

}
