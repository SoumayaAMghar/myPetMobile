import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { PublicationsService } from './../publications.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-animal',
  templateUrl: './animal.component.html',
  styleUrls: ['./animal.component.css']
})
export class AnimalComponent {

  createAnimalForm = new FormGroup({
    name: new FormControl(''),
    birthday: new FormControl(''),
    animalKind: new FormControl(''),
    description: new FormControl(''),
    picture: new FormControl(''),
  });

  urlPic:any;

  constructor(private publicationsService:PublicationsService ,private router:Router) {
  }

  getFiledetials(element:any) {
    console.log(element.value);
  }

  localUrl: any = [];
  showPreviewImage(event: any) {
    if (event.target.files && event.target.files[0]) {
      var reader = new FileReader();
      reader.onload = (event: any) => {
        this.localUrl = event.target.result;
        this.urlPic = event.target.result;
        console.log(event.target.result)
        console.log(this.createAnimalForm.value.picture)
      }
      reader.readAsDataURL(event.target.files[0]);
    }
  }

  createAnimal(){
    this.createAnimalForm.value.picture = this.urlPic;
    console.log(this.createAnimalForm.value)
    this.publicationsService.createdAnimal(this.createAnimalForm.value.name || '',this.createAnimalForm.value.birthday || '',this.createAnimalForm.value.animalKind || '',
      this.createAnimalForm.value.description || '', this.createAnimalForm.value.picture || '').subscribe({
        next: (data:any) => {
          console.log(data)
          this.router.navigate(['/my_animal']);
        },
        error: error=>(alert(error))
      })
  }
}
