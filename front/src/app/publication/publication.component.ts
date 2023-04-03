import { Component } from '@angular/core';
import { PublicationsService } from './../publications.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.css']
})
export class PublicationComponent {

  publication:any;
  check : boolean = this.publicationsService.isLogeed;

  commentForm = new FormGroup({
    message : new FormControl('')
  })

  constructor(private publicationsService:PublicationsService, private router:Router){
  }

  ngOnInit(): void {
    this.getPublications();
  }

  comment(id:number){
    this.publicationsService.createComment(this.commentForm.value.message || '',id).subscribe({
      next:(res:any) => {
        this.getPublications();
        this.commentForm.reset();
        this.router.navigate(['/']);
      },
      error:error => (alert(error))
    })
  }

  getPublications(){
    this.publicationsService.getPublications().subscribe(res=>{
      this.publication = res;
      console.log(this.publication);
    })
  }

  apply(idPub:string){
    // this.publicationsService.applyPost(idPub).subscribe({
    //   next:(res:any) => {
    //     alert("apply")
    //   },
    //   error:error => (alert("not apply"))
    // })
    console.log(idPub);
  }

}
