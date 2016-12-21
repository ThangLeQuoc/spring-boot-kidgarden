import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ArticleComponent } from './article/article.component';
import { ArticleNewComponent } from './article-new/article-new.component';

import { ArticleDetailComponent } from './article-detail/article-detail.component';


import { AppComponent } from './app.component';
const appRoutes: Routes = [
    {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
    },
    {
        path: 'home',
        component: ArticleComponent
    },
    {
        path: ':categorypath/articles',
        component: ArticleComponent
    },
    {
        path: ':categorypath/articles/:id',
        component: ArticleDetailComponent
    },
    {
        path: 'administrator/create',
        component: ArticleNewComponent
    }

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);

