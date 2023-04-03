import { Component } from '@angular/core';
import { PublicationsService } from './../publications.service';

@Component({
  selector: 'app-myanimal',
  templateUrl: './myanimal.component.html',
  styleUrls: ['./myanimal.component.css']
})
export class MyanimalComponent {

  myAnimal: any;

  constructor(private publicationsService:PublicationsService){
  }

  ngOnInit(): void {
    this.publicationsService.getMyAnimal().subscribe({
      next:(data: any) =>{
        console.log(data)
        this.myAnimal=data;
      }
    });
  }

}
