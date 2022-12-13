
const { createApp } = Vue
createApp({
  data() {
    return {
      ticketPurchase:'',
      buyer:'',
      urlCurrent:"/api/buyer/current",
      tickets:[],
        
    }
   
  },
  created() {
    this.clienteAutenticado(this.urlCurrent)
 
   
  },
  

  methods: {
    clienteAutenticado(URL){
      axios.get(URL)
      .then(response => {
        this.buyer = response.data
        this.tickets = this.buyer.ticketPurchases
        this.tickets.sort((a, b)=> 
        { if (a.id > b.id)
            {return -1} 
            if (a.id < b.id){ return 1}

        })
        console.log(this.tickets);
     
      
      })

    },
    logOut(){
      const swalWithBootstrapButtons = Swal.mixin({
          customClass: {
            confirmButton: '#212121',
            // cancelButton: '#212121'
          },
          buttonsStyling: true
        })
         swalWithBootstrapButtons.fire({
          background:'#dc1d1d',
          color:'white',
          title: 'Would you like to log out?',
         showCancelButton: false,
          confirmButtonColor: '#0a0a0a',
          confirmButtonText: 'Yes', 
          // cancelButtonText: 'No',
          reverseButtons: true
        }).then((result) => {
        if (result.isConfirmed) {
              Swal.fire({
                background:'#dc1d1d',
                  color:'white',
                  position: 'top-center',
                  title: 'You have logged out',
                  showConfirmButton: false,
                  timer: 10500
                })
              axios.post('/api/logout').then(response =>  window.location.href = '/index.html')
          }
        })
   },
   pdf(){
  
    window.location.href = "/api/buyer/pdf"
   }
    
  
    

  },
  computed:{
    
   

  }
}).mount('#app')