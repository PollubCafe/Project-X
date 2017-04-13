import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HelloComponent } from './hello/hello.component';
import { CalendarComponent } from './calendar/calendar.component';
import { HomeComponent } from './home/home.component';
import { UserComponent } from './user/user.component';

const appRoutes: Routes = [
    {path: '', component: HomeComponent},
    {path: 'calendar', component: CalendarComponent},
    {path: 'hello', component: HelloComponent},
    {path: 'user', component: UserComponent},
];

export const appRouterProviders: any[] = [];

export const routing: ModuleWithProviders =
  RouterModule.forRoot(appRoutes);
