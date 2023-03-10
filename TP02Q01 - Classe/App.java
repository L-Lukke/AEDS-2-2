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
                System.out.println(input);
                String heightM;
                String massM;
                Personagem personagem = new Personagem();
                RandomAccessFile raf = new RandomAccessFile(MyIO.readLine(), "r");
                String line = raf.readLine();
                personagem.setName(extractAtribute(NOME, line, pointer));
                //Tratar "Unknow"
                personagem.setHeight(Integer.parseInt(extractAtribute(HEIGHT, line, pointer)));
                personagem.setWeight(Double.parseDouble(extractAtribute(MASS, line, pointer)));
                personagem.setHairColour(extractAtribute(HAIR_COLOUR, line, pointer));
                personagem.setSkinColour(extractAtribute(SKIN_COLOUR, line, pointer));
                personagem.setEyeColour(extractAtribute(EYE_COLOUR, line, pointer));
                personagem.setBirthYear(extractAtribute(BIRTH_YEAR, line, pointer));
                personagem.setGender(extractAtribute(GENDER, line, pointer));
                personagem.setHomeworld(extractAtribute(HOMEWORLD, line, pointer));
                pointer = 0;
                personagem.imprimir();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String extractAtribute(String atribute, String line, int pos) {
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
