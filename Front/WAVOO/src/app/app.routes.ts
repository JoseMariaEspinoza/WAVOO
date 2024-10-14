import { Routes } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { BuscadorComponent } from './buscador/buscador.component';
import { BusquedaInicialComponent } from './busqueda-inicial/busqueda-inicial.component';

export const routes: Routes = [

    {'path': 'inicio', 'component': InicioComponent},
    {'path': 'buscador' , 'component': BuscadorComponent, 'children': 
        [
            {'path': 'inicial', 'component': BusquedaInicialComponent}
            // {'path': 'completa', 'component': BusquedaCompletaComponent}
        ]},
    {'path': '', 'redirectTo': 'inicio', 'pathMatch': 'full'}

];
