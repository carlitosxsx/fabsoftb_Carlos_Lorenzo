import { Component } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-employee',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css',
  providers: [EmployeeService]
})
export class EmployeeComponent {
    listaEmployees: Employee[] = [];

    constructor(private employeeService: EmployeeService) {}

    ngOnInit(){
      console.log("Carregando funcionários...");
      this.employeeService.getEmployee().subscribe(
        employees => {
          this.listaEmployees = employees;
        }
      );
    }

}

