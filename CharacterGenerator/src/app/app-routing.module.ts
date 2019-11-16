import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CharacterComponent } from './components/character/character.component';
import { LoginComponent } from './components/login/login.component';


const routes: Routes = [{
  path: 'login',
  component: LoginComponent
//  path: 'character',
//  component: CharacterComponent
}, {
  path: '',
  redirectTo: 'login',
  // redirectTo: '/character',
  pathMatch: 'full'
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
