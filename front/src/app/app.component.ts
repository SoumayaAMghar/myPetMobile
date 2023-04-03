import { Component } from '@angular/core';
import { PublicationsService } from './publications.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  // isActive: boolean = localStorage.getItem('token') != null || undefined ?true:false;
  logeed : boolean = this.publicationsService.isLogeed;

  constructor(private publicationsService:PublicationsService){
    // this.publicationsService.isActive = localStorage.getItem('token') != null || undefined ?true:false;
  }


}
