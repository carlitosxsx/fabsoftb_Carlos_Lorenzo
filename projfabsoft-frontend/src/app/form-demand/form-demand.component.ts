import { Component } from '@angular/core';
import { Demand } from '../model/demand';
import { DemandService } from '../service/demand.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';
import { Cliente } from '../model/cliente'; 
import { ClienteService } from '../service/cliente.service';
import { Status } from '../model/status';
import { StatusService } from '../service/status.service';

@Component({
  selector: 'app-form-demand',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-demand.component.html',
  styleUrl: './form-demand.component.css',
  providers: [DemandService, Router, EmployeeService, ClienteService, StatusService]
})
export class FormDemandComponent {
    demand: Demand = new Demand();
    listaClients: Cliente[] = [] 
    listaResponsibles: Employee[] = [];
    listaStatus: Status[] = [];

    constructor(
      private demandService:DemandService,
      private clienteService: ClienteService,
      private employeeService: EmployeeService,
      private statusService: StatusService,
      private router:Router,
      private activeRouter: ActivatedRoute
    ){
        const id = this.activeRouter.snapshot.paramMap.get('id');

        this.clienteService.getClientes().subscribe(client => {
          this.listaClients = client;
        });

        this.employeeService.getEmployee().subscribe(employee => {
          this.listaResponsibles = employee;
        });

        this.statusService.getStatus().subscribe(status => {
          this.listaStatus = status;
        });

        if (id) {
          this.demandService.getDemandById(id).subscribe(demand => {
            this.demand = demand;
          });
        }

    }

    salvar(){
      this.demandService.saveDemand(this.demand)
        .subscribe(resultado => {
          this.router.navigate(['demands']);
        });
    }

    comparaClient(obj1: Cliente, obj2: Cliente): boolean {
      return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
    }
    comparaResponsible(obj1: Employee, obj2: Employee): boolean {
      return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
    }
    comparaStatus(obj1: Status, obj2: Status): boolean {
      return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
    }
}
