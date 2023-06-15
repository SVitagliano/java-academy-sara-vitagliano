function somma(x, y){
	const sum=x+y;
	console.log('Esercizio 1');
	console.log(sum);
	
}

function differenza(x, y){
	const diff=x-y;
	console.log(diff);
}

function moltiplicazione(x, y){
	const prod=x*y;
	console.log(prod);
}

function divisione(x, y){
	const result= x/y;
	console.log(result);
}

function resto(x, y){
	const mod= x%y;
	console.log(mod);
}

function media(array){
	
	var sum=0;
	var media;
	for(var i=0; i<array.length; i++){
		sum=sum+array[i];
	}
	media=sum/array.length;
	console.log(media);
}

function paridispari(x){
	if(x%2==0){
		console.log('pari');
	}else{
		console.log('dispari');
		}
}

function magminuguale(x,y){
	if(x>y){
		console.log('maggiore');
	}else if (x<y){
		console.log ('minore');
		}else{
			console.log ('uguale');
		}
}

function stringavuota(x){
	if(x===""){
		console.log('vuota');
		}else{
			console.log('non vuota');
			}
}

function sottostringa(x){
	return x.includes("ciao");
}

function vocaleOconsonante(x){
	if(x=='a' || x=='e' || x=='i' || x=='o' || x=='u'){
		console.log('vocale');
	}else{
		console.log('consonante');
	}
}

function divisibile3_5(x){
	
	if(x%3==0 && x%5!=0){
		console.log('divisibile per 3');
		
	}else if(x%5==0 && x%3!=0){
		console.log('divisibile per 5');
	}
	else if (x%3==0 && x%5==0){
		console.log('divisibile per 3 e per 5');
	}else{
		console.log('non divisibile');
	}
}

function arrayInteri(){
	let array=[1,2,3];
	console.log(array);
}

function cercaArray(x){
	let array=[1,2,3];
	
	for(let i=0;i<3;i++){
		if(x==array[i]){
			return true;
		} return false;
	}
}

function unisciArray(x,y){
	return x.concat(y);
	
}

function estraiArray(x){
	const arrayPari=x.filter();
	console.log(arrayPari);
}

function estraiArray(x){
	const array=x.filter(x=>x.length>5);
	console.log(array);
}

function creaOggetto(){
	
	const person={
		firstname: "Sara", 
		lastname: "Vitagliano", 
		datadinascita: "31/05/1999",
		};
		return person;
}

function accedeProprietà(){
	const obj=creaOggetto();
	console.log(obj.firstname);
	
}

function sottofunzione(x,y){
	
	somma(x,y);
}

function doppio(x){
	const doppio=(2*x);
	console.log(doppio)
}

function lunghezzaStringa(x){
	const lunghezza=x.length();
	console.log(lunghezza); 
}
