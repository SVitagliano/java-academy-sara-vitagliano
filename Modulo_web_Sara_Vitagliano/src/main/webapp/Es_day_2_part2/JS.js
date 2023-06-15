function cambiaTesto(){
	document.getElementById("identificativo").innerHTML='mondo';
}

function cambiaTabella(){
	const elemento=document.getElementsByClassName("cella");
	elemento[0].innerHTML='a';
	elemento[1].innerHTML='a';
	elemento[2].innerHTML='a';
}

function immagine(){
	 const img=document.getElementById("meme");
	img.src="https://londra.io/wp-content/uploads/2021/10/Londra.jpg";
}

function go(){
	const array=["https://i.imgflip.com/7oxftb.jpg", "https://i.imgflip.com/7p00ku.jpg", "https://i.imgflip.com/7p495j.jpg", "https://i.imgflip.com/7o2w3k.jpg", "https://i.imgflip.com/7mozl6.jpg", "https://i.imgflip.com/7p1kff.jpg", "https://i.imgflip.com/7oxg1b.jpg", "https://i.imgflip.com/7p1284.jpg", "https://i.imgflip.com/7oyvec.jpg"];
	const img=document.getElementsByTagName("img");
	for(let i=0; i<array.length; i++){
		img[i].src=array[i];
	}
}