import { Employee } from './employee';
import { Cliente } from './cliente';
import { Status } from './status';

export class Demand {
    id:number;
    name:string;
    responsible:Employee;
    client:Cliente;
    status:Status;
    deadline:Date;
}
