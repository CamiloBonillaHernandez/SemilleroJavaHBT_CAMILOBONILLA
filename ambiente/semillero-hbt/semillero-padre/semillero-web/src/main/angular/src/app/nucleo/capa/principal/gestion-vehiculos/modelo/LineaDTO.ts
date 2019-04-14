import { MarcaDTO } from './MarcaDTO';

export interface LineaDTO {
    idLinea: string;
    nombre: string;
    cilindraje: string;
    marca : MarcaDTO;
  }