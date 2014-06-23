package com.persinfo.utilities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.google.appengine.api.rdbms.AppEngineDriver;

public final class EMF {
    private static final EntityManagerFactory emfInstance =
        Persistence.createEntityManagerFactory("transactions-optional");

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}
