import { Component, OnInit } from '@angular/core';
import {personaDTO} from '../apoyo/modelo/personaDTO';

@Component({
  selector: 'app-creacion-personas',
  templateUrl: './creacion-personas.component.html'
})
export class CreacionPersonasComponent implements OnInit {
  
  public header : string = 'Modulo Personas';

  public persona : personaDTO;
  public personas : personaDTO[];
  public gestionarPersona :boolean;
  public guardarPersona : boolean;
  public editarPersona: boolean;


 /*
  public id : number = 1;
  public nombre : string = 'Juan';
  public apellidos : string = 'Perez';
  public tipoIdentificacion : string = 'cedula';
  public formHidden : boolean = false;
  */
  constructor() { }

  ngOnInit() {

    this.persona  = {
      id : '0',
      nombre : '',
      apellido : '',
      fechaNacimiento: '',
      tipoIdentificacion : '',
      numeroIdentificacion : '',
      mayorEdad : false, //check  box 
      sexo : '' //radio button 
    };

    this.personas =  [];
    this.gestionarPersona = false;
    this.guardarPersona = false;
    this.editarPersona = false;
  }

  public mostrar(){

  }
  public ocultar(){

  }
  public guardar(){
    this.personas.push(this.persona);
    console.log('guardar()' + this.persona.nombre);
  }

  private borrar(){

  }

  public gestionarP(){
    console.log('gestionar');
    this.gestionarPersona = true;
    this.editarPersona  = false;
    this.guardarPersona = false;
  }
  public editarP(){
    console.log('editar');
    this.editarPersona  = true;
    this.guardarPersona = false;
    this.gestionarPersona = false;
  }
  public guardarP(){
    console.log('guardar');
    this.guardarPersona = true;
    this.editarPersona  = false;
    this.gestionarPersona = false;
  }

}
