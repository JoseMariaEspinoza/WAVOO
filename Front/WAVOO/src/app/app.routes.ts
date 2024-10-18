import { Routes } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { BuscadorComponent } from './buscador/buscador.component';
import { BusquedaInicialComponent } from './busqueda-inicial/busqueda-inicial.component';
import { BusquedaCompletaComponent } from './busqueda-completa/busqueda-completa.component';
import { LoginComponent } from './login/login.component';
import { RegistroComponent } from './registro/registro.component';
import { PublicarComponent } from './publicar/publicar.component';
import { AuthGuard } from './guards/auth.guard';

export const routes: Routes = [
    { path: 'inicio', component: InicioComponent },
    { path: 'buscador', component: BuscadorComponent, children: [
      { path: 'inicial', component: BusquedaInicialComponent },
      { path: 'completa', component: BusquedaCompletaComponent }
    ]},
    { path: 'login', component: LoginComponent },
    { path: 'registro', component: RegistroComponent}, // No se puede acceder si ya está logueado
    { path: 'publicar', component: PublicarComponent}, // Requiere estar logueado
    { path: '', redirectTo: 'inicio', pathMatch: 'full' }
  ];
  
