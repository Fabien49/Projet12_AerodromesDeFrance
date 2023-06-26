import { Component, Input, OnInit } from '@angular/core';
import { AeroclubService } from 'src/app/services/aeroclub.service';
import { TarifService } from 'src/app/services/tarif.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Aeroclub } from 'src/app/models/aeroclub.model';
import { Tarif } from 'src/app/models/tarif.model';

@Component({
  selector: 'app-tarif-details',
  templateUrl: './tarif-details.component.html',
  styleUrls: ['./tarif-details.component.css']
})
export class TarifDetailsComponent implements OnInit {

  @Input() viewMode = false;

  @Input() currentAeroclub: Aeroclub = {
    oaci: '',
    name: '',
    type: '',
    phoneNumber: '',
    mail: '',
    adresse: '',
    codePostal: ''
  };

  @Input() currentTarif: Tarif = {
    taxeAtterrissage: '',
    taxeParking: '',
    carburant: ''
  };
  
  message = '';

  constructor(
    private aeroclubService: AeroclubService,
    private tarifService: TarifService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getAeroclub(this.route.snapshot.params["id"]);
    }
  }

  getAeroclub(id: string): void {
    this.aeroclubService.get(id)
      .subscribe({
        next: (data) => {
          this.currentAeroclub = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  getTarif(id: string): void {
    this.tarifService.get(id)
      .subscribe({
        next: (data) => {
          this.currentTarif = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
  }

  updateTarif(): void {
    this.message = '';

    this.tarifService.update(this.currentTarif.id, this.currentTarif)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This tarif was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  deleteTarif(): void {
    this.tarifService.delete(this.currentTarif.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/aeroclub']);
        },
        error: (e) => console.error(e)
      });
  }

}