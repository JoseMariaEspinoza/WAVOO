import { Injectable } from '@angular/core';
import { Plazas } from '../_modelo/Plazas';
import { entorno } from '../_entorno/entorno';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlazasService {

  private url:string = `${entorno.HOST}/plazas`

  constructor(private http:HttpClient) { }

  putPlazas(plazas: Plazas): Observable<Plazas> {
    return this.http.put<Plazas>(this.url, plazas);
  }
  
}
