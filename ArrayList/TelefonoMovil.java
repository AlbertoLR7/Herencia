package ArrayList;

import java.util.ArrayList;

public class TelefonoMovil {
    private String myNumber;
    private ArrayList<Contacto> myContacts;

    public TelefonoMovil(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    public boolean addNewContact(Contacto contacto) {
        if (findContact(contacto) >= 0) {
            return false;
        }
        myContacts.add(contacto);
        return true;
    }

    public boolean updateContact(Contacto contactoAntiguo, Contacto contactoNuevo) {
        int antiguo = findContact(contactoAntiguo);
        if (antiguo < 0) {
            return false;
        }

        int nuevo = findContact(contactoNuevo);
        if (nuevo >= 0) {
            return false;
        }
        myContacts.set(antiguo, contactoNuevo);
        return true;
    }

    public boolean removeContact(Contacto contacto) {
        int index = findContact(contacto);
        if (index < 0) {
            return false;
        }

        myContacts.remove(index);
        return true;
    }

    public Contacto queryContact(String name) {

        int index = findContact(name);
        if (index >= 0) {
            return myContacts.get(index);
        }
        return null;
    }

    public void printContacts() {

        System.out.println("Lista de contactos:");
        for (int i = 0; i < myContacts.size(); i++) {
            Contacto c = myContacts.get(i);
            System.out.println((i + 1) + ". " + c.getName() + " -> " + c.getPhoneNumber());
        }
    }

    private int findContact(Contacto contacto) {
        return myContacts.indexOf(contacto);
    }

    private int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
