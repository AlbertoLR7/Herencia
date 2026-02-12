package ArrayList;

public class Contacto {
    private String name;
    private String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contacto createContact(String name, String phoneNumber) {
        return new Contacto(name, phoneNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Contacto otro = (Contacto) obj;
        if (this.name == null) {
            if (otro.name != null) {
                return false;
            }
        } else if (!this.name.equals(otro.name)) {
            return false;
        }
        return true;
    }
}
