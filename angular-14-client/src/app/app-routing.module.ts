import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TutorialsListComponent } from './components/tutorials-list/tutorials-list.component';
import { TutorialDetailsComponent } from './components/tutorial-details/tutorial-details.component';
import { AddTutorialComponent } from './components/add-tutorial/add-tutorial.component';
import { HeroDetailComponent } from './components/hero-detail/hero-detail.component';
import { AddAeroclubComponent } from './components/add-aeroclub/add-aeroclub.component';
import { AeroclubDetailsComponent } from './components/aeroclub-details/aeroclub-details.component';
import { AeroclubListComponent } from './components/aeroclub-list/aeroclub-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'tutorials', pathMatch: 'full' },
  { path: 'tutorials', component: TutorialsListComponent },
  { path: 'aeroclub', component: AeroclubListComponent },
  { path: 'tutorials/:id', component: TutorialDetailsComponent },
  { path: 'aeroclub/:id', component: AeroclubDetailsComponent },
  { path: 'add', component: AddTutorialComponent },
  { path: 'addAeroclub', component: AddAeroclubComponent },
  { path: 'hero', component: HeroDetailComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }