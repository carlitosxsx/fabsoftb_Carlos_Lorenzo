import { Component } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css',
  providers: [EmployeeService, Router]
})
export class EmployeeComponent {
    listaEmployees: Employee[] = [];

    constructor(
      private employeeService: EmployeeService,
      private router:Router
    ) {}

    novo(){
      this.router.navigate(['employees/novo'])
    }

    ngOnInit(){
      console.log("Carregando funcionários...");
      this.employeeService.getEmployee().subscribe(
        employees => {
          this.listaEmployees = employees;
        }
      );
    }

    alterar(employee:Employee){
      this.router.navigate(['employees/alterar', employee.id]);
    }

}

