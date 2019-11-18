import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CharacterComponent } from './components/character/character.component';
import { LoginComponent } from './components/login/login.component';
import { InfoComponent } from './components/info/info.component';
import { SpellsComponent } from './components/spells/spells.component';
import { ProfileComponent } from './components/profile/profile.component';


const routes: Routes = [{
  path: 'login',
  component: LoginComponent
}, {
  path: '',
  redirectTo: 'login',
  //redirectTo: 'character',
  pathMatch: 'full'
}, {
  path: 'character',
  component: CharacterComponent,
}, {
  path: 'profile',
  component: ProfileComponent
}, {
  path: 'info',
  component: InfoComponent
}, {
  path: 'spells',
  component: SpellsComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
