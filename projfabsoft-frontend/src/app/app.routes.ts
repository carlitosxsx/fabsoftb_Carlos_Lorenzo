import { Routes } from '@angular/router';
import { EmployeeComponent } from './employee/employee.component';
import { FormEmployeeComponent } from './form-employee/form-employee.component';
import { ClienteComponent } from './cliente/cliente.component';
import { FormClienteComponent } from './form-cliente/form-cliente.component';
import { DemandComponent } from './demand/demand.component';
import { FormDemandComponent } from './form-demand/form-demand.component';

export const routes: Routes = [
    { path: 'employees', component: EmployeeComponent},
    { path: 'employees/novo', component: FormEmployeeComponent},
    { path: 'employees/alterar/:id', component: FormEmployeeComponent},
    { path: 'clientes', component: ClienteComponent},
    { path: 'clientes/novo', component: FormClienteComponent},
    { path: 'clientes/alterar/:id', component: FormClienteComponent},
    { path: 'demands', component: DemandComponent},
    { path: 'demands/novo', component: FormDemandComponent},
    { path: 'demands/alterar/:id', component: FormDemandComponent}
];
