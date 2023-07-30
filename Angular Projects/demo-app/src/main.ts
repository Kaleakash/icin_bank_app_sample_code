import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';

// it provide main module details. 
platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
