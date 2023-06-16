import { Component, Input, OnInit } from '@angular/core';
import { AeroclubService } from 'src/app/services/aeroclub.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Aeroclub } from 'src/app/models/aeroclub.model';

@Component({
  selector: 'app-aeroclub-details',
  templateUrl: './aeroclub-details.component.html',
  styleUrls: ['./aeroclub-details.component.css']
})
export class AeroclubDetailsComponent implements OnInit {

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
  
  message = '';

  constructor(
    private aeroclubService: AeroclubService,
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

  updateAeroclub(): void {
    this.message = '';

    this.aeroclubService.update(this.currentAeroclub.id, this.currentAeroclub)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This aeroclub was updated successfully!';
        },
        error: (e) => console.error(e)
      });
  }

  deleteAeroclub(): void {
    this.aeroclubService.delete(this.currentAeroclub.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/tutorials']);
        },
        error: (e) => console.error(e)
      });
  }

}