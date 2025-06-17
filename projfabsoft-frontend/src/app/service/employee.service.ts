import { Injectable } from '@angular/core';
import { Employee } from '../model/employee'; 
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  apiURL = "http://localhost:8080/api/v1/employee";

  constructor(private http:HttpClient) { }

  getEmployee(){
    return this.http.get<Employee[]>(this.apiURL)
  }

  saveEmployee(employee:Employee){
    if(employee.id){
      return this.http.put(this.apiURL + '/' + employee.id, employee);
    }
    return this.http.post(this.apiURL,employee);
  }

  getEmployeeById(id: any) {
    return this.http.get<Employee>(this.apiURL + '/' + id);
  }

  deleteEmployee(id: any){
    return this.http.delete<Employee>(this.apiURL + '/' + id);
  }
  
}