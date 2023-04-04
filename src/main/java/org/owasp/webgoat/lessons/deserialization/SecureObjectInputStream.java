package org.owasp.webgoat.lessons.deserialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SecureObjectInputStream extends ObjectInputStream {

    public SecureObjectInputStream(InputStream in) throws IOException {
        super(in);
    }

    @Override
    protected Class<?> resolveClass(ObjectStreamClass osc) throws IOException, ClassNotFoundException {

        List<String> approvedClasses = new ArrayList<String>();
        //approvedClasses.add(AllowedClass1.class.getName());
        //approvedClasses.add(AllowedClass2.class.getName());
        approvedClasses.add("1");
        if (!approvedClasses.contains(osc.getName())) {
            throw new InvalidClassException("Unauthorized deserialization", osc.getName());
        }


        return super.resolveClass(osc);
    }
}
