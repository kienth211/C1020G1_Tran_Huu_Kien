import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {FontSizeEditorComponent} from './font-size-editor/font-size-editor.component';
import {FormsModule} from '@angular/forms';
import {PetComponent} from './pet/pet.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { ColorComponent } from './color/color.component';

@NgModule({
  declarations: [
    AppComponent,
    FontSizeEditorComponent,
    PetComponent,
    CalculatorComponent,
    ColorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    [RouterModule.forRoot([
      {path: 'bai3/fontsize', component: FontSizeEditorComponent},
      {path: 'bai3/pet', component: PetComponent},
      {path: 'bai3/calculator', component: CalculatorComponent},
      {path: 'bai3/color', component: ColorComponent}
    ])]
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
