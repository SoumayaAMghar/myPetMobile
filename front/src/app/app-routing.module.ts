import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { PublicationComponent } from './publication/publication.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AnimalComponent } from './animal/animal.component';
import { MyanimalComponent } from './myanimal/myanimal.component';
import { CreatePublicationComponent } from './create-publication/create-publication.component';
import { RequestComponent } from './request/request.component';

const routes: Routes = [
  {path:"", component:PublicationComponent},
  {path:'login', component:LoginComponent},
  {path:"register",component:RegisterComponent},
  {path:"create_animal",component:AnimalComponent},
  {path:"my_animal",component:MyanimalComponent},
  {path:"create_publication",component:CreatePublicationComponent},
  {path:"my_request",component:RequestComponent},

];

@NgModule({
  declarations: [

  ],
  imports: [
CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }
