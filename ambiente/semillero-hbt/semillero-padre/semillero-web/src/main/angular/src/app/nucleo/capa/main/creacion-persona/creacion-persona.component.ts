import { Component, OnInit } from '@angular/core';
import {TipoIdentificacion} from './TipoIdentificacion' 

@Component({
  selector: 'app-creacion-persona',
  templateUrl: './creacion-persona.component.html',
  styleUrls: ['./creacion-persona.component.css']
})
export class CreacionPersonaComponent implements OnInit {

 public nombre : string ;
 public apellido : string ;
 public numId : string ;
 public id : string ;
 public tipoDocumento: Array<string>=['Cedula','Tarjeta de identidad','Pasaporte'];
 
  constructor() {
   }

  ngOnInit() {
  }

}
