import { Component, Input } from '@angular/core';
import { Aeroclub } from 'src/app/models/aeroclub.model';
import { Tarif } from 'src/app/models/tarif.model';
import { TarifService } from 'src/app/services/tarif.service';
import { AeroclubService } from 'src/app/services/aeroclub.service';

@Component({
  selector: 'app-add-tarif',
  templateUrl: './add-tarif.component.html',
  styleUrls: ['./add-tarif.component.css']
})
export class AddTarifComponent {

  @Input() currentAeroclub: Aeroclub = {
    id: this.aeroclubService.findById,
  };

  tarif: Tarif = {
    taxeAtterrissage: '',
    taxeParking: '',
    carburant: '',
    aeroclub_id:''
  };
  submitted = false;

  constructor(private tarifService: TarifService, private aeroclubService: AeroclubService) { }

  saveTarif(id: any): void {
    const data = {
      taxeAtterrissage: this.tarif.taxeAtterrissage,
      taxeParking: this.tarif.taxeParking,
      carburant: this.tarif.carburant,
      aeroclub_id: this.aeroclubService.findById(id)
    };

    this.tarifService.create(id,data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }

  newTarif(): void {
    this.submitted = false;
    this.tarif = {
      taxeAtterrissage: '',
      taxeParking: '',
      carburant: ''
    };
  }

}