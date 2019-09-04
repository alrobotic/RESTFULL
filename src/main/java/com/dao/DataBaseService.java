package com.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

public class DataBaseService implements Serializable, Cloneable {

    private static final Logger log = LoggerFactory.getLogger(DataBaseService.class);

    //variables to keep in-memory datastore
    private double m;
    private double s;
    private String mensaje;



    private DataBaseService() {
        m = 0;
        s = 0;
        mensaje = "Hola...";
    }

    /**
     * Static Factory method of DataBaseService class
     *
     * @return singleton instance
     */
    public static synchronized DataBaseService getInstance() {
        return DataBaseServiceInstanceContainer.instance;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public double getS() {
        return s;
    }

    public void setS(double s) {
        this.s = s;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * This method ensures that the same singleton reference is returned when
     * the object is serialized and the deserialized back
     *
     * @return singleton instance
     */
    protected Object readResolve() {
        return DataBaseServiceInstanceContainer.instance;
    }

    /**
     * Private static instance holder.
     */
    private static final class DataBaseServiceInstanceContainer {
        static final DataBaseService instance = new DataBaseService();
    }

}
