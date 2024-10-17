export interface BusquedaCompleta {
    idViaje:           number;
    origen:            string;
    destino:           string;
    fecha:             Date;
    hora:              string;
    precio:            number;
    plazasDisponibles: number;
    dni:               string;
    nombreCompleto:    string;
    fotoUsuario:       string;
    telefono:          string;
    genero:            string;
    edad:              number;
    fotoCoche:         string;
    marca:             string;
    modelo:            string;
    matricula:         string;
    carroceria:        string;
    anio:              number;
    id_plaza: number[];
}
