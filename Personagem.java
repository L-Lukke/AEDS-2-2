import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

class Personagem {
    private String name;
    private int height;
    private double weight;
    private String hairColour;
    private String skinColour;
    private String eyeColour;
    private String birthYear;
    private String gender;
    private String homeworld;

    public Personagem() {
    }

    public Personagem(String name, int height, double weight, String hairColour, String skinColour, String eyeColour,
            String birthYear,
            String gender, String homeworld) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.hairColour = hairColour;
        this.skinColour = skinColour;
        this.eyeColour = eyeColour;
        this.birthYear = birthYear;
        this.gender = gender;
        this.homeworld = homeworld;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getHairColour() {
        return hairColour;
    }

    public String getSkinColour() {
        return skinColour;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public void setSkinColour(String skinColour) {
        this.skinColour = skinColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public Personagem clone() {
        Personagem cloned = new Personagem();

        cloned.name = this.name;
        cloned.height = this.height;
        cloned.weight = this.weight;
        cloned.hairColour = this.hairColour;
        cloned.skinColour = this.skinColour;
        cloned.eyeColour = this.eyeColour;
        cloned.birthYear = this.birthYear;
        cloned.gender = this.gender;
        cloned.homeworld = this.homeworld;

        return cloned;
    }

    public void imprimir() {
        DecimalFormat numberFormat = new DecimalFormat();
        numberFormat.setMinimumFractionDigits(0);
        numberFormat.setGroupingUsed(false);
        System.out.println(" ## " + name + " ## " + height + " ## " + numberFormat.format(weight) + " ## " + hairColour + " ## "
                + skinColour + " ## " + eyeColour + " ## " + birthYear + " ## " + gender + " ## " + homeworld + " ## ");
    }

    public String addToAuxString(String line, String att) {
        String aux = "";

        if(line.lastIndexOf(att) > 0) {
            int cont = 0;
            for (int i = line.lastIndexOf(att); cont < 3; i++) {
                if (line.charAt(i) == '\'')
                cont++;
                if (line.charAt(i) != '\'' && line.charAt(i) != ':') {
                    if (line.charAt(i) != '{'){
                        aux += line.charAt(i);
                    }
                }
            }
        }

        aux = aux.replace(att, " ");
        aux = aux.trim();
        return aux;
    }

    public String addToAuxStringW(String line, String att) {
        String aux = "";

        if(line.lastIndexOf(att) > 0) {
            int cont = 0;
            for (int i = line.lastIndexOf(att); cont < 3; i++) {
                if (line.charAt(i) == '\'')
                cont++;
                if (line.charAt(i) != '\'' && line.charAt(i) != ':') {
                    if (line.charAt(i) != '{' && line.charAt(i) != ','){
                        aux += line.charAt(i);
                    }
                }
            }
        }

        aux = aux.replace(att, " ");
        aux = aux.trim();
        return aux;
    }

    public void ler(String path) throws Exception {
        try {
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String line = myReader.nextLine();
                    setName(addToAuxString(line, "name"));
                    if(addToAuxString(line, "height").contains("unknown"))
                    setHeight(0);
                    else
                    setHeight(Integer.parseInt(addToAuxString(line, "height")));
                    if(addToAuxString(line, "mass").contains("unknown"))
                    setWeight(0);
                    else
                    setWeight(Double.parseDouble(addToAuxStringW(line, "mass")));
                    setHairColour(addToAuxString(line, "hair_color"));
                    setSkinColour(addToAuxString(line, "skin_color"));
                    setEyeColour(addToAuxString(line, "eye_color"));
                    setBirthYear(addToAuxString(line, "birth_year"));
                    setGender(addToAuxString(line, "gender"));
                    setHomeworld(addToAuxString(line, "homeworld"));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}