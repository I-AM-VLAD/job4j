package ru.job4j.chapter_006.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VarsOutput {

    private static final Logger LOG = LoggerFactory.getLogger(VarsOutput.class.getName());

    public static void main(String[] args) {
        String var1 = "Vlad";
        int var2 = 33;
        long var3 = 350;
        byte var4 = 35;
        char var5 = 'V';
        boolean var6 = true;
        double var7 = 1.54;
        float var8 = 143;
        LOG.debug("var1 : {}, var2 : {}, var3 : {}, var4 : {}, " +
                "var5 : {}, var6 : {}, var7 : {}, var8 : {}",
                var1, var2, var3, var4, var5, var6, var7, var8);
    }
}

