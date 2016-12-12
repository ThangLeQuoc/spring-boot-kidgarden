import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ArticleComponent } from './article/article.component';

//import { NewsDetailComponent } from './news-detail/news-detail.component';
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

    // {
    //     path: 'news/:category/post/:index',
    //     component: NewsDetailComponent
    // }

];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);

