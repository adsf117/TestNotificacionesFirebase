package com.andres.emisortestfirebase.entris;

/**
 * Created by andresdavid on 14/10/16.
 */
public class SendNotificationObj {

    public Notificacion notificacion;
    public String to;

    public Notificacion getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(Notificacion notificacion) {
        this.notificacion = notificacion;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
