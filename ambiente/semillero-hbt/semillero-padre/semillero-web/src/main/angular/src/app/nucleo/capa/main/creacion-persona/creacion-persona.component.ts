import { Component, OnInit } from '@angular/core';
import {TipoIdentificacion} from './TipoIdentificacion' 

@Component({
  selector: 'app-creacion-persona',
  templateUrl: './creacion-persona.component.html',
  styleUrls: ['./creacion-persona.component.css']
})
export class CreacionPersonaComponent implements OnInit {

  nombre : string ;
  apellido : string ;
  numId : string ;
  id : string ;
  tipoDocumento: string[];
  

  constructor() {

   const keys = Object.keys(TipoIdentificacion);
      console.log(keys);

   }

  ngOnInit() {
  }

}
