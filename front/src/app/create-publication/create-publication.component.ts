import { Component } from '@angular/core';
import { PublicationsService } from './../publications.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-publication',
  templateUrl: './create-publication.component.html',
  styleUrls: ['./create-publication.component.css']
})
export class CreatePublicationComponent {

  animals:any;

  createPublicationForm = new FormGroup({
    city: new FormControl(''),
    nbJ: new FormControl(''),
    price: new FormControl(''),
    idAnimal: new FormControl(''),

  })

  constructor(private publicationsService:PublicationsService, private router:Router){
  }

  ngOnInit(): void {
    this.publicationsService.getMyAnimal().subscribe({
      next:(res:any) => {
        this.animals = res;
        console.log(this.animals);
      },
      error: error =>(console.log(error))
    })
  }

  published(){
    this.publicationsService.createPublication(this.createPublicationForm.value.city || '',this.createPublicationForm.value.nbJ || '',
    this.createPublicationForm.value.price || '' ,this.createPublicationForm.value.idAnimal || '').subscribe({
      next: (res:any) => {
        this.router.navigate(['/']);
      },
      error: error => (console.log(error))
    })
  }

}
