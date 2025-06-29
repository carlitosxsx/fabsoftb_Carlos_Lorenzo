import { Component, ElementRef, ViewChild } from '@angular/core';
import { Demand } from '../model/demand';
import { DemandService } from '../service/demand.service';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import * as bootstrap from 'bootstrap';

@Component({
  selector: 'app-demand',
  imports: [HttpClientModule, CommonModule],
  templateUrl: './demand.component.html',
  styleUrl: './demand.component.css',
  providers: [DemandService, Router]
})
export class DemandComponent {
    
  listaDemands: Demand[] = [];
  @ViewChild('myModal') modalElement!: ElementRef;
  private modal!: bootstrap.Modal;
  private demandSelecionado!: Demand;

  constructor(
    private demandService: DemandService,
    private router:Router
  ) {}

  novo(){
    this.router.navigate(['demands/novo'])
  }

  ngOnInit(){
    console.log("Carregando demandas...");
    this.demandService.getDemand().subscribe(
      demands => {
        this.listaDemands = demands;
      }
    );
  }

  alterar(demand:Demand){
    this.router.navigate(['demands/alterar', demand.id]);
  }

  abrirConfirmacao(demand:Demand) {
    this.demandSelecionado = demand;
    this.modal = new bootstrap.Modal(this.modalElement.nativeElement);
    this.modal.show();
  }

  fecharConfirmacao() {
    this.modal.hide();
  }

  confirmarExclusao() {
      this.demandService.deleteDemand(this.demandSelecionado.id).subscribe(
          () => {
              this.fecharConfirmacao();
              this.demandService.getDemand().subscribe(
                demand => {
                  this.listaDemands = demand;
                }
              );
          },
          error => {
              console.error('Erro ao excluir demanda:', error);
          }
      );
  }

}

