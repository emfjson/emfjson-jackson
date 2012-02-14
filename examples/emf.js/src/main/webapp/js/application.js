jQuery(function($){
	
	var 
		url = 'http://localhost:8080/api/resources',
		resourceSet = ecore.resourceSet;

	/*
	 * Models
	 */
	
	window.LibraryShelf = Backbone.Model.extend({
		url: '/libraries',
		
		initialize: function(name, items) {
			if (items){
				this.set({name: name, items: items});
			} else {
				this.set({name: name, items: new Books});
			}
		}
	});
	
	window.LibraryShelfList = Backbone.Model.extend({
		model: LibraryShelf,
		
		localStorage: new Store("libraries")
	});
	
	window.Book = Backbone.Model.extend({
		url: '/libraries/{id}/books',
		
		initialize: function(title, nbPages) {
			this.set({title: title, nbPages: nbPages});
		}
	});
	
	window.Books = Backbone.Collection.extend({
		model: Book
	});
	
	
	/*
	 * Views
	 */
	
	window.BookView = Backbone.View.extend({
		render: function(){
			console.log("call book render");
		}
		
	});
	
	window.BooksView = Backbone.View.extend({
		initialize: function(){
			_.bindAll(this, 'render');
			this.model.bind('change', this.render);
		}
	});
	
	window.LibraryShelfView = Backbone.View.extend({
		el: $("#library-tab-pane"),
		template: $("#compartmentPropertiesTemplate"),
		templateNav: $("#libraryNavTemplate"),
		templateSidebar: $("#librarySidebarTemplate"),
		
		initialize: function(){
			console.log('init shelf view');
			Books.bind('add', this.addBook, this);
		},
		
		render: function(){
			var data = {id: 'library',  values: [{Name: this.model.get("name")}]};
			var content = jQuery.tmpl(this.template, data);
			var tab = jQuery.tmpl(this.templateNav, data);
			$("#model-nav-tab-content").html(tab);
			$("#model-tab-content").append('<div id="library-tab-pane" class="tab-pane active span10"></div>');
			$("#model-tab-content").html(content);
			
			return this;
		},
		
		addBook: function(book){
			var view = new BookView({model: book});
			this.$("#library-tab-pane").append(view.render().el);
		}
	});
	
	var data = {
		name: "SciFi",
		items: [
		    {title: "Fondation", pages: 123},
		    {title: "Watchmen", pages: 400}
		]
	};
	
	/*
	 * App
	 */
	
	window.AppView = Backbone.View.extend({
		el: $("#content"),
		
		initialize: function(){
			
			Books.bind('add', this.addBook);
			
			var all = new LibraryShelfList([data]);
			
			console.log(all);
			
			console.log("created shelf "+all);
			_.map(all, function(lib){console.log(lib);});
//			var view = new LibraryShelfView({model: libraryShelf});
			
//			view.render();
		},
		
		addBook: function(book){
			console.log("add Book")
			var view = new BookView({model: book});
			this.$("#library-tab-pane").append(view.render().el);
		}
		
	});
	
	window.Libraries = new LibraryShelfList;
	window.App = new AppView;
	
//	createBook = function(){
//		var title = $("#book-form > input[name='title']").val();
//		var date = $("#book-form > input[name='date']").val();
//		var pages = $("#book-form > input[name='pages']").val();
//		
//		$("#modal-book").modal('hide');
//		$("#createItem").tmpl({data: [{"title":title, "pubDate":date, "numPages":pages}]}).appendTo($("#Items-table"));
//		return;
//	};
//	
//	createDVD = function(){
//		console.log($("#multimedia-form"));
//		console.log();
//		var title = $("#multimedia-form > input[name='title']").val();
//		var date = $("#multimedia-form > input[name='date']").val();
//		var lth = $("#multimedia-form > input[name='length']").val();
//		
//		$("#modal-dvd").modal('hide');
//		$("#createItem").tmpl({data: [{"title":title, "pubDate":date, "_length": lth}]}).appendTo($("#Items-table"));
//		return;
//	};
	
});
