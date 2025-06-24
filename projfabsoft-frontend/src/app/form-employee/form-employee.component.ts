import { Component } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-form-employee',
  imports: [HttpClientModule, CommonModule, FormsModule],
  templateUrl: './form-employee.component.html',
  styleUrl: './form-employee.component.css',
  providers: [EmployeeService, Router]
})
export class FormEmployeeComponent {
    employee: Employee = new Employee();
    listaLeader: Employee[] = [] 

    constructor(
      private employeeService:EmployeeService,
      private router:Router,
      private activeRouter: ActivatedRoute
    ){
        const id = this.activeRouter.snapshot.paramMap.get('id');

        this.employeeService.getEmployee().subscribe(leader => {
          this.listaLeader = leader
        });

        if (id) {
          this.employeeService.getEmployeeById(id).subscribe(employee => {
            this.employee = employee;
          });
        }

    }

    salvar(){
      this.employeeService.saveEmployee(this.employee)
        .subscribe(resultado => {
          this.router.navigate(['employees']);
        });
    }

    comparaLeader(obj1: Employee, obj2: Employee): boolean {
      return obj1 && obj2 ? obj1.id === obj2.id : obj1 === obj2;
    }
}
