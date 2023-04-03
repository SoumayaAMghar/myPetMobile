import { Component } from '@angular/core';
import { FormGroup,FormControl } from '@angular/forms';
import { PublicationsService } from './../publications.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  registerForm = new FormGroup({
    first_name: new FormControl(''),
    last_name: new FormControl(''),
    email: new FormControl(''),
    adresse: new FormControl(''),
    password: new FormControl(''),
    numberPhone: new FormControl(''),
  })

  constructor(private publicationsService:PublicationsService ,private router:Router) {
  }

  registred(){
    console.log(this.registerForm.value)
    this.publicationsService.register(this.registerForm.value.first_name || '',this.registerForm.value.last_name || '',this.registerForm.value.email || '',
      this.registerForm.value.password || '',this.registerForm.value.numberPhone || '',this.registerForm.value.adresse || '').subscribe({
        next:(data:any) => {
          console.log("errr")
          this.router.navigate(['/login']);
          console.log("eddd")
        },
        error: error =>(
          console.log(error)
          )
      })
  }

}
