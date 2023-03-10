import java.io.RandomAccessFile;

public class App {
    static int pointer = 0;
    static final String NOME = "{'name': '";
    static final String HEIGHT = ", 'height': '";
    static final String MASS = ", 'mass': '";
    static final String HAIR_COLOUR = "'hair_color': '";
    static final String SKIN_COLOUR = ", 'skin_color': '";
    static final String EYE_COLOUR = "'eye_color': '";
    static final String BIRTH_YEAR = "'birth_year': '";
    static final String GENDER = "'gender': '";
    static final String HOMEWORLD = "'homeworld': '";

    public static void main(String[] args) {
        String input = "";
        try {
            while (!input.equals("FIM")) {
                Personagem personagem = new Personagem();
                RandomAccessFile raf = new RandomAccessFile(MyIO.readLine(), "r");
                String line = raf.readLine();
                personagem.setName(extractAtribute(NOME, line));
                tratarHeight(extractAtribute(HEIGHT, line), personagem);
                tratarMass(extractAtribute(MASS, line), personagem);
                personagem.setHairColour(extractAtribute(HAIR_COLOUR, line));
                personagem.setSkinColour(extractAtribute(SKIN_COLOUR, line));
                personagem.setEyeColour(extractAtribute(EYE_COLOUR, line));
                personagem.setBirthYear(extractAtribute(BIRTH_YEAR, line));
                personagem.setGender(extractAtribute(GENDER, line));
                personagem.setHomeworld(extractAtribute(HOMEWORLD, line));
                pointer = 0;
                personagem.imprimir();
            }
        } catch (Exception e) {
            
        }
    }
    public static void tratarHeight(String str, Personagem personagem){
        if (str.equals("unknown")) {
            personagem.setHeight(0);
        } else {
            personagem.setHeight(Integer.parseInt(str));
        }
    }
    public static void tratarMass(String str, Personagem personagem){
        String nova = str.replace(',', '.');
        if (nova.equals("unknown")) {
            personagem.setWeight(0);
        } else {
            personagem.setWeight(Double.parseDouble(nova));
        }
    }
    public static String extractAtribute(String atribute, String line) {
        // Sempre passar o indice que vamos começar a percorrer a linhha;
        char separator = '\'';
        String res = "";
        int aux = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = aux; i < line.length(); i++) {
            sb.append(line.charAt(i));
            if (sb.toString().contains(atribute)) {
                int inicioNomeIndex = sb.toString().lastIndexOf(atribute) + atribute.length();
                pointer = inicioNomeIndex;
                while (line.charAt(pointer) != separator) {
                    aux++;
                    pointer++;// Indice final de onde acaba o atributo
                }
                res = line.substring(inicioNomeIndex, pointer);
                sb = null;
                return res;
            }
        }
        return null;
    }
}
