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
  public stateComprador : boolean;
  public stateVendedor : boolean;


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
      sexo : '', //radio button
      telefono:'',
      edad:'',
      estado:'' 
    };

    this.personas =  [];
    this.gestionarPersona = false;
    this.guardarPersona = false;
    this.editarPersona = false;
    this.stateComprador = false;
    this.stateVendedor = false;
  }

  public mostrar(){

  }
  public ocultar(){

  }
  public guardar(){
    this.setState();
    this.personas.push(this.persona);
    for (let i = 0; i < this.personas.length; i++) {
      const element = this.personas[i];
      console.log(element);
      
    }
  }

  public setState(){
    if (this.stateComprador) {
      this.persona.estado = 'Comprador';
    }else if(this.stateVendedor){
      this.persona.estado = 'Vendedor';
    }
  }

  private borrar(){

  }

  public consultar(){
    
  }

  public gestionarP(){
    this.gestionarPersona = true;
    this.editarPersona  = false;
    this.guardarPersona = false;
  }
  public editarP(){;
    this.editarPersona  = true;
    this.guardarPersona = false;
    this.gestionarPersona = false;
  }
  public guardarP(){
    this.guardarPersona = true;
    this.editarPersona  = false;
    this.gestionarPersona = false;
  }

}
