import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { PublicationComponent } from './publication/publication.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MyanimalComponent } from './myanimal/myanimal.component';
import { AnimalComponent } from './animal/animal.component';
import { CreatePublicationComponent } from './create-publication/create-publication.component';
import { RequestComponent } from './request/request.component';

@NgModule({
  declarations: [
    AppComponent,
    PublicationComponent,
    LoginComponent,
    RegisterComponent,
    MyanimalComponent,
    AnimalComponent,
    CreatePublicationComponent,
    RequestComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
