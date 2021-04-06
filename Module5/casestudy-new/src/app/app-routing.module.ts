import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {HomeComponent} from './components/home/home.component';
import {PageNotFoundComponent} from './components/page-not-found/page-not-found.component';
import {CustomerListComponent} from './components/customers/customer-list/customer-list.component';
import {CommonModule} from '@angular/common';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { FormsModule} from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';
import { CustomerCreateComponent } from './components/customers/customer-create/customer-create.component';
import { ReactiveFormsModule} from '@angular/forms';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'customer-list', component: CustomerListComponent},
  {path: 'customer-create', component: CustomerCreateComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    CommonModule,
    Ng2SearchPipeModule,
    FormsModule,
    NgxPaginationModule,
    ReactiveFormsModule
  ],
  exports: [RouterModule],
  declarations: [HomeComponent, PageNotFoundComponent, CustomerListComponent, CustomerCreateComponent]
})
export class AppRoutingModule {
}
