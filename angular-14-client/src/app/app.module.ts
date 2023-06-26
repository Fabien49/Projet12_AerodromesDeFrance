import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddTutorialComponent } from './components/add-tutorial/add-tutorial.component';
import { TutorialDetailsComponent } from './components/tutorial-details/tutorial-details.component';
import { TutorialsListComponent } from './components/tutorials-list/tutorials-list.component';
import { HeroDetailComponent } from './components/hero-detail/hero-detail.component';
import { AddAeroclubComponent } from './components/add-aeroclub/add-aeroclub.component';
import { AddTarifComponent } from './components/add-tarif/add-tarif.component';
import { AeroclubDetailsComponent } from './components/aeroclub-details/aeroclub-details.component';
import { AeroclubListComponent } from './components/aeroclub-list/aeroclub-list.component';


@NgModule({
  declarations: [
    AppComponent,
    AddTutorialComponent,
    TutorialDetailsComponent,
    TutorialsListComponent,
    AddAeroclubComponent,
    AddTarifComponent,
    AeroclubDetailsComponent,
    AeroclubListComponent,
    HeroDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
