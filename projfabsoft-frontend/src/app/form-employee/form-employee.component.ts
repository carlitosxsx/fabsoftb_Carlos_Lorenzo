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

    constructor(
      private employeeService:EmployeeService,
      private router:Router,
      private activeRouter: ActivatedRoute
    ){
        const id = this.activeRouter.snapshot.paramMap.get('id');

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
}
