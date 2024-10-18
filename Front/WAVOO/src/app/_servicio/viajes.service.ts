import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { entorno } from '../_entorno/entorno';
import { BusquedaInicial } from '../_modelo/BusquedaInicial';
import { BehaviorSubject, Observable, of, tap } from 'rxjs';
import { BusquedaCompleta } from '../_modelo/BusquedaCompleta';
import { Viaje } from '../_modelo/Viaje';

@Injectable({
  providedIn: 'root'
})
export class ViajesService {

  resultadosBusqueda: BusquedaInicial[] = [];

  private url:string = `${entorno.HOST}/viajes`

  constructor(private http:HttpClient) { }

  private resultadosBusquedaSubject = new BehaviorSubject<BusquedaInicial[]>([]);
  resultadosBusqueda$ = this.resultadosBusquedaSubject.asObservable();

  private resultadosCompletaSubject = new BehaviorSubject<BusquedaCompleta>({
    idViaje: 0,
    origen: '',
    destino: '',
    fecha: new Date(), // Puedes establecer una fecha por defecto
    hora: '',
    precio: 0,
    plazasDisponibles: 0,
    dni: '',
    nombreCompleto: '',
    fotoUsuario: '',
    telefono: '',
    genero: '',
    edad: 0,
    fotoCoche: '',
    marca: '',
    modelo: '',
    matricula: '',
    carroceria: '',
    anio: 0,
    plazas: []
  });
  resultadosCompleta$ = this.resultadosCompletaSubject.asObservable();

  // Método para buscar todos los viajes
  buscarTodosLosViajes(): Observable<any> {
    return this.http.get(`${this.url}/todos`);
  }
  setResultadosBusqueda(origen: string, destino: string, fInicio: Date, fFin: Date, pDisponibles: number): Observable<BusquedaInicial[]> {
    const searchUrl = `${this.url}/${origen}/${destino}/${fInicio}/${fFin}/${pDisponibles}`;
    return this.http.get<BusquedaInicial[]>(searchUrl).pipe(
      tap((resultados: BusquedaInicial[]) => {
        this.resultadosBusquedaSubject.next(resultados); // Actualiza el BehaviorSubject con los nuevos resultados
      })
    );
  }

  // Método para obtener los resultados de búsqueda almacenados
  getResultadosBusqueda(): Observable<BusquedaInicial[]> {
    return this.resultadosBusqueda$; // Devolvemos el observable del BehaviorSubject
  }

  busquedaCompleta(id: number): Observable<BusquedaCompleta> {
    return this.http.get<BusquedaCompleta>(`${this.url}/${id}`).pipe(
      tap((resultado: BusquedaCompleta) => {
        this.resultadosCompletaSubject.next(resultado); // Actualiza el BehaviorSubject con el resultado completo
      })
    );
  }

  getResultadosCompleta(): Observable<BusquedaCompleta> {
    return this.resultadosCompleta$; // Devolvemos el observable del BehaviorSubject
  }

  insertarViaje(viaje: Viaje): Observable<Viaje> {
    return this.http.post<Viaje>(this.url, viaje);
  }

}
