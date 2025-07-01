package tpprogramacion2;

public class Programa {
   
    private Usuario usuario;

    public Programa(Usuario usuario) {
        this.usuario = usuario;
    }
  
   public void login ( Menu menu ,BaseDeDatos db){
       boolean cerrarSesion= false;
       while(!cerrarSesion){
           try{
               cerrarSesion = menu.mostrarMenu(db, usuario);
               
           }catch(Exception e){
               System.out.println("ERROR: "+ e.getMessage()); 
               cerrarSesion =true;
           }
       }
           
   }
   
    
   
}

