import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { entorno } from '../_entorno/entorno';
import { BusquedaInicial } from '../_modelo/BusquedaInicial';
import { Observable } from 'rxjs';
import { BusquedaCompleta } from '../_modelo/BusquedaCompleta';

@Injectable({
  providedIn: 'root'
})
export class ViajesService {

  private url:string = `${entorno.HOST}/viajes`

  constructor(private http:HttpClient) { }

  busquedaInicial(origen:string, destino:string, fInicio:Date, fFin:Date, pDisponibles:number):Observable<BusquedaInicial[]>{
    return this.http.get<BusquedaInicial[]>(`${this.url}/${origen}/${destino}/${fInicio}/${fFin}/${pDisponibles}`);
  }

  busquedaCompleta(id:number):Observable<BusquedaCompleta>{
    return this.http.get<BusquedaCompleta>(`${this.url}/${id}`);
  }
}
