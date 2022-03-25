public class Country {
    public String nameCountry;   //Название.
    public int population;      // Численность населения.
    public int areaSquareKm;     //Площадь в квадратных километрах.
    public String nameCapital;   // Название столицы.

    public boolean accessSea;    // Выход к морю.

    public Country(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public void setNameCountry(String nameCountry) {
        this.nameCountry = nameCountry;
    }
    public String getNameCountry() {
        return nameCountry;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public int getPopulation() {
        return population;
    }
    public void setAreaSquareKm(int areaSquareKm) {
        this.areaSquareKm = areaSquareKm;
    }
    public int getAreaSquareKm() {
        return areaSquareKm;
    }
    public void setNameCapital(String nameCapital) {
        this.nameCapital = nameCapital;
    }
    public String getNameCapital() {
        return nameCapital;
    }
    public void setAccessSea(boolean accessSea) {
        this.accessSea = accessSea;
    }
    public boolean isAccessSea() {
        return accessSea;
    }

    public void print(String tittle) {
        System.out.println(tittle);
        System.out.println(nameCountry);
    }

}



