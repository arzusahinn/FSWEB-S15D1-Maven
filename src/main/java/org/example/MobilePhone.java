package org.example.mobile;

import java.util.ArrayList;
import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;

    // Orijinal constructor (Tek parametre alıyor)
    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>();
    }

    // YENİ EKLENEN constructor (Hem String hem de List alıyor)
    // Bu constructor, test dosyanızdaki hatalı çağrıyı desteklemek için eklendi.
    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public List<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact " + contact.getName() + " zaten mevcut.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int foundPosition = findContact(oldContact.getName());
        if (foundPosition < 0) {
            System.out.println("Contact bulunamadı.");
            return false;
        }
        this.myContacts.set(foundPosition, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        int foundPosition = findContact(contact.getName());
        if (foundPosition < 0) {
            System.out.println("Contact bulunamadı.");
            return false;
        }
        this.myContacts.remove(foundPosition);
        return true;
    }

    public int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    public int findContact(String contactName) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void printContact() {
        System.out.println("Contact List:");
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }
}