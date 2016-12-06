import { AngularKidgardenPage } from './app.po';

describe('angular-kidgarden App', function() {
  let page: AngularKidgardenPage;

  beforeEach(() => {
    page = new AngularKidgardenPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
