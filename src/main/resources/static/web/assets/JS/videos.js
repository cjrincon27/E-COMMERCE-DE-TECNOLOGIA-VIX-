window.addEventListener('scroll',()=>{
    let videoMundo= document.getElementById('mundo-girando')
    let videoCelular= document.getElementById('video-celular')
    let titulo1= document.getElementById('titulo1')
    let titulo2= document.getElementById('titulo2')
    let titulo3= document.getElementById('titulo3')
    let titulo4= document.getElementById('titulo4')
    let imagenTitulo1= document.getElementById('imagen-titulo1')
    let imagenTitulo2= document.getElementById('imagen-titulo2')
    let imagenTitulo3= document.getElementById('imagen-titulo3')
    let imagenTitulo4= document.getElementById('imagen-titulo4')
    let posicionVideoCelular = videoCelular.getBoundingClientRect().top
    let posicionVideoCelularbot = videoCelular.getBoundingClientRect().bottom
    let posicionTitulo1 = titulo1.getBoundingClientRect().top
    let posicionTitulo2 = titulo2.getBoundingClientRect().top
    let posicionTitulo3 = titulo3.getBoundingClientRect().top
    let posicionTitulo4 = titulo4.getBoundingClientRect().top
    let pantallaVideoCelular2 = window.innerHeight/3
    let pantallaVideoCelular4 = window.innerHeight*1.5
    let pantallaVideoCelular5 = window.innerHeight/5
    
  
    
    if(posicionTitulo1 < pantallaVideoCelular5){
        titulo1.classList.add("animacionParaTitulosizquierda")
        titulo1.classList.remove("displaynone")
     /*    imagenTitulo1.classList.add("animacionParaTitulosDerecha")
        imagenTitulo1.classList.remove("displaynoneimagen") */
    }
    if(posicionTitulo1 > pantallaVideoCelular5){
        titulo1.classList.add("displaynone")
        titulo1.classList.remove("animacionParaTitulosizquierda")
      /*   imagenTitulo1.classList.remove("animacionParaTitulosDerecha")
        imagenTitulo1.classList.add("displaynoneimagen") */
    }
    if(posicionTitulo2 < pantallaVideoCelular5){
        titulo2.classList.add("animacionParaTitulosDerecha")
        titulo2.classList.remove("displaynone")
       /*  imagenTitulo1.classList.add("animacionParaTitulosizquierda")
        imagenTitulo1.classList.remove("displaynoneimagen") */
    }
    if(posicionTitulo2 > pantallaVideoCelular5){
        titulo2.classList.add("displaynone")
        titulo2.classList.remove("animacionParaTitulosDerecha")
    }
    if(posicionTitulo3 < pantallaVideoCelular5){
        titulo3.classList.add("animacionParaTitulosizquierda")
        titulo3.classList.remove("displaynone")
    }
    if(posicionTitulo3 > pantallaVideoCelular5){
        titulo3.classList.add("displaynone")
        titulo3.classList.remove("animacionParaTitulosizquierda")
    }
    if(posicionTitulo4 < pantallaVideoCelular5){
        titulo4.classList.add("animacionParaTitulosDerecha")
        titulo4.classList.remove("displaynone")
     
            videoMundo.classList.add("cambiar-posicionamiento")
          setTimeout( () => {
               
                videoMundo.style.display = "none"
                videoCelular.play()
            }, 1000);
    
        
        
    }
    if(posicionTitulo4 > pantallaVideoCelular5){
        titulo4.classList.add("displaynone")
        titulo4.classList.remove("animacionParaTitulosDerecha")
        videoMundo.classList.remove("cambiar-posicionamiento")
        videoMundo.style.display = "block"
        videoCelular.pause()
    }
    
    if(posicionVideoCelular < pantallaVideoCelular4){
        videoMundo.style.animation = "none"
    }
   /*  if(posicionVideoCelular > pantallaVideoCelular3 ){
        videoMundo.classList.remove("cambiar-posicionamiento")
        videoMundo.style.display = "block"
        videoCelular.pause()
    } */
    if(posicionVideoCelular < pantallaVideoCelular2 ){
        
        videoMundo.style.display = "none"
    }
    if(posicionVideoCelularbot < -500){
        videoCelular.pause()
    }
   
    
        
   
    /* if(posicionVideoCelular < pantallaVideoCelular6 ){
        videoMundo.classList.add("cambiar-posicionamiento")
      setTimeout( () => {
           
            videoMundo.style.display = "none"
            videoCelular.play()
        }, 1000);

    } */
  
})