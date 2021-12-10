package game.model;
public class Tienda {

        private String nombreTienda;
        private String nombreCiudad;


        public Tienda(String nombreTienda, String nombreCiudad) {
            this.nombreTienda = nombreTienda;
            this.nombreCiudad = getNombreCiudad();
        }

        public String getNombreTienda() {
            return nombreTienda;
        }

        public void setNombreTienda(String nombreTienda) {
            this.nombreTienda = nombreTienda;
        }

        public String getNombreCiudad() {
            return nombreCiudad;
        }

        public void setNombreCiudad(String nombreCiudad) {
            this.nombreCiudad = nombreCiudad;
        }
}
