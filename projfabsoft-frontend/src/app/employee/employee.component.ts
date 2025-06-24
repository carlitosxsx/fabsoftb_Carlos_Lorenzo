import { Component, ElementRef, ViewChild } from '@angular/core';
import { Employee } from '../model/employee';
import { EmployeeService } from '../service/employee.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-employee',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css',
  providers: [EmployeeService, Router]
})
export class EmployeeComponent {
    
  listaEmployees: Employee[] = [];
  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;
  private employeeSelecionado!: Employee;

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

  abrirConfirmacao(employee:Employee) {
    this.employeeSelecionado = employee;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
      this.employeeService.deleteEmployee(this.employeeSelecionado.id).subscribe(
          () => {
              this.fecharConfirmacao();
              this.employeeService.getEmployee().subscribe(
                employee => {
                  this.listaEmployees = employee;
                }
              );
          },
          error => {
              console.error('Erro ao excluir funcionário:', error);
          }
      );
  }

}

