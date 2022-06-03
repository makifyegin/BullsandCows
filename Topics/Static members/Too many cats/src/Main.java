
class Cat {

    // write static and instance variables
    static int counter;
    String name;
    int age;

    final int number = 5;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
        counter++;
        if (counter > number) {
            System.out.println("You have too many cats");
        }
        // implement the constructor
        // do not forget to check the number of cats
    }

    public static int getNumberOfCats() {
        // implement the static method
        return counter;
    }


}