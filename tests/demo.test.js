var should = require("should");
var User = function(name) {
	this.name = name;
}
describe("Vérification de la création de l'utilisateur", function() {
	it ("Création de l'utilisateur avec le bon nom", function() {
		debugger
		var tom = new User("tom");
		tom.name.should.be.equal("tom");
	});
});