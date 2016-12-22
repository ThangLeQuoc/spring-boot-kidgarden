export class Article {
    article_id: String;
    header: String;
    headerdescription: String;
    headerimage: String;
    location: String;
    date: String;
    note: String;
    dayofpublish: String;
    content: String;
    source: String;
    category_id: String;
    editor: String;

    constructor(){
        this.resetField();
    }

    resetField(){
        this.article_id = '';
        this.header = '';
        this.headerdescription = '';
        this.headerimage = '';
        this.location = '';
        this.date = '';
        this.note = '';
        this.dayofpublish = '';
        this.content = '';
        this.source = '';
        this.category_id = '';
        this.editor = '';
    }
}