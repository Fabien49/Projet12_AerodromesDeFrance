import { Component, OnInit } from '@angular/core';
import { Aeroclub } from 'src/app/models/aeroclub.model';
import { Tarif } from 'src/app/models/tarif.model';
import { AeroclubService } from 'src/app/services/aeroclub.service';
import { TarifService } from 'src/app/services/tarif.service';

@Component({
  selector: 'app-aeroclub-list',
  templateUrl: './aeroclub-list.component.html',
  styleUrls: ['./aeroclub-list.component.css']
})
export class AeroclubListComponent implements OnInit {


  aeroclubs?: Aeroclub[];
  currentAeroclub: Aeroclub = {};
  tarifs?: Aeroclub[];
  currentTarif: Tarif = {};
  currentIndex = -1;
  oaci = '';

  constructor(private aeroclubService: AeroclubService, private tarifService: TarifService) { }

  ngOnInit(): void {
    this.retrieveAeroclub();
  }

  retrieveAeroclub(): void {
    this.aeroclubService.getAll()
      .subscribe({
        next: (data) => {
          this.aeroclubs = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

/*   retrieveTarif(id: any): void {
    this.tarifService.get(id)
      .subscribe({
        next: (data) => {
          this.currentTarif = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  } */



  refreshList(): void {
    this.retrieveAeroclub();
    this.currentAeroclub = {};
    this.currentIndex = -1;
  }

  setActiveAeroclub(aeroclub: Aeroclub, index: number, tarif: Tarif): void {
    this.currentAeroclub = aeroclub;
    this.currentTarif = tarif;
    this.currentIndex = index;
  }

  removeAllAeroclub(): void {
    this.aeroclubService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refreshList();
        },
        error: (e) => console.error(e)
      });
  }

  searchOaci(): void {
    this.currentAeroclub = {};
    this.currentIndex = -1;

    this.aeroclubService.findByOaci(this.oaci)
      .subscribe({
        next: (data) => {
          this.aeroclubs = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

}