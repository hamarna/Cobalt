package it.auties.whatsapp.listener;

import it.auties.whatsapp.api.Whatsapp;
import it.auties.whatsapp.model.contact.Contact;
import it.auties.whatsapp.socket.Socket;

public interface OnWhatsappNewContact extends Listener {
    /**
     * Called when {@link Socket} receives a new contact
     *
     * @param contact the new contact
     */
    void onNewContact(Whatsapp whatsapp, Contact contact);
}