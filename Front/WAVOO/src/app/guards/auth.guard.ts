import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { UsuarioService } from '../_servicio/usuario.service';
import { Usuario } from '../_modelo/Usuario';


@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private usuarioService: UsuarioService, private router: Router) {}

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    
    // Obtener el usuario actual desde el servicio
    const usuario: Usuario | null = this.usuarioService.getUsuario(); // Asegúrate de implementar este método en UsuarioService

    // Comprobar si el usuario está logueado y tiene permiso de conducir
    if (usuario && usuario.permisoConducir) {
      return true; // Permitir el acceso
    }

    // Redirigir a login si no está autorizado
    this.router.navigate(['/login']); 
    return false;
  }
}
