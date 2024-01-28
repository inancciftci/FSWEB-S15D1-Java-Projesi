package com.inanc.arrayList;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class MobilePhone {
    private String myPhone;
    private ArrayList<Contact> contacts;

    public MobilePhone(String myPhone) {
        this.myPhone = myPhone;
        this.contacts = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact) {
        if(null == contact || null == contact.getName() || null == contact.getPhoneNumber())
            return false;
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        this.contacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int oldContactIndex = findContact(oldContact.getName());
        if (oldContactIndex < 0) {
            return false;
        }
        this.contacts.set(oldContactIndex, newContact);
        return true;
    }

    public boolean removeContact(Contact contact) {
        if (findContact(contact.getName()) < 0) {
            return false;
        }
        this.contacts.remove(contact);
        return true;
    }

    public int findContact(Contact contact) {
        return this.contacts.indexOf(contact);
    }

    public Contact queryContact(String contactName) {
        int index = findContact(contactName);
        if (index >= 0) {
            return this.contacts.get(index);
        }
        return null;
    }

    public int findContact(String contactName) {
        for (int i = 0; i < this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            if (contact.getName().equalsIgnoreCase(contactName)) {
                return i;
            }
        }
        return -1;
    }

    public void printContacts() {
        for (int i = 0; i < this.contacts.size(); i++) {
            Contact contact = this.contacts.get(i);
            System.out.println((i + 1) + "->" + contact.getName() + "->" + contact.getPhoneNumber());
        }
    }
}