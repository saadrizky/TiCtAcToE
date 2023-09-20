package haish;

public class Person {
    String name;
    String address;
    final String country = "Indonesia";

    Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    Person(String paramName) {
        this(paramName, null);// ini sama seperti memanggil CONSTRUCTOR diatas (2 parameter) tapi hanya
                              // mengambil value paramName
    }

    Person() {
        this(null); // sbenarnya tidak perlu tetapi, ini sama seperti memanggil CONSTRUCTOR diatas
                    // (1 parameter) tapi tidak memanggil apa2
    }

    void sayHello(String name) {
        System.out.println("Hello" + name + ", my name is " + this.name);
    }

}
