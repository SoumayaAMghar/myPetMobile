import { Component } from '@angular/core';
import { PublicationsService } from './../publications.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-request',
  templateUrl: './request.component.html',
  styleUrls: ['./request.component.css']
})
export class RequestComponent {

  requests:any;

  constructor(private publicationsService:PublicationsService,private router:Router){
  }

  ngOnInit(): void {
    if(!localStorage.getItem('token'))
      this.router.navigate(['/']);
  }



}
