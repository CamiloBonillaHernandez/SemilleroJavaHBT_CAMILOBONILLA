import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/toPromise';
import { AbstractService } from '../template.service';
import { VehiculoDTO } from '../../capa/principal/gestion-vehiculos/modelo/vehiculoDTO';
import { PersonaServicioDTO } from '../../capa/principal/gestion-vehiculos/modelo/personaServicioDTO';
import { MarcaDTO } from '../../capa/principal/gestion-vehiculos/modelo/MarcaDTO';
import { LineaDTO } from '../../capa/principal/gestion-vehiculos/modelo/LineaDTO';

@Injectable({
    providedIn: 'root'
})
export class ConsultaVehiculosService extends AbstractService {

    public vehiculo: VehiculoDTO;
    public listaVehiculoDTO: VehiculoDTO[];

    public marca : MarcaDTO;
    public listaMarcas : MarcaDTO[];

    public linea : LineaDTO;
    public listaLineas : LineaDTO[];

    /**
   * Constructor
   */
  constructor(injector: Injector) {
    super(injector);
  }


  public consultarPersonas(tipoID: string, numID: string) :  Observable<PersonaServicioDTO[]> {
    return this.get<PersonaServicioDTO[]>("/semillero-servicios", "/ConsultasRest/consultarPersonas",
    {
        "tipoID":tipoID, 
        "numID":numID,
      });
  }

  public consultarMarcas() :  Observable<MarcaDTO[]> {
    return this.get<MarcaDTO[]>("/semillero-servicios", "/ConsultasRest/consultarMarcas");
  }

  public consultarLineas(idMarca: string) :  Observable<LineaDTO[]> {
    return this.get<LineaDTO[]>("/semillero-servicios", "/ConsultasRest/consultarLineasPorMarca",
    {
        "idMarca":idMarca,
      });
  }
  
  public consultarVehiculos() :  Observable<VehiculoDTO[]> {
    return this.get<VehiculoDTO[]>("/semillero-servicios", "/ConsultasRest/consultarVehiculosPorLinea");
  }
  

}