import { Component } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { PublicationsService } from './../publications.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  token:any={  }
  loginForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl(''),
  });

  constructor(private publicationsService:PublicationsService ,private router:Router) {
  }

  ngOnInit(): void {
    if(localStorage.getItem('token'))
      this.router.navigate(['/']);
  }

  onSubmit(){
    this.publicationsService.logeed(this.loginForm.value.email || '',this.loginForm.value.password || '' ).subscribe({
      next: (data:any) => {
        localStorage.setItem('token',data.accessToken);
        this.publicationsService.isLogeed = true;
        this.router.navigate(['/']);
      },
      error: error => (alert("verify your information"))
    })

  }
}
