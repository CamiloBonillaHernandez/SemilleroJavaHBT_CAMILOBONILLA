import { Component, Input, OnInit } from '@angular/core';
import { ConsultaVehiculosService } from '../../../../../nucleo/servicios/consulta-vehiculo-servicio/consulta.vehiculo.service'
import { VehiculoDTO } from '../modelo/vehiculoDTO';
import { PersonaServicioDTO } from '../modelo/personaServicioDTO';
import { MarcaDTO } from '../modelo/MarcaDTO';
import { LineaDTO } from '../modelo/LineaDTO';


@Component({
  selector: 'app-resultados',
  templateUrl: './resultados.component.html'
})
export class ResultadosComponent implements OnInit {

  @Input() public idVehiculo:string;
  @Input() public placa:string;

  
  public listaPersonasDTO: PersonaServicioDTO[]; 
  public personaDTO: PersonaServicioDTO; 

  public marcasDTO : MarcaDTO[];
  public lineasDTO: LineaDTO[];
  public vehiculosDTO : VehiculoDTO[];
  

  constructor(private vehiculosService: ConsultaVehiculosService) {

  }

  ngOnInit() {

    this.consultarMarcas();
    this.consultarLineas("1");
    this.consultarVehiculo();
  }

  public consultarPersonas(){
    let tipoID: string = '1';
    let numID: string = '123';
    this.vehiculosService.consultarPersonas(tipoID,numID).subscribe(
      personas => {
          this.listaPersonasDTO = personas;
        },
        error => {
          console.log(error);
        } 
    );    
    console.log('resultado servicio Persona ' + this.listaPersonasDTO);
  }

  public consultarMarcas(){
    this.vehiculosService.consultarMarcas().subscribe(
      marcas => {
          this.marcasDTO = marcas;
        },
        error => {
          console.log(error);
        } 
    );    
    console.log('resultado servicio Marcas  ' + this.marcasDTO);
  }

  public consultarLineas( idMarca : string){
    this.vehiculosService.consultarLineas(idMarca).subscribe(
      lineas => {
          this.lineasDTO = lineas;
        },
        error => {
          console.log(error);
        } 
    );    
    console.log('resultado servicio Lineas ' + this.lineasDTO);
  }

  public consultarVehiculo(){
    this.vehiculosService.consultarVehiculos().subscribe(
      vehiculos => {
          this.vehiculosDTO= vehiculos;
        },
        error => {
          console.log(error);
        } 
    );    
    console.log('resultado servicio Vehiculos ' + this.vehiculosDTO);
  }

}
