import { Routes } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { FormEmployeeComponent } from './form-employee/form-employee.component';

export const routes: Routes = [
    { path: 'employees', component: EmployeeComponent},
    { path: 'employees/novo', component: FormEmployeeComponent},
    { path: 'employees/alterar/:id', component: FormEmployeeComponent}
];
