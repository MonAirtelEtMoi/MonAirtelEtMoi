package lab.synah.cd.monairteletmoi.model;

import java.io.Serializable;

/**
 * Created by Michelo on 04/01/16.
 */
public class Commande implements Serializable {

        private String name;
        private String description;
        private String image;


        public Commande() {
        }


        public Commande(String name,String description,String image) {
            this.name = name;
            this.description = description;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

}
