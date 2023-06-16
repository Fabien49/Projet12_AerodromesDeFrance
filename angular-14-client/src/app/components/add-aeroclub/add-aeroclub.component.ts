import { Component } from '@angular/core';
import { Aeroclub } from 'src/app/models/aeroclub.model';
import { AeroclubService } from 'src/app/services/aeroclub.service';

@Component({
  selector: 'app-add-aeroclub',
  templateUrl: './add-aeroclub.component.html',
  styleUrls: ['./add-aeroclub.component.css']
})
export class AddAeroclubComponent {

  aeroclub: Aeroclub = {
    oaci: '',
    name: '',
    type: '',
    phoneNumber: '',
    mail: '',
    adresse: '',
    codePostal: ''
  };
  submitted = false;

  constructor(private aeroclubService: AeroclubService) { }

  saveAeroclub(): void {
    const data = {
      oaci: this.aeroclub.oaci,
      name: this.aeroclub.name,
      type: this.aeroclub.type,
      phoneNumber: this.aeroclub.phoneNumber,
      mail: this.aeroclub.mail,
      adresse: this.aeroclub.adresse,
      codePostal: this.aeroclub.codePostal
    };

    this.aeroclubService.create(data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
        error: (e) => console.error(e)
      });
  }

  newAeroclub(): void {
    this.submitted = false;
    this.aeroclub = {
      oaci: '',
      name: '',
      type: '',
      phoneNumber: '',
      mail: '',
      adresse: '',
      codePostal: ''
    };
  }

}