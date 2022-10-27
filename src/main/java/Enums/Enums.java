package Enums;

public class Enums {
    public enum Birds {

        BOLD_EAGLE("Haliaeetus leucocephalus"){
            @Override
            public void sing() {
                System.out.println(BOLD_EAGLE + ": kleek kik ik ik ik");
            }
        },

        HORNED_LARK("Eremophila aloestris") {
            @Override
            public void sing() {
                System.out.println(HORNED_LARK + ": pit-sit-tee-seep");
            }
        },

        TERN("Sterna hirundo") {
            @Override
            public void sing() {
                System.out.println(TERN + ": kee-arr");
            }
        },

        SNIPE("Gallinago gallinago") {
            @Override
            public void sing() {
                System.out.println(SNIPE + ": wicka-wicka-wicka");
            }
        };

        Birds(String s) {
            this.scientificName = s;

        }

        public final String scientificName;
        public abstract void sing();
    }


    public static void main(String[] args) {
        Birds.TERN.sing();
        Birds.HORNED_LARK.sing();
        Birds.SNIPE.sing();
        Birds eagle = Birds.BOLD_EAGLE;
        eagle.sing();
    }

}
