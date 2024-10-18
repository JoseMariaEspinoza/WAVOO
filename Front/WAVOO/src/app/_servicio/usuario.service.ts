import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { FormularioUsuario } from '../_modelo/FormularioUsuario';
import { entorno } from '../_entorno/entorno';
import { Usuario } from '../_modelo/Usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  // Subject para manejar el estado del usuario actual
  private usuarioSubject = new BehaviorSubject<Usuario | null>(null); // Inicializa el usuario como nulo
  public usuario$ = this.usuarioSubject.asObservable(); // Observable para que los componentes puedan suscribirse

  // URL base para las solicitudes al backend
  private url: string = `${entorno.HOST}/usuarios`;


  
  // Constructor del servicio, donde se inyecta HttpClient
  constructor(private http: HttpClient) {
    // Cargar el usuario desde localStorage al iniciar el servicio
    this.loadUserFromLocalStorage();
  }

  // Método para iniciar sesión y almacenar el usuario
  login(usuario: Usuario): void {
    // Actualiza el BehaviorSubject con el usuario
    this.usuarioSubject.next(usuario);
    // Almacena el usuario en localStorage para persistencia entre recargas
    localStorage.setItem('usuario', JSON.stringify(usuario));
  }
  // Método para salir, restableciendo el estado del usuario
  logout(): void {
    this.usuarioSubject.next(null); // Restablece el usuario en el BehaviorSubject
    localStorage.removeItem('usuario'); // Elimina el usuario de localStorage
  }

  // Método para cargar el usuario desde localStorage al inicializar el servicio
  loadUserFromLocalStorage() {
    if (typeof window !== 'undefined' && window.localStorage) {
      const user = localStorage.getItem('user');
      return user ? JSON.parse(user) : null;
    }
    return null;
  }

  saveUserToLocalStorage(user: any) {
    if (typeof window !== 'undefined' && window.localStorage) {
      localStorage.setItem('user', JSON.stringify(user));
    }
  }

  // Método para registrar un nuevo usuario
  registrarUsuario(formularioUsuario: FormularioUsuario): Observable<string> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<string>(this.url, formularioUsuario, { headers });
  }

  // Método para identificar un usuario mediante DNI y contraseña
  identificarUsuario(dni: string, contrasena: string): Observable<Usuario> {
    return this.http.get<Usuario>(`${this.url}/login/${dni}/${contrasena}`);
  }
  getUsuario(): Usuario | null {
    return this.usuarioSubject.getValue(); // Recupera el usuario del BehaviorSubject
  }
}

